package dtool.ast.statements;

import melnorme.utilbox.tree.TreeVisitor;
import descent.internal.compiler.parser.CaseStatement;
import dtool.ast.IASTNeoVisitor;
import dtool.ast.expressions.Resolvable;
import dtool.descentadapter.DescentASTConverter.ASTConversionContext;
import dtool.descentadapter.ExpressionConverter;

public class StatementCase extends Statement {

	public Resolvable exp;
	public IStatement st;
	
	public StatementCase(CaseStatement elem, ASTConversionContext convContext) {
		convertNode(elem);
		this.exp = ExpressionConverter.convert(elem.exp, convContext);
		this.st = Statement.convert(elem.statement, convContext);
	}

	@Override
	public void accept0(IASTNeoVisitor visitor) {
		boolean children = visitor.visit(this);
		if (children) {
			TreeVisitor.acceptChildren(visitor, exp);
			TreeVisitor.acceptChildren(visitor, st);
		}
		visitor.endVisit(this);
	}

}
