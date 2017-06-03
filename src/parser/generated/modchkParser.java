// Generated from /home/buzhinsky/repos/other/modchk-to-spin/modchk.g4 by ANTLR 4.6

package parser.generated;

import java.util.*;
import parser.structures.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class modchkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, MODULE=3, ASSIGN=4, DEFINE=5, VAR=6, TRUE=7, FALSE=8, 
		INT_CONST=9, COLON=10, COMMA=11, DOT=12, ASSIGNMENT=13, EQUALS=14, PAR_OPEN=15, 
		PAR_CLOSE=16, SEMICOLON=17, ID=18;
	public static final int
		RULE_module = 0, RULE_id = 1, RULE_constant = 2, RULE_id_list = 3, RULE_internal_declaration = 4, 
		RULE_output_declaration = 5, RULE_composite_id = 6, RULE_argument = 7, 
		RULE_arg_list = 8;
	public static final String[] ruleNames = {
		"module", "id", "constant", "id_list", "internal_declaration", "output_declaration", 
		"composite_id", "argument", "arg_list"
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

	@Override
	public String getGrammarFileName() { return "modchk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public modchkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModuleContext extends ParserRuleContext {
		public BlockNetwork bn;
		public IdContext id;
		public TerminalNode MODULE() { return getToken(modchkParser.MODULE, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TerminalNode VAR() { return getToken(modchkParser.VAR, 0); }
		public TerminalNode DEFINE() { return getToken(modchkParser.DEFINE, 0); }
		public TerminalNode ASSIGN() { return getToken(modchkParser.ASSIGN, 0); }
		public TerminalNode EOF() { return getToken(modchkParser.EOF, 0); }
		public List<Internal_declarationContext> internal_declaration() {
			return getRuleContexts(Internal_declarationContext.class);
		}
		public Internal_declarationContext internal_declaration(int i) {
			return getRuleContext(Internal_declarationContext.class,i);
		}
		public List<Output_declarationContext> output_declaration() {
			return getRuleContexts(Output_declarationContext.class);
		}
		public Output_declarationContext output_declaration(int i) {
			return getRuleContext(Output_declarationContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitModule(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(MODULE);
			setState(19);
			((ModuleContext)_localctx).id = id();
			 ((ModuleContext)_localctx).bn =  new BlockNetwork(((ModuleContext)_localctx).id.id_.name); 
			setState(21);
			id_list(_localctx.bn);
			setState(22);
			match(VAR);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(23);
				internal_declaration(_localctx.bn);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(DEFINE);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(30);
				output_declaration(_localctx.bn);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(ASSIGN);
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public Id id_;
		public Token ID;
		public TerminalNode ID() { return getToken(modchkParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((IdContext)_localctx).ID = match(ID);
			 ((IdContext)_localctx).id_ =  new Id((((IdContext)_localctx).ID!=null?((IdContext)_localctx).ID.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Constant c;
		public Token INT_CONST;
		public TerminalNode INT_CONST() { return getToken(modchkParser.INT_CONST, 0); }
		public TerminalNode TRUE() { return getToken(modchkParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(modchkParser.FALSE, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constant);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				((ConstantContext)_localctx).INT_CONST = match(INT_CONST);
				 ((ConstantContext)_localctx).c =  new IntConstant(Integer.parseInt((((ConstantContext)_localctx).INT_CONST!=null?((ConstantContext)_localctx).INT_CONST.getText():null))); 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(TRUE);
				 ((ConstantContext)_localctx).c =  new BoolConstant(true); 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				match(FALSE);
				 ((ConstantContext)_localctx).c =  new BoolConstant(false); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public BlockNetwork bn;
		public IdContext x;
		public IdContext y;
		public TerminalNode PAR_OPEN() { return getToken(modchkParser.PAR_OPEN, 0); }
		public TerminalNode PAR_CLOSE() { return getToken(modchkParser.PAR_CLOSE, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modchkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modchkParser.COMMA, i);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Id_listContext(ParserRuleContext parent, int invokingState, BlockNetwork bn) {
			super(parent, invokingState);
			this.bn = bn;
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitId_list(this);
		}
	}

	public final Id_listContext id_list(BlockNetwork bn) throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState(), bn);
		enterRule(_localctx, 6, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(PAR_OPEN);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(51);
				((Id_listContext)_localctx).x = id();
				 _localctx.bn.addArg(((Id_listContext)_localctx).x.id_); 
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(53);
					match(COMMA);
					setState(54);
					((Id_listContext)_localctx).y = id();
					 _localctx.bn.addArg(((Id_listContext)_localctx).y.id_); 
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(64);
			match(PAR_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Internal_declarationContext extends ParserRuleContext {
		public BlockNetwork bn;
		public IdContext x;
		public IdContext y;
		public Arg_listContext arg_list;
		public TerminalNode COLON() { return getToken(modchkParser.COLON, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(modchkParser.SEMICOLON, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Internal_declarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Internal_declarationContext(ParserRuleContext parent, int invokingState, BlockNetwork bn) {
			super(parent, invokingState);
			this.bn = bn;
		}
		@Override public int getRuleIndex() { return RULE_internal_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterInternal_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitInternal_declaration(this);
		}
	}

	public final Internal_declarationContext internal_declaration(BlockNetwork bn) throws RecognitionException {
		Internal_declarationContext _localctx = new Internal_declarationContext(_ctx, getState(), bn);
		enterRule(_localctx, 8, RULE_internal_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((Internal_declarationContext)_localctx).x = id();
			setState(67);
			match(COLON);
			setState(68);
			((Internal_declarationContext)_localctx).y = id();
			setState(69);
			((Internal_declarationContext)_localctx).arg_list = arg_list();
			 _localctx.bn.addInternalDeclaration(new InternalDeclaration(((Internal_declarationContext)_localctx).x.id_, ((Internal_declarationContext)_localctx).y.id_, ((Internal_declarationContext)_localctx).arg_list.list)); 
			setState(71);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Output_declarationContext extends ParserRuleContext {
		public BlockNetwork bn;
		public IdContext id;
		public Composite_idContext composite_id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(modchkParser.ASSIGNMENT, 0); }
		public Composite_idContext composite_id() {
			return getRuleContext(Composite_idContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(modchkParser.SEMICOLON, 0); }
		public Output_declarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Output_declarationContext(ParserRuleContext parent, int invokingState, BlockNetwork bn) {
			super(parent, invokingState);
			this.bn = bn;
		}
		@Override public int getRuleIndex() { return RULE_output_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterOutput_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitOutput_declaration(this);
		}
	}

	public final Output_declarationContext output_declaration(BlockNetwork bn) throws RecognitionException {
		Output_declarationContext _localctx = new Output_declarationContext(_ctx, getState(), bn);
		enterRule(_localctx, 10, RULE_output_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((Output_declarationContext)_localctx).id = id();
			setState(74);
			match(ASSIGNMENT);
			setState(75);
			((Output_declarationContext)_localctx).composite_id = composite_id();
			 _localctx.bn.addOutputDeclaration(new OutputDeclaration(((Output_declarationContext)_localctx).id.id_, ((Output_declarationContext)_localctx).composite_id.compId)); 
			setState(77);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Composite_idContext extends ParserRuleContext {
		public CompositeId compId;
		public IdContext x;
		public IdContext y;
		public TerminalNode DOT() { return getToken(modchkParser.DOT, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Composite_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composite_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterComposite_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitComposite_id(this);
		}
	}

	public final Composite_idContext composite_id() throws RecognitionException {
		Composite_idContext _localctx = new Composite_idContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_composite_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			((Composite_idContext)_localctx).x = id();
			setState(80);
			match(DOT);
			setState(81);
			((Composite_idContext)_localctx).y = id();
			 ((Composite_idContext)_localctx).compId =  new CompositeId(((Composite_idContext)_localctx).x.id_, ((Composite_idContext)_localctx).y.id_); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public Argument arg;
		public Composite_idContext composite_id;
		public IdContext id;
		public ConstantContext constant;
		public Composite_idContext composite_id() {
			return getRuleContext(Composite_idContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argument);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				((ArgumentContext)_localctx).composite_id = composite_id();
				 ((ArgumentContext)_localctx).arg =  ((ArgumentContext)_localctx).composite_id.compId; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				((ArgumentContext)_localctx).id = id();
				 ((ArgumentContext)_localctx).arg =  ((ArgumentContext)_localctx).id.id_; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				((ArgumentContext)_localctx).constant = constant();
				 ((ArgumentContext)_localctx).arg =  ((ArgumentContext)_localctx).constant.c; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arg_listContext extends ParserRuleContext {
		public List<Argument> list;
		public ArgumentContext argument;
		public TerminalNode PAR_OPEN() { return getToken(modchkParser.PAR_OPEN, 0); }
		public TerminalNode PAR_CLOSE() { return getToken(modchkParser.PAR_CLOSE, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(modchkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(modchkParser.COMMA, i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).enterArg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof modchkListener ) ((modchkListener)listener).exitArg_list(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Arg_listContext)_localctx).list =  new ArrayList<>(); 
			setState(96);
			match(PAR_OPEN);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INT_CONST) | (1L << ID))) != 0)) {
				{
				setState(97);
				((Arg_listContext)_localctx).argument = argument();
				 _localctx.list.add(((Arg_listContext)_localctx).argument.arg); 
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(99);
					match(COMMA);
					setState(100);
					((Arg_listContext)_localctx).argument = argument();
					 _localctx.list.add(((Arg_listContext)_localctx).argument.arg); 
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(110);
			match(PAR_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24s\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\63\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5<\n\5\f\5\16\5?\13\5\5\5A\n\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t`\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\nj\n\n\f\n\16\nm\13\n\5\no\n\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16"+
		"\20\22\2\2s\2\24\3\2\2\2\4)\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\nD\3\2\2"+
		"\2\fK\3\2\2\2\16Q\3\2\2\2\20_\3\2\2\2\22a\3\2\2\2\24\25\7\5\2\2\25\26"+
		"\5\4\3\2\26\27\b\2\1\2\27\30\5\b\5\2\30\34\7\b\2\2\31\33\5\n\6\2\32\31"+
		"\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36\34"+
		"\3\2\2\2\37#\7\7\2\2 \"\5\f\7\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2"+
		"\2$&\3\2\2\2%#\3\2\2\2&\'\7\6\2\2\'(\7\2\2\3(\3\3\2\2\2)*\7\24\2\2*+\b"+
		"\3\1\2+\5\3\2\2\2,-\7\13\2\2-\63\b\4\1\2./\7\t\2\2/\63\b\4\1\2\60\61\7"+
		"\n\2\2\61\63\b\4\1\2\62,\3\2\2\2\62.\3\2\2\2\62\60\3\2\2\2\63\7\3\2\2"+
		"\2\64@\7\21\2\2\65\66\5\4\3\2\66=\b\5\1\2\678\7\r\2\289\5\4\3\29:\b\5"+
		"\1\2:<\3\2\2\2;\67\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?=\3"+
		"\2\2\2@\65\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7\22\2\2C\t\3\2\2\2DE\5\4\3\2"+
		"EF\7\f\2\2FG\5\4\3\2GH\5\22\n\2HI\b\6\1\2IJ\7\23\2\2J\13\3\2\2\2KL\5\4"+
		"\3\2LM\7\17\2\2MN\5\16\b\2NO\b\7\1\2OP\7\23\2\2P\r\3\2\2\2QR\5\4\3\2R"+
		"S\7\16\2\2ST\5\4\3\2TU\b\b\1\2U\17\3\2\2\2VW\5\16\b\2WX\b\t\1\2X`\3\2"+
		"\2\2YZ\5\4\3\2Z[\b\t\1\2[`\3\2\2\2\\]\5\6\4\2]^\b\t\1\2^`\3\2\2\2_V\3"+
		"\2\2\2_Y\3\2\2\2_\\\3\2\2\2`\21\3\2\2\2ab\b\n\1\2bn\7\21\2\2cd\5\20\t"+
		"\2dk\b\n\1\2ef\7\r\2\2fg\5\20\t\2gh\b\n\1\2hj\3\2\2\2ie\3\2\2\2jm\3\2"+
		"\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2mk\3\2\2\2nc\3\2\2\2no\3\2\2\2op\3\2"+
		"\2\2pq\7\22\2\2q\23\3\2\2\2\n\34#\62=@_kn";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}