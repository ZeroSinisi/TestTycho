package me.natejones.testtycho;

import java.util.ArrayList;

public class Calculator {

	private ArrayList<Integer> args;
	private ArrayList<Character> ops;
	private String current;
	private CalculatorView container;
	private boolean eraseReady;
	private boolean opReady;
	
	public Calculator(CalculatorView view) {
		args = new ArrayList<Integer>();
		ops = new ArrayList<Character>();
		current = "";
		container = view;
		eraseReady = false;
		opReady = false;
	}
	
	public void pushToCurrent(String s) {
		if(eraseReady) {
			container.clearNumberField();
			eraseReady = false;
		}
		if(!opReady) {
			opReady = true;
			container.btnAdd.setEnabled(true);
			container.btnSub.setEnabled(true);
		}
		current = current + s;
	}
	
	public void addition() {
		args.add(Integer.parseInt(current));
		current = "";
		ops.add('+');
	}
	
	public void subtraction() {
		args.add(Integer.parseInt(current));
		current = "";
		ops.add('-');
	}
	
	public int evaluate() {
		args.add(Integer.parseInt(current));
		current = "";
		int total = args.get(0);
		for(int i = 0; i < ops.size(); i++) {
			if(ops.get(i) == '+') {
				total += args.get(i+1);
			} else if(ops.get(i) == '-') {
				total -= args.get(i+1);
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
	
	public void reset() {
		args = new ArrayList<Integer>();
		ops = new ArrayList<Character>();
		current = "";
	}
	
}
