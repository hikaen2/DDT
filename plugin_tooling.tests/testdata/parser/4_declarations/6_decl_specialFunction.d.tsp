Ⓗ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
http://dlang.org/class.html#Destructor

#@SHARED_OPT《
  ►#?STRUCTURE_EXPECTED!【 ● 】●
  ►#?STRUCTURE_EXPECTED!【 shared● AttribBasic】●
¤》

#@ARG_TESTER《
  ►#?STRUCTURE_EXPECTED!【 #error(EXP_OPEN_PARENS)¤【()】 #@BREAK ● #@BREAK】●
  ►#?STRUCTURE_EXPECTED!【( #@CLOSEPARENS_OR_BREAK● #@CLOSEPARENS_OR_BREAK】●
¤》

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
#PARSE(DECLARATION)   ~this #@ARG_TESTER #@FN_BODY__SIMPLE_TESTER
#STRUCTURE_EXPECTED:  
DeclarationSpecialFunction(#@ARG_TESTER #@FN_BODY__SIMPLE_TESTER)
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
#PARSE(DECLARATION)   ~this () #@FN_ATTRIB__SAMPLE #@FN_BODY__SIMPLE_TESTER
#STRUCTURE_EXPECTED:  
DeclarationSpecialFunction( #@FN_ATTRIB__SAMPLE #@FN_BODY__SIMPLE_TESTER)
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ static and shared static versions parsed the same as normal constructor
#PARSE(DECLARATION)   #@SHARED_OPT static ~this #@ARG_TESTER #@FN_BODY__SIMPLE_TESTER
#STRUCTURE_EXPECTED:  
DeclarationAttrib(#@SHARED_OPT AttribBasic DeclarationSpecialFunction(#@ARG_TESTER #@FN_BODY__SIMPLE_TESTER))
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ parsed the same as normal constructor
#PARSE(DECLARATION)   #@SHARED_OPT static this ( #@CLOSEPARENS_OR_BREAK #@ST_BLOCK__SAMPLE
#STRUCTURE_EXPECTED:  
DeclarationAttrib(#@SHARED_OPT AttribBasic DefinitionConstructor(DefSymbol #@CLOSEPARENS_OR_BREAK #@ST_BLOCK__SAMPLE))

Ⓗ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ struct decl PostBlit
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂  duplicate case, for clarity
#PARSE(DECLARATION)   this #error(EXP_OPEN_PARENS)【】 #@BREAK
#STRUCTURE_EXPECTED:  DefConstructor(DefSymbol)
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ duplicate case, for clarity
#PARSE(DECLARATION)   this ( #error(EXP_CLOSE_PARENS) #@BREAK
#STRUCTURE_EXPECTED:  DefConstructor(DefSymbol)
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
#PARSE(DECLARATION)   this(this #error(EXP_CLOSE_PARENS) #@BREAK
#STRUCTURE_EXPECTED:  DeclarationSpecialFunction()
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
#PARSE(DECLARATION)   this(this) #@FN_ATTRIB__SAMPLE #@FN_BODY__SIMPLE_TESTER
#STRUCTURE_EXPECTED:  DeclarationSpecialFunction(#@FN_ATTRIB__SAMPLE #@FN_BODY__SIMPLE_TESTER)
