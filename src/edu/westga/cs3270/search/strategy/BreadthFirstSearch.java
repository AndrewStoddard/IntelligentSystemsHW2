package edu.westga.cs3270.search.strategy;

import edu.westga.cs3270.search.model.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents the BFS algorithm - uses queue data structure
 * 
 * @author CS3270
 */
public class BreadthFirstSearch {

	private State startState;
	private State goalState;

	/**
	 * Initializes the start and goal states of the search strategy.
	 * 
	 * @precondition start != null && goal != null
	 * @postcondition none
	 * @param start the start state in the tree
	 * @param goal  the goal state in the tree
	 */
	public BreadthFirstSearch(State start, State goal) {
		this.startState = start;
		this.goalState = goal;
	}

	/**
	 * Executes BF search in a state graph using a queue until the [first] goal is
	 * found.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return a string listing all nodes as they are visited in BFS, from start to
	 *         the first goal found
	 */
	public String search() {

		if (this.startState.equals(this.goalState)) {
			System.out.println("Solution found.");
		}

		ArrayList<String> orderedStates = new ArrayList<String>();
		orderedStates.add(this.startState.toString());
		Queue<State> queue = new LinkedList<State>();
		// TO-DO
		return orderedStates.toString();

	}

}