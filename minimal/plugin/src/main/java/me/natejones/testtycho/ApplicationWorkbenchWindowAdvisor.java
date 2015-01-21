package me.natejones.testtycho;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(800, 530));
		configurer.setShowCoolBar(false);
		configurer.setShowStatusLine(false);
		configurer.setTitle("Test Tycho RCP Application");
		configurer.setShowProgressIndicator(true);
		/**
		 * This is to get Themes to work, but currently breaks everything.
		 * 
		 * BundleContext context =
		 * Platform.getBundle(Activator.PLUGIN_ID).getBundleContext();
		 * ServiceReference ref =
		 * context.getServiceReference(IThemeManager.class.getName());
		 * IThemeManager manager = (IThemeManager) context.getService(ref);
		 * IThemeEngine engine = manager
		 * .getEngineForDisplay(PlatformUI.getWorkbench
		 * ().getActiveWorkbenchWindow() == null ? Display .getCurrent() :
		 * PlatformUI
		 * .getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay());
		 * engine.setTheme("me.natejones.testtyco.themes.zero", true);
		 */
	}
}
