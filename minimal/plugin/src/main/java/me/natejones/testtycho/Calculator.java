package me.natejones.testtycho;

import java.util.ArrayList;

/**
 * @author Tony Sinisi
 *
 *         This class creates a calculator to be used within a CalculatorView.
 *         The string data from the view is converted to usable integers here,
 *         and the operations are performed as they appear in the input string.
 * 
 */
public class Calculator {

	private ArrayList<Integer>		args;
	private ArrayList<Character>	ops;
	private String					current;
	private CalculatorView			container;
	private boolean					eraseReady;
	private boolean					opReady;

	/**
	 * Constructor
	 * 
	 * @param view The View which contains this calculator
	 */
	public Calculator(CalculatorView view) {
		args = new ArrayList<Integer>();
		ops = new ArrayList<Character>();
		current = "";
		container = view;
		eraseReady = false;
		opReady = false;
	}

	/**
	 * Adds the next digit to the current integer
	 * 
	 * @param s The string representation of the most recent button pressed
	 *            within the parent CalculatorView
	 */
	public void pushToCurrent(String s) {
		if (eraseReady) {
			container.clearNumberField();
			eraseReady = false;
		}
		if (!opReady) {
			opReady = true;
			container.btnAdd.setEnabled(true);
			container.btnSub.setEnabled(true);
		}
		current = current + s;
	}

	/**
	 * Queues the current integer string as an integer argument, then resets the
	 * current integer string. An addition operation is then queued.
	 */
	public void addition() {
		args.add(Integer.parseInt(current));
		current = "";
		ops.add('+');
	}

	/**
	 * Queues the current integer string as an integer argument, then resets the
	 * current integer string. A subtraction operation is then queued.
	 */
	public void subtraction() {
		args.add(Integer.parseInt(current));
		current = "";
		ops.add('-');
	}

	/**
	 * Takes all arguments and operations off of their respective stacks and
	 * performs the final calculation. The stacks are then reset, as well as the
	 * boolean values, and the CalculatorView's operation buttons are then
	 * disabled.
	 * 
	 * @return int The result of the calculation
	 */
	public int evaluate() {
		args.add(Integer.parseInt(current));
		current = "";
		int total = args.get(0);
		for (int i = 0; i < ops.size(); i++) {
			if (ops.get(i) == '+') {
				total += args.get(i + 1);
			} else if (ops.get(i) == '-') {
				total -= args.get(i + 1);
			}
		}
		History.addEq(container.numberField.getText() + "=" + total);
		args.clear();
		ops.clear();
		eraseReady = true;
		opReady = false;
		container.btnAdd.setEnabled(false);
		container.btnSub.setEnabled(false);
		return total;
	}

	/**
	 * Removes all items from both stacks and sets the current integer to none.
	 */
	public void reset() {
		args = new ArrayList<Integer>();
		ops = new ArrayList<Character>();
		current = "";
	}
}
