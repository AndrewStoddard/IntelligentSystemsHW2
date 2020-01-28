package edu.westga.cs3270.search.test.bfs;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

		State successorCL = new State("T1Goal", null, null);
		State successorCR = new State("T1H", null, null);
		State successorAL = new State("T1C", successorCL, successorCR);
		State successorAR = new State("T1D", null, null);
		State successorSL = new State("T1A", successorAL, successorAR);
		State successorBL = new State("T1E", null, null);
		State successorBR = new State("T1F", null, null);
		State successorSR = new State("T1B", successorBL, successorBR);
		State start = new State("T1Start", successorSL, successorSR);

		BreadthFirstSearch bfs = new BreadthFirstSearch(start, successorCL);
		assertEquals("[T1Start, T1A, T1B, T1C, T1D, T1E, T1F, T1Goal]", bfs.search());
	}

	@Test
	void testIfSearchGoesLeftFirst() {
		State successorCR = new State("T2A", null, null);
		State successorAL = new State("T2Goal", null, null);
		State start = new State("T2Start", successorCR, successorAL);

		BreadthFirstSearch bfs = new BreadthFirstSearch(start, successorAL);
		assertEquals("[T2Start, T2A, T2Goal]", bfs.search());
	}

	@Test
	void testFirstStateIsGoalStateWithNothingAfter() {
		State goalState = new State("T3Goal", null, null);

		BreadthFirstSearch bfs = new BreadthFirstSearch(goalState, goalState);
		assertEquals("[T3Goal]", bfs.search());
	}

	@Test
	void testFirstStateIsGoalStateWithFollowingStates() {
		State successorBL = new State("T4E", null, null);
		State successorBR = new State("T4F", null, null);
		State successorCL = new State("T4Goal", successorBL, successorBR);

		BreadthFirstSearch bfs = new BreadthFirstSearch(successorCL, successorCL);
		assertEquals("[T4Goal]", bfs.search());
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

		BreadthFirstSearch bfs = new BreadthFirstSearch(start, successorAL);
		assertEquals("[T5Start, T5A, T5B, T5Goal]", bfs.search());
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

		BreadthFirstSearch bfs = new BreadthFirstSearch(start, successorCL);
		assertEquals("[T6Start, T6A, T6B, T6C, T6D, T6E, T6F, T6H]", bfs.search());
	}



}
