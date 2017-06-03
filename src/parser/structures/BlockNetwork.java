package parser.structures;

import parser.BasicBlock;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 3/10/17.
 */
public class BlockNetwork {
    public final String name;
    public final List<Id> args = new ArrayList<>();
    public final List<InternalDeclaration> internalDeclarations = new ArrayList<>();
    public final Set<String> typeDependencies = new LinkedHashSet<>();
    public final Map<String, String> nameToType = new HashMap<>();
    public final List<OutputDeclaration> outputDeclarations = new ArrayList<>();

    public BlockNetwork(String name) {
        this.name = name;
    }

    public void addArg(Id arg) {
        args.add(arg);
    }

    public void addInternalDeclaration(InternalDeclaration decl) {
        internalDeclarations.add(decl);
        nameToType.put(decl.name.name, decl.type.name);
        typeDependencies.add(decl.type.name);
    }

    public void addOutputDeclaration(OutputDeclaration decl) {
        outputDeclarations.add(decl);
    }

    public void sortModules() {
        // topological sorting

        // _Loop_breaks are allowed to be involved in cyclic dependencies
        // they are assumed to be executed in the beginning
        final List<InternalDeclaration> loopBreaks = internalDeclarations.stream()
                .filter(d -> d.type.name.equals("_Loop_break")).collect(Collectors.toList());
        final List<InternalDeclaration> newIntDecl = internalDeclarations.stream()
                .filter(d -> !d.type.name.equals("_Loop_break")).collect(Collectors.toList());
        internalDeclarations.clear();
        internalDeclarations.addAll(newIntDecl);

        final List<InternalDeclaration> newOrder = new ArrayList<>();
        final int[] color = new int[internalDeclarations.size()];
        for (int i = 0; i < internalDeclarations.size(); i++) {
            if (color[i] == 0) {
                dfs(i, newOrder, color);
            }
        }
        internalDeclarations.clear();
        internalDeclarations.addAll(loopBreaks);
        internalDeclarations.addAll(newOrder);
    }

    private void dfs(int v, List<InternalDeclaration> newOrder, int[] color) {
        color[v] = 1;

        for (int u = 0; u < internalDeclarations.size(); u++) {
            if (dependsOn(v, u)) {
                if (color[u] == 1) {
                    throw new RuntimeException("Cyclic dependency between modules!");
                } else if (color[u] == 0) {
                    dfs(u, newOrder, color);
                }
            }
        }
        color[v] = 2;
        newOrder.add(internalDeclarations.get(v));
    }

    private boolean dependsOn(int x, int y) {
        final InternalDeclaration xDecl = internalDeclarations.get(x);
        final String yName = internalDeclarations.get(y).name.name;
        for (Argument arg : xDecl.argList()) {
            if (arg instanceof CompositeId) {
                if (((CompositeId) arg).moduleName.name.equals(yName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MODULE " + name + args + "\n");
        internalDeclarations.forEach(e -> sb.append("block " + e + "\n"));
        outputDeclarations.forEach(e -> sb.append("output " + e + "\n"));
        return sb.toString();
    }

    public String toPromelaString(Map<String, BasicBlock> basicBlocks) {
        for (InternalDeclaration decl : internalDeclarations) {
            final String type = decl.type.name;
            final List<Argument> args = decl.argList();
            final BasicBlock b = basicBlocks.get(type);
            if (b == null) {
                System.err.println("Missing basic block type: " + type);
                return "ERROR";
            } else if (b.inputs().size() != args.size()) {
                System.err.println("Input number mismatch for basic block " + b.name + ": " + b.inputs().size()
                        + " inputs according to the basic block declaration, " + args.size() + " inputs passed");
                return "ERROR";
            }
        }

        final StringBuilder sb = new StringBuilder();
        sb.append("// Closed-loop interface, change ints to bools where needed\n");
        for (OutputDeclaration decl : outputDeclarations) {
            if (decl.outputName.name.endsWith("_FAULT")) {
                continue;
            }
            sb.append("int PLANT_INPUT_" + decl.outputName + ";\n");
        }
        for (Id arg : args) {
            if (arg.name.endsWith("_FAULT")) {
                sb.append("#define PLANT_OUTPUT_" + arg + " false\n");
            } else if (arg.name.endsWith("_CONNECTED")) {
                sb.append("#define PLANT_OUTPUT_" + arg + " true\n");
            } else {
                sb.append("int PLANT_OUTPUT_" + arg + ";\n");
            }
        }

        sb.append("\n");
        sb.append("// Output declarations for basic blocks\n");
        internalDeclarations.forEach(d -> sb.append(basicBlocks.get(d.type.name).outputDeclarations(d.name.name)));
        sb.append("\n");
        sb.append("// Variable declarations for basic blocks\n");
        internalDeclarations.forEach(d -> sb.append(basicBlocks.get(d.type.name).varDeclarations(d.name.name)));

        sb.append("\n");
        sb.append("bool system_init = true;\n");
        sb.append("\n");
        sb.append("init { do :: atomic {\n");
        sb.append("    // Plant execution\n");
        sb.append("    // TODO insert plant code here\n");
        sb.append("\n");
        sb.append("    // Controller execution\n");
        sb.append("    d_step {");

        for (InternalDeclaration decl : internalDeclarations) {
            // execution
            final BasicBlock b = basicBlocks.get(decl.type.name);
            sb.append("\n");

            sb.append("        // Running " + decl.name + " : " + decl.type + "\n");
            final List<Argument> args = decl.argList();
            for (int j = 0; j < args.size(); j++) {
                final Argument arg = args.get(j);
                final String argName = b.inputs().get(j).getRight();
                final String prefix = "        #define INPUT_" + decl.name + "__" + argName + " ";
                if (arg instanceof Constant) {
                    sb.append(prefix + arg + "\n");
                } else if (arg instanceof Id) {
                    sb.append(prefix + "PLANT_OUTPUT_" + arg + "\n");
                } else if (arg instanceof CompositeId) {
                    sb.append(prefix + "OUTPUT_" + ((CompositeId) arg).moduleName + "__"
                            + ((CompositeId) arg).varName + "\n");
                } else {
                    System.err.println("Unknown argument type");
                }
            }
            sb.append(b.coreText(decl.name.name, 8));
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("        // Assigning controller outputs to plant inputs\n");
        for (OutputDeclaration decl : outputDeclarations) {
            if (decl.outputName.name.endsWith("_FAULT")) {
                continue;
            }
            sb.append("        PLANT_INPUT_" + decl.outputName + " = OUTPUT_" + decl.reference.moduleName + "__"
                    + decl.reference.varName + ";\n");
        }

        sb.append("\n");
        sb.append("        system_init = false;\n");
        sb.append("    }\n");
        sb.append("} od }");

        return sb.toString();
    }
}
