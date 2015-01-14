package me.natejones.testtycho;

import java.util.ArrayList;

public class History {
	
	public static ArrayList<String> eqs = new ArrayList<String>();
	public static ArrayList<HistoryListener> listeners = new ArrayList<HistoryListener>();
	
	public static void addEq(String eq) {
		eqs.add(eq);
		for (HistoryListener listener: listeners) {
			listener.historyUpdate();
		}
	}
	
	public static void listen(HistoryListener hl) {
		listeners.add(hl);
	}

}
