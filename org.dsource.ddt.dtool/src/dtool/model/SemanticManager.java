/*******************************************************************************
 * Copyright (c) 2014, 2014 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package dtool.model;

import static melnorme.utilbox.core.Assert.AssertNamespace.assertFail;
import static melnorme.utilbox.core.Assert.AssertNamespace.assertNotNull;
import static melnorme.utilbox.core.Assert.AssertNamespace.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import melnorme.utilbox.concurrency.ITaskAgent;
import melnorme.utilbox.core.fntypes.ICallable;
import melnorme.utilbox.misc.StringUtil;
import melnorme.utilbox.process.ExternalProcessHelper;
import melnorme.utilbox.process.ExternalProcessHelper.ExternalProcessResult;
import dtool.dub.DubBundleDescription;
import dtool.dub.DubDescribeParser;

public class SemanticManager {
	
	protected final ITaskAgent processAgent;
	protected final DToolServer dtoolServer;
	protected final ModuleParseCache parseCache = ModuleParseCache.getDefault();
	
	protected final HashMap<Path, DubBundleDescription> bundleInfos = new HashMap<>();
	
	
	public SemanticManager(ITaskAgent processAgent, DToolServer dtoolServer) {
		this.processAgent = processAgent;
		this.dtoolServer = assertNotNull(dtoolServer);
	}
	
	public static Path validatePath(Path filePath) {
		assertTrue(filePath.isAbsolute());
		assertTrue(filePath.getNameCount() > 0);
		filePath = filePath.normalize();
		return filePath;
	}
	
	public SemanticContext getSemanticContext(Path bundlePath) throws InterruptedException, ExecutionException {
		
		bundlePath = validatePath(bundlePath);
		return processAgent.submit(new GetSemanticContextOperation(bundlePath)).get();
	}
	
	protected class GetSemanticContextOperation implements ICallable<SemanticContext, Exception> {
		
		protected Path bundlePath;

		public GetSemanticContextOperation(Path bundlePath) {
			this.bundlePath = bundlePath;
		}

		@Override
		public SemanticContext call() throws IOException, InterruptedException {
			ProcessBuilder pb = new ProcessBuilder("dub", "describe").directory(bundlePath.toFile());
			ExternalProcessHelper extPH = new ExternalProcessHelper(pb);
			ExternalProcessResult processResult;
			try {
				processResult = extPH.strictAwaitTermination();
			} catch (TimeoutException e) {
				throw assertFail();
			}
			
			DubBundleDescription bundleDesc = parseDubDescribe(bundlePath, processResult);
			return new SemanticContext(SemanticManager.this, bundleDesc);
		}
	}
	
	public static DubBundleDescription parseDubDescribe(Path location, ExternalProcessResult processResult) {
		String describeOutput = processResult.stdout.toString(StringUtil.UTF8);
		
		// Trim leading characters. 
		// They shouldn't be there, but sometimes dub outputs non JSON text if downloading packages
		describeOutput = StringUtil.substringFromMatch('{', describeOutput);
		
		return DubDescribeParser.parseDescription(location, describeOutput);
	}
	
}