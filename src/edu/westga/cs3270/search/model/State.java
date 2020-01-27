package edu.westga.cs3270.search.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The State class represents a node in a state graph structured as a binary
 * tree, for example:
 * 
 *        Start 
 *        /   \ 
 *       A     B 
 *      / \   / \ 
 *     C   D E   F 
 *    / \ 
 * Goal  H
 *
 * @author CS3270
 */
public class State {

	private String stateName;
	private State leftChild;
	private State rightChild;

	/**
	 * 
	 * Creates a State in a binary tree with the given name and left/right
	 * successors.
	 * 
	 * @param stateName   the name of the state
	 * @param firstChild  the first successor
	 * @param secondChild the second successor
	 */
	public State(String stateName, State firstChild, State secondChild) {
		this.stateName = stateName;
		this.leftChild = firstChild;
		this.rightChild = secondChild;
	}

	/**
	 * Returns the current state's successors from left to right.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return successors the list of successor state(s)
	 */
	public ArrayList<State> getSuccessors() {

		ArrayList<State> successors = new ArrayList<State>();
		if (this.leftChild != null) {
			successors.add(this.leftChild);
		}
		if (this.rightChild != null) {
			successors.add(this.rightChild);
		}
		return successors;
	}

	/**
	 * Returns the current state's successors from right to left.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return successors the list of successor state(s)
	 */
	public ArrayList<State> getSuccessorsReversed() {
		ArrayList<State> successors = this.getSuccessors();
		Collections.reverse(successors);
		return successors;
	}

	@Override
	public String toString() {
		return this.stateName;
	}

}
