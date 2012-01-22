package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	private boolean isDirected;
	private ArrayList<LinkedList<Edge>> nodes;
	
	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
		nodes = new ArrayList<LinkedList<Edge>>();
	}
	
	public void addNode(int index) {
		nodes.ensureCapacity(index);
		nodes.add(index, new LinkedList<Edge>());
	}
	
	public void addNodes(int... indecies) {
		for(int index : indecies) {
			addNode(index);
		}
	}
		
	public void addEdge(int a, int b, int weight) {
		if(isDirected) {
			nodes.get(a).add(new Edge(weight, b));
		} else {
			nodes.get(a).add(new Edge(weight, b));
			nodes.get(b).add(new Edge(weight, a));
		}
	}
	
	public void addEdge(int a, int b) {
		addEdge(a,b, 0);
	}
	
	public LinkedList<Edge> getEdges(int vertex) {
		return nodes.get(vertex);
	}
	
	public int getSize() {
		return nodes.size();
	}
}
