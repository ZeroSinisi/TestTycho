package me.natejones.testtycho;

import java.util.ArrayList;

/**
 * @author Tony Sinisi
 * 
 *         A static database of Calculator history and History listeners.
 *
 */
public class History {

	public static ArrayList<String>				eqs			= new ArrayList<String>();
	public static ArrayList<HistoryListener>	listeners	= new ArrayList<HistoryListener>();

	/**
	 * Adds the most recent Calculator equation to the history. Afterwards, all
	 * HistoryListeners that have identified themselves to this class are
	 * notified that the history has changed.
	 * 
	 * @param eq A String representation of the Calculator equation to be added
	 *            to the history.
	 */
	public static void addEq(String eq) {
		eqs.add(eq);
		for (HistoryListener listener : listeners) {
			listener.historyUpdate();
		}
	}

	/**
	 * Adds a new HistoryListener to the list of listeners.
	 * 
	 * @param hl The listener to be added
	 */
	public static void listen(HistoryListener hl) {
		listeners.add(hl);
	}
}
