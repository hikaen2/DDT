Ⓗ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
#@TWO_PARENS_OrBREAK《 ))●#error(EXP_CLOSE_PARENS)#error(EXP_CLOSE_PARENS) #@BREAK》

#@ISEXP_DEFID《#?STRUCTURE_EXPECTED!【#@DEFID ● StaticIfExpIsDefUnit(#@DEFID)】》

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
#PARSE(EXPRESSION)              is(#@TYPEREF_BROKEN__NoTypeAppend #@ISEXP_DEFID #@CLOSEPARENS_OR_BREAK
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF_BROKEN__NoTypeAppend #@ISEXP_DEFID )
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
#PARSE(EXPRESSION)              is(#@TYPEREF__SAMPLE #@ISEXP_DEFID : #@TYPEREF_ANY #@NOBROKEN__CLOSEPARENS_OR_BREAK
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF__SAMPLE #@ISEXP_DEFID   #@TYPEREF_ANY )
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
#PARSE(EXPRESSION)              is(#@TYPEREF__SAMPLE #@ISEXP_DEFID == #@TYPE_SPEC #@NOBROKEN__CLOSEPARENS_OR_BREAK
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF__SAMPLE #@ISEXP_DEFID    #@TYPE_SPEC )
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂  ':' syntax doesn't allow #@ARCHETYPE like 'class'
#PARSE(EXPRESSION)              is(#@TYPEREF__SAMPLE #@ISEXP_DEFID :  #@NO_TYPEREF #@NO_ClosePARENS #@BREAK class )
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF__SAMPLE #@ISEXP_DEFID    #@NO_TYPEREF )

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ with tpl params
#PARSE(EXPRESSION)              is(#@TYPEREF__SAMPLE #@ISEXP_DEFID #@《:●==》 #@TYPEREF_NBNE__LITE , #@TPLPARAMS__SIMPLE_TESTER #@CLOSEPARENS_OR_BREAK
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF__SAMPLE #@ISEXP_DEFID         #@TYPEREF_NBNE__LITE   #@TPLPARAMS__SIMPLE_TESTER )
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
#PARSE(EXPRESSION)              is(#@TYPEREF__SAMPLE #@ISEXP_DEFID #@《:●==》 #@TYPEREF_NBNE__LITE , #@NO_TPLPARAM #@CLOSEPARENS_OR_BREAK
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF__SAMPLE #@ISEXP_DEFID         #@TYPEREF_NBNE__LITE   #@NO_TPLPARAM )
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
#PARSE(EXPRESSION)              is(#@TYPEREF__SAMPLE #@ISEXP_DEFID      == class  #@NO_ClosePARENS #@BREAK , alias T )
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF__SAMPLE #@ISEXP_DEFID )

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
#PARSE(EXPRESSION)              is(#@TYPEREF__SAMPLE /*---------*/ #@《:●==》 #@TYPEREF_NBNE__LITE , #@TPLPARAMS__SIMPLE_TESTER #@CLOSEPARENS_OR_BREAK
#STRUCTURE_EXPECTED: StaticIfExpIs(#@TYPEREF__SAMPLE                       #@TYPEREF_NBNE__LITE   #@TPLPARAMS__SIMPLE_TESTER )

Ⓗ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
#PARSE(DECLARATION)            static if(           is(#@TYPEREF_NBNE #@ISEXP_DEFID)) #@DECLS_BLOCK__SAMPLE
#STRUCTURE_EXPECTED: DeclarationStaticIf(StaticIfExpIs(#@TYPEREF_NBNE #@ISEXP_DEFID)  #@DECLS_BLOCK__SAMPLE )
Ⓗ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ TODO: test error
#PARSE(STATEMENT)    #error(NOT_IN_STATIC_IF) is(#@TYPEREF_NBNE #@ISEXP_DEFID #@CLOSEPARENS_OR_NO ;
#STRUCTURE_EXPECTED: StatementExp( StaticIfExpIs(#@TYPEREF_NBNE #@ISEXP_DEFID ) )
