package edu.westga.cs3270.search.strategy;

import edu.westga.cs3270.search.model.State;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Represents the DFS algorithm - uses stack data structure
 * 
 * @author CS3270
 */
public class DepthFirstSearch {

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
	public DepthFirstSearch(State start, State goal) {
		this.startState = start;
		this.goalState = goal;
	}

	/**
	 * Executes the search in a state graph. For hints, look at Lecture 3, starting
	 * with slide 30.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return a string listing all nodes as they are visited in DFS.
	 */
	public String search() {
		if (this.startState.equals(this.goalState)) {
			System.out.println("Solution found.");
		}

		ArrayList<String> orderedStates = new ArrayList<String>();
		Stack<State> stack = new Stack<State>();
		orderedStates.add(this.startState.toString());
		ArrayList<State> visited = new ArrayList<State>();
		State currState = null;
		stack.push(this.startState);
		while (!stack.isEmpty()) {
			currState = stack.pop();
			if (!visited.contains(currState)) {
				visited.add(currState);
				if (!orderedStates.contains(currState.toString()) && !orderedStates.contains(this.goalState.toString())) {
					orderedStates.add(currState.toString());
				}
				if (currState.equals(this.goalState)) {
					System.out.println("Solution found.");
				}
				for (State state : currState.getSuccessorsReversed()) {
					if (!visited.contains(state)) {
						stack.push(state);
					}
				}
			}
		}
		// TO-DO
		return orderedStates.toString();
	}
}