package me.natejones.testtycho;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.GridData;

/**
 * @author Tony Sinisi
 * 
 *         A ViewPart for displaying the complete history of Calculator
 *         evaluations.
 *
 */
public class HistoryView extends ViewPart implements HistoryListener {

	List	historyList;

	/**
	 * Constructor
	 */
	public HistoryView() {
		History.listen(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		historyList = new List(parent, SWT.BORDER);
		historyList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		for (String eq : History.eqs) {
			historyList.add(eq);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {}

	/*
	 * (non-Javadoc)
	 * 
	 * @see me.natejones.testtycho.HistoryListener#historyUpdate()
	 */
	@Override
	public void historyUpdate() {
		historyList.removeAll();
		for (String eq : History.eqs) {
			historyList.add(eq);
		}
	}
}
