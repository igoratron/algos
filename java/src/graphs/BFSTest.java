package graphs;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import datastructures.Edge;
import datastructures.Graph;

class BFS {
	private Graph graph;
	private int[] state;
	private int[] parent;
	
	private static final int UNDISCOVERED = 0;
	private static final int DISCOVERED = 1;
	private static final int PROCESSED = 2;
	
	public BFS(Graph g) {
		graph = g;
		state = new int[g.getSize()];
		parent = new int[g.getSize()];
		Arrays.fill(state, UNDISCOVERED);
	}
	
	public void process() {
		bfs(0);
	}
	
	private void bfs(int index) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		parent[index] = -1;
		
		while(!queue.isEmpty()) {
			int node = queue.remove();

			System.out.println(node);
			
			for(Edge e : graph.getEdges(node)) {
				if(state[e.getNode()] == UNDISCOVERED) {
					state[e.getNode()] = DISCOVERED;
					parent[e.getNode()] = node;
					queue.add(e.getNode());
				}
			}
			
			state[node] = PROCESSED;
		}
	}
}

public class BFSTest {
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
		
		new BFS(g).process();
	}
}