package edu.westga.cs3270.search.test.dfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.westga.cs3270.search.model.State;
import edu.westga.cs3270.search.strategy.DepthFirstSearch;

/**
 * Ensures correct functionality of the DFS strategy.
 * 
 * @author CS3270
 */
public class TestDFSearch {

	/**
	 * This test passes.
	 */
	@Test
	void testInvalidSearch() {
		State successor = new State("B", null, null);
		State start = new State("A", successor, null);
		DepthFirstSearch dfs = new DepthFirstSearch(successor, start);
		assertEquals("[B]", dfs.search());
	}

	/**
	 * This test doesn't pass until you complete DepthFirstSsarch::search()
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

		DepthFirstSearch dfs = new DepthFirstSearch(start, successorCL);
		assertEquals("[Start, A, C, Goal]", dfs.search());
	}

}
