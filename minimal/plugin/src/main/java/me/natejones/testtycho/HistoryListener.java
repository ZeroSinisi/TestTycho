package me.natejones.testtycho;

/**
 * @author Tony Sinisi
 * 
 * An interface that when implemented allows the implementer to become an 
 * observer of changes to the static History list.
 *
 */
public interface HistoryListener {
	public void historyUpdate();
}
