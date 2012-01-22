package datastructures;

import java.util.LinkedList;

public class Edge {
	private int weight;
	private int node;
	
	public Edge(int weight, int node) {
		this.weight = weight;
		this.node = node;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getNode() {
		return node;
	}
}
