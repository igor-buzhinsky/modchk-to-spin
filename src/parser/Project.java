package parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.kohsuke.args4j.Argument;
import parser.generated.modchkLexer;
import parser.generated.modchkParser;
import parser.structures.BlockNetwork;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Project extends MainBase {
    @Argument(usage = "input directory", metaVar = "<dir>", required = true)
    private String inputDir;

	public static BlockNetwork loadNetwork(String filename) throws IOException, RecognitionException, NullPointerException {
		try (InputStream in = new FileInputStream(filename)) {
			modchkLexer lexer = new modchkLexer(new ANTLRInputStream(in));
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
            modchkParser parser = new modchkParser(tokens);
		    try {
                return parser.module().bn;
		    } catch (NullPointerException e) {
		    	throw e;
		    }
		} catch (RecognitionException e) {
			throw e;
		}
	}

    private static Map<String, BasicBlock> loadBasicBlocks(String path) {
        final String prefix = path + "basic/";
        final Map<String, BasicBlock> map = new HashMap<>();
        for (String filename : new File(prefix).list()) {
            if (!filename.endsWith(".pml")) {
                continue;
            }
            final String name = filename.substring(0, filename.length() - 4);
            filename = prefix + filename;
            String text = "";
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
                text = String.join("\n", reader.lines().collect(Collectors.toList()));
            } catch(IOException e) {
                e.printStackTrace();
            }
            final BasicBlock b = new BasicBlock(name, text);
            System.out.println(b.toString());
            map.put(name, b);
        }
        return map;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Project().run(args);
    }

    @Override
    public void launcher() {
        final Map<String, BasicBlock> basicBlocks = loadBasicBlocks(inputDir);

        final String prefix = inputDir + "composite/";
        for (String filename : new File(prefix).list()) {
            filename = prefix + filename;
            if (!filename.endsWith(".smv")) {
                continue;
            }
            final File f = new File(filename);
			if (f.isDirectory()) {
				continue;
			}
            try {
                final BlockNetwork bn = loadNetwork(filename);
                bn.sortModules();
                System.out.println(bn);
                try (PrintWriter pw = new PrintWriter(filename.substring(0, filename.length() - 3) + "pml")) {
                    pw.println(bn.toPromelaString(basicBlocks));
                }
            } catch (RecognitionException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                // for parser errors
            }
		}
	}
}
