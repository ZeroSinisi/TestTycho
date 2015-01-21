package me.natejones.testtycho;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * @author Tony Sinisi
 * 
 *         A ViewPart for displaying a Calculator object.
 * 
 */
public class CalculatorView extends ViewPart {

	public Text			numberField;
	private Calculator	calc;
	public Button		btnAdd;
	public Button		btnSub;

	/**
	 * Constructor
	 */
	public CalculatorView() {
		calc = new Calculator(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createPartControl(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		parent.setLayout(new GridLayout(1, false));
		/**
		 * Set up the NumberField; a field for displaying Calculator input. A
		 * menu is then inserted to the field, and three options are added. Each
		 * option changes the background of the numberField to a different
		 * color.
		 */
		numberField = new Text(parent, SWT.BORDER | SWT.RIGHT);
		numberField.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		numberField.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		numberField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		numberField.setEditable(false);
		Menu numberMenu = new Menu(numberField);
		numberField.setMenu(numberMenu);
		MenuItem mntmRed = new MenuItem(numberMenu, SWT.NONE);
		mntmRed.setText("Red");
		mntmRed.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				numberField.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		MenuItem mntmBlue = new MenuItem(numberMenu, SWT.NONE);
		mntmBlue.setText("Blue");
		mntmBlue.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				numberField.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		MenuItem mntmGreen = new MenuItem(numberMenu, SWT.NONE);
		mntmGreen.setText("Green");
		mntmGreen.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				numberField.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		/**
		 * Set up the Button field; an area containing all the numerals and
		 * operations (except evaluate).
		 */
		Composite buttonField = new Composite(parent, SWT.NONE);
		buttonField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		buttonField.setLayout(new GridLayout(3, false));
		final Button btnOne = new Button(buttonField, SWT.NONE);
		btnOne.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnOne.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnOne.setText("1");
		/**
		 * This is an example of an anonymous Selection Adapter for handling an
		 * event on the One Button.
		 */
		btnOne.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				calc.pushToCurrent("1");
				numberField.append("1");
			}
		});
		final Button btnTwo = new Button(buttonField, SWT.NONE);
		btnTwo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnTwo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnTwo.setText("2");
		/**
		 * For the rest of the buttons, the CalcBtnAdapter implementation is
		 * used. This helps reduce the amount of repeated code with in this
		 * class by not having to redefine an anonymous adapter for every
		 * button.
		 */
		btnTwo.setData("2");
		btnTwo.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnThree = new Button(buttonField, SWT.NONE);
		btnThree.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnThree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnThree.setText("3");
		btnThree.setData("3");
		btnThree.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnFour = new Button(buttonField, SWT.NONE);
		btnFour.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnFour.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnFour.setText("4");
		btnFour.setData("4");
		btnFour.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnFive = new Button(buttonField, SWT.NONE);
		btnFive.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnFive.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnFive.setText("5");
		btnFive.setData("5");
		btnFive.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnSix = new Button(buttonField, SWT.NONE);
		btnSix.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnSix.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnSix.setText("6");
		btnSix.setData("6");
		btnSix.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnSeven = new Button(buttonField, SWT.NONE);
		btnSeven.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnSeven.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnSeven.setText("7");
		btnSeven.setData("7");
		btnSeven.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnEight = new Button(buttonField, SWT.NONE);
		btnEight.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnEight.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnEight.setText("8");
		btnEight.setData("8");
		btnEight.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnNine = new Button(buttonField, SWT.NONE);
		btnNine.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnNine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNine.setText("9");
		btnNine.setData("9");
		btnNine.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		btnAdd = new Button(buttonField, SWT.NONE);
		btnAdd.setEnabled(false);
		btnAdd.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnAdd.setText("+");
		btnAdd.setData("+");
		btnAdd.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		btnSub = new Button(buttonField, SWT.NONE);
		btnSub.setEnabled(false);
		btnSub.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnSub.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnSub.setText("-");
		btnSub.setData("-");
		btnSub.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnZero = new Button(buttonField, SWT.NONE);
		btnZero.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnZero.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		btnZero.setText("0");
		btnZero.setData("0");
		btnZero.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		/**
		 * Sets up the bottom bar; an area for addition calculation features.
		 * The evaluate operator and a checkbox toggle are added to the bottom
		 * bar. The checkbox toggle changes the face buttons from base 10 to
		 * base 2 and back.
		 */
		Composite bottomBar = new Composite(parent, SWT.NONE);
		bottomBar.setLayout(new GridLayout(2, false));
		bottomBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		Button btnEqs = new Button(bottomBar, SWT.NONE);
		btnEqs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnEqs.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnEqs.setText("=");
		btnEqs.setData("=");
		btnEqs.addSelectionListener(new CalcBtnAdapter(calc, numberField));
		final Button btnBinaryToggle = new Button(bottomBar, SWT.CHECK);
		btnBinaryToggle.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnBinaryToggle.setText("Base 2");
		btnBinaryToggle.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnBinaryToggle.getSelection()) {
					btnZero.setText("0000");
					btnOne.setText("0001");
					btnTwo.setText("0010");
					btnThree.setText("0011");
					btnFour.setText("0100");
					btnFive.setText("0101");
					btnSix.setText("0110");
					btnSeven.setText("0111");
					btnEight.setText("1000");
					btnNine.setText("1001");
				} else {
					btnZero.setText("0");
					btnOne.setText("1");
					btnTwo.setText("2");
					btnThree.setText("3");
					btnFour.setText("4");
					btnFive.setText("5");
					btnSix.setText("6");
					btnSeven.setText("7");
					btnEight.setText("8");
					btnNine.setText("9");
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	/**
	 * Clears the visual numberField and also clears the Calculator.
	 */
	public void clearNumberField() {
		numberField.setText("");
		calc.reset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {}
}
