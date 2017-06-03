grammar modchk;

options {
  language = Java;
}

@header {
package parser.generated;

import java.util.*;
import parser.structures.*;
}

@parser::members {
}

module returns[BlockNetwork bn]
    : MODULE id { $bn = new BlockNetwork($id.id_.name); }
      id_list[$bn] VAR internal_declaration[$bn]* DEFINE output_declaration[$bn]* ASSIGN EOF
    ;

id returns[Id id_]
    : ID { $id_ = new Id($ID.text); }
    ;

constant returns[Constant c]
    : INT_CONST { $c = new IntConstant(Integer.parseInt($INT_CONST.text)); }
    | TRUE      { $c = new BoolConstant(true); }
    | FALSE     { $c = new BoolConstant(false); }
    ;

id_list[BlockNetwork bn]
    : PAR_OPEN (x=id { $bn.addArg($x.id_); } (COMMA y=id { $bn.addArg($y.id_); })*)? PAR_CLOSE
    ;

internal_declaration[BlockNetwork bn]
    : x=id COLON y=id arg_list { $bn.addInternalDeclaration(new InternalDeclaration($x.id_, $y.id_, $arg_list.list)); }
      SEMICOLON
    ;

output_declaration[BlockNetwork bn]
    : id ASSIGNMENT composite_id { $bn.addOutputDeclaration(new OutputDeclaration($id.id_, $composite_id.compId)); }
      SEMICOLON
    ;

composite_id returns[CompositeId compId]
    : x=id DOT y=id { $compId = new CompositeId($x.id_, $y.id_); }
    ;

argument returns[Argument arg]
    : composite_id { $arg = $composite_id.compId; }
    | id { $arg = $id.id_; }
    | constant { $arg = $constant.c; }
    ;

arg_list returns[List<Argument> list]
    : { $list = new ArrayList<>(); }
      PAR_OPEN (argument { $list.add($argument.arg); } (COMMA argument { $list.add($argument.arg); })*)? PAR_CLOSE
    ;

// operator sequences
WS : (' ' | '\t' | ('\r'? '\n'))+ -> channel(HIDDEN);
COMMENT : ('--' ~[\r\n]* '\r'? '\n') -> channel(HIDDEN);

// keywords
MODULE : 'MODULE'; ASSIGN : 'ASSIGN'; DEFINE : 'DEFINE'; VAR : 'VAR';

// constants
TRUE : 'TRUE'; FALSE : 'FALSE';
INT_CONST : '-'? ('0' | ('1'..'9' ('0'..'9')*));

// operators
// TODO do we need operators?

COLON : ':'; COMMA : ','; DOT : '.'; ASSIGNMENT : ':='; EQUALS : '=';
PAR_OPEN : '('; PAR_CLOSE : ')'; SEMICOLON : ';';
                                        
// ids
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
// TODO what are valid NuSMV ids?