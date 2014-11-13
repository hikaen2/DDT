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

import melnorme.lang.tooling.ast_actual.ILangNamedElement;
import melnorme.lang.tooling.bundles.IModuleResolver;

// TODO: review this hierarchy
public abstract class CommonNativeTypeReference extends Reference {
	
	@Override
	public Collection<ILangNamedElement> resolveTypeOfUnderlyingValue(IModuleResolver mr) {
		return resolveToInvalidValue(); // This ref refers to a type, not a value
	}
	
}