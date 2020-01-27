package edu.westga.cs3270.search.test.bfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.westga.cs3270.search.model.State;
import edu.westga.cs3270.search.strategy.BreadthFirstSearch;

/**
 * Ensures correct functionality of the BFS strategy.
 * 
 * @author CS3270
 */
public class TestBFSearch {

	/**
	 * This test passes.
	 */
	@Test
	void testInvalidSearch() {
		State successor = new State("B", null, null);
		State start = new State("A", successor, null);
		BreadthFirstSearch bfs = new BreadthFirstSearch(successor, start);
		assertEquals("[B]", bfs.search());
	}

	/**
	 * This test doesn't pass until you complete BreadthFirstSsarch::search()
	 */
	@Test
	void testValidSearch() {

		State successorCL = new State("Goal", null, null);
		State successorCR = new State("H", null, null);
		State successorAL = new State("C", successorCL, successorCR);
		State successorAR = new State("D", null, null);
		State successorSL = new State("A", successorAL, successorAR);
		State successorBL = new State("E", null, null);
		State successorBR = new State("F", null, null);
		State successorSR = new State("B", successorBL, successorBR);
		State start = new State("Start", successorSL, successorSR);

		BreadthFirstSearch bfs = new BreadthFirstSearch(start, successorCL);
		assertEquals("[Start, A, B, C, D, E, F, Goal]", bfs.search());
	}

}
