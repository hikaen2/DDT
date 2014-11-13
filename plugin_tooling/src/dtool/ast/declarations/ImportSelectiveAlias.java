package dtool.ast.declarations;

import melnorme.lang.tooling.ast.IASTVisitor;
import melnorme.lang.tooling.ast.util.ASTCodePrinter;
import melnorme.lang.tooling.ast_actual.ASTNodeTypes;
import melnorme.lang.tooling.ast_actual.ILangNamedElement;
import melnorme.lang.tooling.bundles.IModuleResolver;
import melnorme.lang.tooling.engine.resolver.DefElementCommon;
import dtool.ast.declarations.ImportSelective.IImportSelectiveSelection;
import dtool.ast.definitions.DefUnit;
import dtool.ast.definitions.EArcheType;
import dtool.ast.references.RefImportSelection;
import dtool.resolver.CommonDefUnitSearch;

public class ImportSelectiveAlias extends DefUnit implements IImportSelectiveSelection {
	
	public final RefImportSelection target;
	
	public ImportSelectiveAlias(ProtoDefSymbol defId, RefImportSelection impSelection) {
		super(defId);
		this.target = parentize(impSelection);
	}
	
	@Override
	public ASTNodeTypes getNodeType() {
		return ASTNodeTypes.IMPORT_SELECTIVE_ALIAS;
	}
	
	@Override
	public void visitChildren(IASTVisitor visitor) {
		acceptVisitor(visitor, defname);
		acceptVisitor(visitor, target);
	}
	
	@Override
	public void toStringAsCode(ASTCodePrinter cp) {
		cp.appendStrings(getName(), " = ");
		cp.append(target);
	}
	
	@Override
	public EArcheType getArcheType() {
		return EArcheType.Alias;
	}
	
	@Override
	public void resolveSearchInMembersScope(CommonDefUnitSearch search) {
		resolveSearchInReferredContainer(search, target);
	}
	
	@Override
	public ILangNamedElement resolveTypeForValueContext(IModuleResolver mr) {
		return DefElementCommon.resolveTypeForValueContext(mr, target);
	}
	
}