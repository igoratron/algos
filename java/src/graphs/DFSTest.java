package graphs;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import datastructures.Edge;
import datastructures.Graph;

class DFS {
	private Graph graph;
	private int[] state;
	private int[] parent;
	
	private static final int UNDISCOVERED = 0;
	private static final int DISCOVERED = 1;
	private static final int PROCESSED = 2;
	
	public DFS(Graph g) {
		graph = g;
		state = new int[g.getSize()];
		parent = new int[g.getSize()];
		Arrays.fill(state, UNDISCOVERED);
	}
	
	public void process() {
		dfs(0);
		parent[0] = 0;
	}
	
	private void dfs(int index) {
		LinkedList<Edge> neighbours = graph.getEdges(index);
		
		state[index] = DISCOVERED;
		System.out.println(index);
				
		for(Edge e : neighbours) {
			if(state[e.getNode()] == UNDISCOVERED) {
				parent[e.getNode()] = index;
				dfs(e.getNode());
			}
		}
		
		state[index] = PROCESSED;
	}
}

public class DFSTest {
	@Test
	public void testBFS() {
		Graph g = new Graph(false);
		g.addNodes(0,1,2,3,4,5,6,7);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		
		new DFS(g).process();
	}
}