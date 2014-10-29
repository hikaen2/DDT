package dtool.ast;


public enum ASTNodeTypes {
	
	/** Useful marker that represents a null object. Useful for using as a switch value. */
	NULL,
	
	SYMBOL,
	
	MODULE,
	DECLARATION_MODULE,
	DECLARATION_IMPORT,
	IMPORT_CONTENT,
	IMPORT_ALIAS,
	IMPORT_SELECTIVE,
	IMPORT_SELECTIVE_ALIAS,
	
	DECL_LIST,
	DECL_BLOCK,
	DECLARATION_EMTPY,
	MISSING_DECLARATION,
	INVALID_SYNTAX,
	
	INCOMPLETE_DECLARATOR,
	
	/* ---------------------------------- */
	
	REF_IMPORT_SELECTION,
	REF_MODULE,
	
	REF_IDENTIFIER,
	REF_QUALIFIED,
	REF_MODULE_QUALIFIED,
	REF_PRIMITIVE,
	
	REF_TYPE_DYN_ARRAY,
	REF_TYPE_POINTER,
	REF_INDEXING,
	REF_SLICE,
	REF_TYPE_FUNCTION,
	REF_TEMPLATE_INSTANCE,
	REF_TYPEOF,
	REF_MODIFIER,
	
	REF_AUTO,
	
	/* ---------------------------------- */
	
	MISSING_EXPRESSION,
	EXP_REF_RETURN,
	
	EXP_THIS,
	EXP_SUPER,
	EXP_NULL,
	EXP_ARRAY_LENGTH,
	EXP_LITERAL_BOOL,
	EXP_LITERAL_INTEGER,
	EXP_LITERAL_STRING,
	EXP_LITERAL_CHAR,
	EXP_LITERAL_FLOAT,
	
	EXP_LITERAL_ARRAY,
	EXP_LITERAL_MAPARRAY,
	MAPARRAY_ENTRY,
	
	EXP_FUNCTION_LITERAL,
	EXP_SIMPLE_LAMBDA,
	SIMPLE_LAMBDA_DEFUNIT,
	
	EXP_REFERENCE,
	EXP_PARENTHESES,
	
	EXP_ASSERT,
	EXP_MIXIN_STRING,
	EXP_IMPORT_STRING,
	EXP_TYPEID,
	
	EXP_INDEX,
	EXP_CALL,
	
	EXP_PREFIX,
	EXP_NEW,
	EXP_NEW_ANON_CLASS,
	EXP_CAST,
	EXP_CAST_QUAL,
	EXP_POSTFIX_OP,
	EXP_INFIX,
	EXP_CONDITIONAL,
	
	EXP_IS,
	STATIC_IF_EXP_IS,
	STATIC_IF_EXP_IS_DEF_UNIT,
	EXP_TRAITS,
	
	/* -------------------  Declarations  ------------------- */
	DECLARATION_ATTRIB,
	ATTRIB_LINKAGE,
	ATTRIB_CPP_LINKAGE,
	ATTRIB_ALIGN,
	ATTRIB_PRAGMA,
	ATTRIB_PROTECTION,
	ATTRIB_BASIC,
	ATTRIB_AT_KEYWORD,
	ATTRIB_CUSTOM,
	
	DECLARATION_MIXIN_STRING,
	DECLARATION_MIXIN,
	DECLARATION_ALIAS_THIS,
	
	DECLARATION_INVARIANT,
	DECLARATION_UNITEST,
	DECLARATION_ALLOCATOR_FUNCTION,
	
	DECLARATION_SPECIAL_FUNCTION,
	
	DECLARATION_DEBUG_VERSION_SPEC,
	DECLARATION_DEBUG_VERSION,
	DECLARATION_STATIC_IF,
	DECLARATION_STATIC_ASSERT,
	
	/* ---------------------------------- */
	
	DEFINITION_VARIABLE,
	DEFINITION_VAR_FRAGMENT,
	DEFINITION_AUTO_VARIABLE,
	CSTYLE_ROOT_REF,
	INITIALIZER_VOID,
	INITIALIZER_ARRAY,
	ARRAY_INIT_ENTRY,
	INITIALIZER_STRUCT,
	STRUCT_INIT_ENTRY,
	
	DEFINITION_FUNCTION,
	FUNCTION_PARAMETER,
	NAMELESS_PARAMETER,
	VAR_ARGS_PARAMETER,
	FUNCTION_BODY,
	IN_OUT_FUNCTION_BODY,
	FUNCTION_BODY_OUT_BLOCK,
	
	DEFINITION_CONSTRUCTOR,
	
	DEFINITION_STRUCT,
	DEFINITION_UNION,
	DEFINITION_CLASS,
	DEFINITION_INTERFACE,
	
	DEFINITION_TEMPLATE,
	TEMPLATE_TYPE_PARAM,
	TEMPLATE_VALUE_PARAM,
	TEMPLATE_ALIAS_PARAM,
	TEMPLATE_TUPLE_PARAM,
	TEMPLATE_THIS_PARAM,
	
	DEFINITION_MIXIN_INSTANCE,
	
	DEFINITION_ENUM,
	DECLARATION_ENUM,
	ENUM_BODY,
	ENUM_MEMBER,
	
	DEFINITION_ENUM_VAR,
	DEFINITION_ENUM_VAR_FRAGMENT,
	DEFINITION_ALIAS,
	DEFINITION_ALIAS_FRAGMENT,
	
	DEFINITION_ALIAS_VAR_DECL,
	DEFINITION_ALIAS_FUNCTION_DECL,
	ALIAS_VAR_DECL_FRAGMENT,
	
	/* -------------------  Statements  ------------------- */
	
	BLOCK_STATEMENT,
	BLOCK_STATEMENT_UNSCOPED,
	EMPTY_STATEMENT,
	SCOPED_STATEMENT_LIST,
	
	STATEMENT_EXPRESSION,
	
	STATEMENT_LABEL,
	STATEMENT_IF,
	STATEMENT_IF_VAR,
	VARIABLE_DEF_WITH_INIT,
	STATEMENT_WHILE,
	STATEMENT_DO_WHILE,
	STATEMENT_FOR,
	STATEMENT_FOREACH,
	FOREACH_VARIABLE_DEF,
	
	STATEMENT_SWITCH,
	STATEMENT_CASE,
	STATEMENT_CASE_RANGE,
	STATEMENT_DEFAULT,
	STATEMENT_CONTINUE,
	STATEMENT_BREAK,
	STATEMENT_RETURN,
	STATEMENT_GOTO,
	STATEMENT_GOTO_DEFAULT,
	STATEMENT_GOTO_CASE,
	
	STATEMENT_THROW,
	STATEMENT_SYNCHRONIZED,
	STATEMENT_WITH,	
	STATEMENT_ASM,
	STATEMENT_SCOPE,
	STATEMENT_TRY,
	TRY_CATCH_CLAUSE,
	SIMPLE_VARIABLE_DEF,
	;
}
