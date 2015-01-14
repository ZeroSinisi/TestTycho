package me.natejones.testtycho;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;

public class CalculatorView extends ViewPart {

	public Text numberField;
	private Calculator calc;
	public Button btnAdd;
	public Button btnSub;
	
	public CalculatorView() {
		calc = new Calculator(this);
	}
	
	public void createPartControl(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		
		parent.setLayout(new GridLayout(1, false));
		
		numberField = new Text(parent, SWT.BORDER | SWT.RIGHT);
		numberField.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		numberField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		numberField.setEditable(false);
		
		Composite buttonField = new Composite(parent, SWT.NONE);
		buttonField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		buttonField.setLayout(new GridLayout(3, false));
		
		Button btnOne = new Button(buttonField, SWT.NONE);
		btnOne.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnOne.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnOne.setText("1");
		btnOne.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("1");
				numberField.append("1");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		Button btnTwo = new Button(buttonField, SWT.NONE);
		btnTwo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnTwo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnTwo.setText("2");
		btnTwo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("2");
				numberField.append("2");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnThree = new Button(buttonField, SWT.NONE);
		btnThree.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnThree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnThree.setText("3");
		btnThree.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("3");
				numberField.append("3");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnFour = new Button(buttonField, SWT.NONE);
		btnFour.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnFour.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnFour.setText("4");
		btnFour.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("4");
				numberField.append("4");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnFive = new Button(buttonField, SWT.NONE);
		btnFive.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnFive.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnFive.setText("5");
		btnFive.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("5");
				numberField.append("5");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnSix = new Button(buttonField, SWT.NONE);
		btnSix.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnSix.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnSix.setText("6");
		btnSix.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("6");
				numberField.append("6");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnSeven = new Button(buttonField, SWT.NONE);
		btnSeven.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnSeven.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnSeven.setText("7");
		btnSeven.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("7");
				numberField.append("7");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnEight = new Button(buttonField, SWT.NONE);
		btnEight.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnEight.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnEight.setText("8");
		btnEight.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("8");
				numberField.append("8");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnNine = new Button(buttonField, SWT.NONE);
		btnNine.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnNine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNine.setText("9");
		btnNine.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("9");
				numberField.append("9");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnAdd = new Button(buttonField, SWT.NONE);
		btnAdd.setEnabled(false);
		btnAdd.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnAdd.setText("+");
		btnAdd.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberField.append("+");
				calc.addition();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnSub = new Button(buttonField, SWT.NONE);
		btnSub.setEnabled(false);
		btnSub.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnSub.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnSub.setText("-");
		btnSub.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberField.append("-");
				calc.subtraction();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnZero = new Button(buttonField, SWT.NONE);
		btnZero.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("0");
				numberField.append("0");
			}
		});
		btnZero.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnZero.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		btnZero.setText("0");
		
		Button btnEqs = new Button(parent, SWT.NONE);
		btnEqs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnEqs.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnEqs.setText("=");
		btnEqs.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				int total = calc.evaluate();
				numberField.setText(String.valueOf(total));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void clearNumberField() {
		numberField.setText("");
		calc.reset();
	}
	
	public void setFocus() {
	}

}
