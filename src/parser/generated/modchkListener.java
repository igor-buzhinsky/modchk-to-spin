// Generated from /home/buzhinsky/repos/other/modchk-to-spin/modchk.g4 by ANTLR 4.6

package parser.generated;

import java.util.*;
import parser.structures.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link modchkParser}.
 */
public interface modchkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link modchkParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(modchkParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(modchkParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(modchkParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(modchkParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(modchkParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(modchkParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(modchkParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(modchkParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#internal_declaration}.
	 * @param ctx the parse tree
	 */
	void enterInternal_declaration(modchkParser.Internal_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#internal_declaration}.
	 * @param ctx the parse tree
	 */
	void exitInternal_declaration(modchkParser.Internal_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#output_declaration}.
	 * @param ctx the parse tree
	 */
	void enterOutput_declaration(modchkParser.Output_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#output_declaration}.
	 * @param ctx the parse tree
	 */
	void exitOutput_declaration(modchkParser.Output_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#composite_id}.
	 * @param ctx the parse tree
	 */
	void enterComposite_id(modchkParser.Composite_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#composite_id}.
	 * @param ctx the parse tree
	 */
	void exitComposite_id(modchkParser.Composite_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(modchkParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(modchkParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link modchkParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(modchkParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link modchkParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(modchkParser.Arg_listContext ctx);
}