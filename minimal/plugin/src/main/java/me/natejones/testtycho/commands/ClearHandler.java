package me.natejones.testtycho.commands;

import me.natejones.testtycho.CalculatorView;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;

/**
 * @author Tony Sinisi
 * 
 *         Handles the Clear command by resetting the CalculatorView (which also
 *         resets the Calculator stacks).
 *
 */
public class ClearHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {}

	@Override
	public void dispose() {}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		((CalculatorView) HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage()
				.findViewReference("TestEclipsePlugin01.view", null)
				.getView(false)).clearNumberField();
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {}
}
