/*******************************************************************************
 * Copyright (c) 2013, 2013 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package mmrnmhrm.core;

import melnorme.utilbox.misc.ExecutorAgent;

public class CoreExecutorAgent extends ExecutorAgent {
	
	public CoreExecutorAgent(String name) {
		super(name);
	}
	
	@Override
	protected void handleUnexpectException(Throwable throwable) {
		if(throwable != null) {
			// Log unexpected exceptions. This is important for two reasons:
			// 1: Give some user feedback an internal error ocurred, even if is for the log only.
			// 2: For tests to be able to determine if exceptions that should fail the test have occurred.
			LangCore.logError(throwable, "Unhandled exception in CoreExecutor: " + getName());
		}
	}
	
}