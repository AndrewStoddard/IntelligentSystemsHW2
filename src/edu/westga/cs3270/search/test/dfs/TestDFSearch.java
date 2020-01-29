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


	
	@Test
	void testIfSearchGoesLeftFirst() {
		State successorCR = new State("T2A", null, null);
		State successorAL = new State("T2Goal", null, null);
		State start = new State("T2Start", successorCR, successorAL);

		DepthFirstSearch dfs = new DepthFirstSearch(start, successorAL);
		assertEquals("[T2Start, T2A, T2Goal]", dfs.search());
	}

	@Test
	void testFirstStateIsGoalStateWithNothingAfter() {
		State goalState = new State("T3Goal", null, null);

		DepthFirstSearch dfs = new DepthFirstSearch(goalState, goalState);
		assertEquals("[T3Goal]", dfs.search());
	}

	@Test
	void testFirstStateIsGoalStateWithFollowingStates() {
		State successorBL = new State("T4E", null, null);
		State successorBR = new State("T4F", null, null);
		State successorCL = new State("T4Goal", successorBL, successorBR);

		DepthFirstSearch dfs = new DepthFirstSearch(successorCL, successorCL);
		assertEquals("[T4Goal]", dfs.search());
	}

	@Test
	void testGoalStateHasStatesBeforeAndAfter() {
		State successorCR = new State("T5H", null, null);
		State successorAL = new State("T5Goal", null, successorCR);
		State successorAR = new State("T5D", null, null);
		State successorSL = new State("T5A", successorAL, successorAR);
		State successorBL = new State("T5E", null, null);
		State successorBR = new State("T5F", null, null);
		State successorSR = new State("T5B", successorBL, successorBR);
		State start = new State("T5Start", successorSL, successorSR);

		DepthFirstSearch dfs = new DepthFirstSearch(start, successorAL);
		assertEquals("[T5Start, T5A, T5Goal]", dfs.search());
	}

	@Test
	void testUnreachableGoalState() {
		State successorCL = new State("T6Goal", null, null);
		State successorCR = new State("T6H", null, null);
		State successorAL = new State("T6C", null, successorCR);
		State successorAR = new State("T6D", null, null);
		State successorSL = new State("T6A", successorAL, successorAR);
		State successorBL = new State("T6E", null, null);
		State successorBR = new State("T6F", null, null);
		State successorSR = new State("T6B", successorBL, successorBR);
		State start = new State("T6Start", successorSL, successorSR);

		DepthFirstSearch dfs = new DepthFirstSearch(start, successorCL);
		assertEquals("[T6Start, T6A, T6C, T6H, T6D, T6B, T6E, T6F]", dfs.search());
	}



}
