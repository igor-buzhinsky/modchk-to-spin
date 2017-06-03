package parser;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by buzhinsky on 3/11/17.
 */
public class BasicBlock {
    public final String name;
    private final String text;
    private final String declarations;
    private final String coreText; // text inside the loop
    private final List<Pair<String, String>> inputs = new ArrayList<>();
    private final List<Pair<String, String>> outputs = new ArrayList<>();
    private final List<Pair<String, String>> variables = new ArrayList<>();

    private final static String ENDING = ";";
    private final static String[] TYPES = new String[] { "bool", "byte", "short", "int" };

    public List<Pair<String, String>> inputs() {
        return Collections.unmodifiableList(inputs);
    }

    public List<Pair<String, String>> outputs() {
        return Collections.unmodifiableList(outputs);
    }

    public List<Pair<String, String>> variables() {
        return Collections.unmodifiableList(variables);
    }

    public BasicBlock(String name, String text) {
        this.name = name;
        this.text = text;

        final StringBuilder declarationsSb = new StringBuilder();
        final StringBuilder coreTextSb = new StringBuilder();
        int coreTextState = 0;

        for (String line : text.split("\n")) {
            if (line.matches("^ *$")) {
                continue;
            }

            final int prevCoreTextState = coreTextState;

            if (coreTextState == 0) {
                for (String type : TYPES) {
                    if (line.startsWith(type + " input ") && line.endsWith(ENDING)) {
                        inputs.add(Pair.of(type, line.substring((type + " input ").length(),
                                line.length() - ENDING.length())));
                    } else if (line.startsWith(type + " output ") && line.endsWith(ENDING)) {
                        outputs.add(Pair.of(type, line.substring((type + " output ").length(),
                                line.length() - ENDING.length())));
                    } else if (line.startsWith(type + " var ") && line.endsWith(ENDING)) {
                        variables.add(Pair.of(type, line.substring((type + " var ").length(),
                                line.length() - ENDING.length())));
                    }
                }
            }

            if (line.equals("#START")) {
                coreTextState = 1;
            } else if (line.equals("#END")) {
                coreTextState = 2;
            }

            if (coreTextState == 0) {
                for (String type : TYPES) {
                    if (line.startsWith(type + " ")) {
                        declarationsSb.append(line + "\n");
                    }
                }
            } else if (prevCoreTextState == 1 && coreTextState == 1) {
                coreTextSb.append(line + "\n");
            }
        }

        coreText = coreTextSb.toString();
        declarations = declarationsSb.toString();
    }

    public String outputDeclarations(String blockName) {
        final StringBuilder sb = new StringBuilder();
        for (Pair<String, String> symbol : outputs) {
            sb.append(symbol.getLeft() + " " + "OUTPUT_" + blockName + "__" + symbol.getRight() + ";\n");
        }
        return sb.toString();
    }

    public String varDeclarations(String blockName) {
        final StringBuilder sb = new StringBuilder();
        for (Pair<String, String> symbol : variables) {
            sb.append(symbol.getLeft() + " " + "VAR_" + blockName + "__" + symbol.getRight() + ";\n");
        }
        return sb.toString();
    }

    private String indent(int spaces, String s) {
        final String indent = StringUtils.repeat(' ', spaces);
        return String.join("\n", Arrays.stream(s.split("\n")).map(x -> indent + x).collect(Collectors.toList()));
    }

    public String coreText(String blockName, int spaces) {
        String text = coreText.replace("__INIT__", "system_init");
        for (Pair<String, String> symbol : inputs) {
            text = text.replaceAll("\\b" + symbol.getRight() + "\\b", "INPUT_" + blockName + "__" + symbol.getRight());
        }
        for (Pair<String, String> symbol : outputs) {
            text = text.replaceAll("\\b" + symbol.getRight() + "\\b", "OUTPUT_" + blockName + "__" + symbol.getRight());
        }
        for (Pair<String, String> symbol : variables) {
            text = text.replaceAll("\\b" + symbol.getRight() + "\\b", "VAR_" + blockName + "__" + symbol.getRight());
        }
        return indent(spaces, "d_step {\n" + indent(4, text) + "\n}");
    }

    @Override
    public String toString() {
        return name + "\n" + declarations + "\n" + coreText;
    }
}
