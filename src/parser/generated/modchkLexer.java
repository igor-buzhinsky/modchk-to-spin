// Generated from /home/buzhinsky/repos/other/modchk-to-spin/modchk.g4 by ANTLR 4.6

package parser.generated;

import java.util.*;
import parser.structures.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class modchkLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, MODULE=3, ASSIGN=4, DEFINE=5, VAR=6, TRUE=7, FALSE=8, 
		INT_CONST=9, COLON=10, COMMA=11, DOT=12, ASSIGNMENT=13, EQUALS=14, PAR_OPEN=15, 
		PAR_CLOSE=16, SEMICOLON=17, ID=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "MODULE", "ASSIGN", "DEFINE", "VAR", "TRUE", "FALSE", 
		"INT_CONST", "COLON", "COMMA", "DOT", "ASSIGNMENT", "EQUALS", "PAR_OPEN", 
		"PAR_CLOSE", "SEMICOLON", "ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'MODULE'", "'ASSIGN'", "'DEFINE'", "'VAR'", "'TRUE'", 
		"'FALSE'", null, "':'", "','", "'.'", "':='", "'='", "'('", "')'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "MODULE", "ASSIGN", "DEFINE", "VAR", "TRUE", "FALSE", 
		"INT_CONST", "COLON", "COMMA", "DOT", "ASSIGNMENT", "EQUALS", "PAR_OPEN", 
		"PAR_CLOSE", "SEMICOLON", "ID"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public modchkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "modchk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\5\2*\n\2\3\2\6\2-\n\2\r\2\16\2.\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\5\3=\n\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\5\nh\n\n\3\n\3\n\3\n\7\nm\n\n\f\n\16\np\13\n\5\nr\n\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\7\23\u0087\n\23\f\23\16\23\u008a\13\23\2\2\24\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\3\2\6\4\2\13\13\"\"\4\2\f\f\17\17\5\2C\\aac|\6\2\62;C\\aac|\u0093"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3,\3\2\2\2\5\62\3\2\2\2\7B\3\2\2\2\tI\3\2\2\2\13P\3\2"+
		"\2\2\rW\3\2\2\2\17[\3\2\2\2\21`\3\2\2\2\23g\3\2\2\2\25s\3\2\2\2\27u\3"+
		"\2\2\2\31w\3\2\2\2\33y\3\2\2\2\35|\3\2\2\2\37~\3\2\2\2!\u0080\3\2\2\2"+
		"#\u0082\3\2\2\2%\u0084\3\2\2\2\'-\t\2\2\2(*\7\17\2\2)(\3\2\2\2)*\3\2\2"+
		"\2*+\3\2\2\2+-\7\f\2\2,\'\3\2\2\2,)\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2"+
		"\2\2/\60\3\2\2\2\60\61\b\2\2\2\61\4\3\2\2\2\62\63\7/\2\2\63\64\7/\2\2"+
		"\648\3\2\2\2\65\67\n\3\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2"+
		"\2\29<\3\2\2\2:8\3\2\2\2;=\7\17\2\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7"+
		"\f\2\2?@\3\2\2\2@A\b\3\2\2A\6\3\2\2\2BC\7O\2\2CD\7Q\2\2DE\7F\2\2EF\7W"+
		"\2\2FG\7N\2\2GH\7G\2\2H\b\3\2\2\2IJ\7C\2\2JK\7U\2\2KL\7U\2\2LM\7K\2\2"+
		"MN\7I\2\2NO\7P\2\2O\n\3\2\2\2PQ\7F\2\2QR\7G\2\2RS\7H\2\2ST\7K\2\2TU\7"+
		"P\2\2UV\7G\2\2V\f\3\2\2\2WX\7X\2\2XY\7C\2\2YZ\7T\2\2Z\16\3\2\2\2[\\\7"+
		"V\2\2\\]\7T\2\2]^\7W\2\2^_\7G\2\2_\20\3\2\2\2`a\7H\2\2ab\7C\2\2bc\7N\2"+
		"\2cd\7U\2\2de\7G\2\2e\22\3\2\2\2fh\7/\2\2gf\3\2\2\2gh\3\2\2\2hq\3\2\2"+
		"\2ir\7\62\2\2jn\4\63;\2km\4\62;\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2"+
		"\2\2or\3\2\2\2pn\3\2\2\2qi\3\2\2\2qj\3\2\2\2r\24\3\2\2\2st\7<\2\2t\26"+
		"\3\2\2\2uv\7.\2\2v\30\3\2\2\2wx\7\60\2\2x\32\3\2\2\2yz\7<\2\2z{\7?\2\2"+
		"{\34\3\2\2\2|}\7?\2\2}\36\3\2\2\2~\177\7*\2\2\177 \3\2\2\2\u0080\u0081"+
		"\7+\2\2\u0081\"\3\2\2\2\u0082\u0083\7=\2\2\u0083$\3\2\2\2\u0084\u0088"+
		"\t\4\2\2\u0085\u0087\t\5\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089&\3\2\2\2\u008a\u0088\3\2\2\2"+
		"\f\2),.8<gnq\u0088\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}