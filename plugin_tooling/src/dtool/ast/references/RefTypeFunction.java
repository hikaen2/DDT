/*******************************************************************************
 * Copyright (c) 2011, 2014 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package dtool.ast.references;

import java.util.Collection;

import melnorme.lang.tooling.ast.IASTVisitor;
import melnorme.lang.tooling.ast.util.ASTCodePrinter;
import melnorme.lang.tooling.ast_actual.ASTNode;
import melnorme.lang.tooling.ast_actual.ASTNodeTypes;
import melnorme.lang.tooling.ast_actual.ILangNamedElement;
import melnorme.lang.tooling.bundles.IModuleResolver;
import melnorme.utilbox.collections.ArrayView;
import melnorme.utilbox.core.CoreUtil;
import dtool.ast.definitions.FunctionAttributes;
import dtool.ast.definitions.IFunctionParameter;
import dtool.ast.expressions.Resolvable;
import dtool.resolver.LanguageIntrinsics;
import dtool.resolver.LanguageIntrinsics.DeeIntrinsicType;

/**
 * A function pointer type
 */
public class RefTypeFunction extends CommonNativeTypeReference {
	
	public final Reference retType;
	public final boolean isDelegate;
	public final ArrayView<IFunctionParameter> params;
	public final ArrayView<FunctionAttributes> fnAttributes;
	
	public RefTypeFunction(Reference retType, boolean isDelegate, ArrayView<IFunctionParameter> params, 
		ArrayView<FunctionAttributes> fnAttributes) {
		this.retType = parentize(retType);
		this.isDelegate = isDelegate;
		this.params = parentizeI(params);
		this.fnAttributes = fnAttributes;
	}
	
	public final ArrayView<ASTNode> getParams_asNodes() {
		return CoreUtil.blindCast(params);
	}
	
	@Override
	public ASTNodeTypes getNodeType() {
		return ASTNodeTypes.REF_TYPE_FUNCTION;
	}
	
	@Override
	public void visitChildren(IASTVisitor visitor) {
		acceptVisitor(visitor, retType);
		acceptVisitor(visitor, params);
	}
	
	@Override
	public void toStringAsCode(ASTCodePrinter cp) {
		cp.append(retType, " ");
		cp.append(isDelegate ? "delegate" : "function");
		cp.appendList("(", getParams_asNodes(), ",", ") ");
		cp.appendTokenList(fnAttributes, " ", true);
	}
	
	@Override
	public Collection<ILangNamedElement> findTargetDefElements(IModuleResolver moduleResolver, boolean findFirstOnly) {
		return Resolvable.wrapResult(intrinsicFunctionTypeInstance);
	}
	
	public static final IntrinsicFunctionType intrinsicFunctionTypeInstance = new IntrinsicFunctionType();
	
	public static class IntrinsicFunctionType extends DeeIntrinsicType {
		public IntrinsicFunctionType() {
			LanguageIntrinsics.D2_063_intrinsics.super("<funtion>", null);
		}
	}
}