package me.natejones.testtycho;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class CalcBtnAdapter extends SelectionAdapter {

	private Calculator	calc;
	private Text		numberField;

	public CalcBtnAdapter(Calculator c, Text nf) {
		calc = c;
		numberField = nf;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Button btn = (Button) e.getSource();
		String btnStr = (String) btn.getData();
		if (btnStr.equals("+")) {
			numberField.append("+");
			calc.addition();
		} else if (btnStr.equals("-")) {
			numberField.append("-");
			calc.subtraction();
		} else if (btnStr.equals("=")) {
			int total = calc.evaluate();
			numberField.setText(String.valueOf(total));
		} else {
			calc.pushToCurrent(btnStr);
			numberField.append(btnStr);
		}
	}
}
