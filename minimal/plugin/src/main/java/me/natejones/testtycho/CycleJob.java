package me.natejones.testtycho;

import java.util.Random;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CycleJob extends SelectionAdapter {

	private final Shell	shell;
	private Display		display;
	private Label		colorField;

	public CycleJob(Shell shell, Display display, Label colorField) {
		this.shell = shell;
		this.display = display;
		this.colorField = colorField;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Job job = new Job("Cycle Colors") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				cycleColors(monitor);
				syncWithUi();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
	}

	private void cycleColors(IProgressMonitor monitor) {
		while (!monitor.isCanceled()) {
			display.asyncExec(new Runnable() {

				@Override
				public void run() {
					final int[] rgb = randomColor();
					colorField.setBackground(new Color(display, rgb[0], rgb[1], rgb[2]));
				}
			});
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void syncWithUi() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				MessageDialog.openInformation(shell, "Color Cycler", "Colors have finished cycling.");
			}
		});
	}

	public int[] randomColor() {
		int r, g, b;
		Random rand = new Random();
		r = rand.nextInt(255);
		g = rand.nextInt(255);
		b = rand.nextInt(255);
		int[] rgb = { r, g, b };
		return rgb;
	}
}
