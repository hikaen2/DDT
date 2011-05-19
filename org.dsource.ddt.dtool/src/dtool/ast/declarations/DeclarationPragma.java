package dtool.ast.declarations;


import melnorme.utilbox.tree.TreeVisitor;
import descent.internal.compiler.parser.PragmaDeclaration;
import descent.internal.compiler.parser.PragmaStatement;
import dtool.ast.IASTNeoVisitor;
import dtool.ast.definitions.Symbol;
import dtool.ast.expressions.Resolvable;
import dtool.ast.statements.IStatement;
import dtool.descentadapter.DefinitionConverter;
import dtool.descentadapter.DescentASTConverter.ASTConversionContext;
import dtool.descentadapter.ExpressionConverter;

public class DeclarationPragma extends DeclarationAttrib implements IStatement {

	public Symbol ident;
	public Resolvable[] expressions;
	
	public DeclarationPragma(PragmaDeclaration elem, ASTConversionContext convContex) {
		super(elem, elem.decl, convContex);
		this.ident = DefinitionConverter.convertId(elem.ident);
		if(elem.args != null)
			this.expressions = ExpressionConverter.convertMany(elem.args, convContex);
	}
	
	public DeclarationPragma(PragmaStatement elem, ASTConversionContext convContex) {
		super(elem, elem.body, convContex);
		this.ident = DefinitionConverter.convertId(elem.ident);
		if(elem.args != null)
			this.expressions = ExpressionConverter.convertMany(elem.args, convContex);
	}


	@Override
	public void accept0(IASTNeoVisitor visitor) {
		boolean children = visitor.visit(this);
		if (children) {
			TreeVisitor.acceptChildren(visitor, ident);
			TreeVisitor.acceptChildren(visitor, expressions);
			acceptBodyChildren(visitor);
		}
		visitor.endVisit(this);
	}
	
	@Override
	public String toStringAsElement() {
		return "[pragma("+ident+",...)]";
	}
}
