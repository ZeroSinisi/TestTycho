package me.natejones.testtycho;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.GridData;

public class HistoryView extends ViewPart implements HistoryListener {

	List historyList;
	
	public HistoryView() {
		History.listen(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		historyList = new List(parent, SWT.BORDER);
		historyList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		for(String eq: History.eqs) {
			historyList.add(eq);
		}

	}

	@Override
	public void setFocus() {

	}

	@Override
	public void historyUpdate() {
		historyList.removeAll();
		for(String eq: History.eqs) {
			historyList.add(eq);
		}
	}

}
