package mmrnmhrm.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IModelStatusConstants;
import org.eclipse.dltk.core.IScriptModel;
import org.eclipse.dltk.core.PreferencesLookupDelegate;

public abstract class LangCore extends Plugin {
	
	public static class ILangConstants {
		
		public static int INTERNAL_ERROR = 1;
		
	}
	
	private static Plugin getInstance() {
		return DeeCore.getInstance();
	}
	
	/** Convenience method to get the WorkspaceRoot. */
	public static IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
	
	/** Convenience method to get the Workspace. */
	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}
	
	/** Convenience method to get the DLTK Model. */
	public static IScriptModel getDLTKModel() {
		return DLTKCore.create(ResourcesPlugin.getWorkspace().getRoot());
	}
	
	/** Creates an OK status with given message. */
	public static Status createStatus(String message) {
		return new Status(IStatus.OK, DeeCore.PLUGIN_ID, message); 
	}
	
	/** Creates a status describing an error in this plugin, with given message. */
	public static IStatus createErrorStatus(String message) {
		return createErrorStatus(message, null);
	}
	
	/** Creates a status describing an error in this plugin, with give message and exception. */
	public static Status createErrorStatus(String message, Throwable throwable) {
		return new Status(IStatus.ERROR, DeeCore.PLUGIN_ID, IModelStatusConstants.INTERNAL_ERROR, message, throwable); 
	}
	
	/** Creates a CoreException describing an error in this plugin. */
	public static CoreException createCoreException(String msg, Exception e) {
		return new CoreException(createErrorStatus(msg, e));
	}
	
	public static void log(Exception e) {
		logError(e);
	}
	
	/** Logs an error status with given exception and given message. */
	public static void logError(Throwable throwable, String message) {
		getInstance().getLog().log(createErrorStatus(message, throwable));
	}
	
	/** Logs an error status with given message. */
	public static void logError(String message) {
		getInstance().getLog().log(createErrorStatus(message, null));
	}
	
	/** Logs an error status with given exception. */
	public static void logError(Throwable throwable) {
		getInstance().getLog().log(createErrorStatus(LangCoreMessages.LangCore_internal_error, throwable));
	}
	
	/** Logs the given message, creating a new warning status for this plugin. */
	public static void logWarning(String message) {
		getInstance().getLog().log(new Status(IStatus.WARNING, DeeCore.PLUGIN_ID,
						IModelStatusConstants.INTERNAL_ERROR, message, null));
	}
	
	
	/**
	 * See {@link DLTKCore#run(IWorkspaceRunnable, ISchedulingRule, IProgressMonitor)}
	 */
	public static void run(IWorkspaceRunnable action, ISchedulingRule rule,
			IProgressMonitor monitor) throws CoreException {
		DLTKCore.run(action, rule, monitor);
	}
	
	/** Runs {@link #run(IWorkspaceRunnable, ISchedulingRule, IProgressMonitor) }
	 * with workspace root as the rule. */
	public static void run(IWorkspaceRunnable action, IProgressMonitor monitor)
		throws CoreException {
		run(action, ResourcesPlugin.getWorkspace().getRoot(), monitor);
	}
	
	
	/** Runs the given action, if an exception occurs log it. */
	public static void executeChecked(IWorkspaceRunnable action, IProgressMonitor monitor) {
		try {
			run(action, ResourcesPlugin.getWorkspace().getRoot(), monitor);
		} catch (CoreException e) {
			log(e);
		}
	}
	
	protected final PreferencesLookupDelegate preferencesLookup = new PreferencesLookupDelegate((IProject) null);
	
	public PreferencesLookupDelegate getPreferencesLookup() {
		return preferencesLookup;
	}
}
