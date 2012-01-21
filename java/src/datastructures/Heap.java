package datastructures;

import java.util.ArrayList;

import utils.Utils;

public class Heap {
	private ArrayList<Integer> heap;
	
	public Heap() {
		heap = new ArrayList<Integer>();
	}
	
	public Heap(int[] array) {
		heap = new ArrayList<Integer>(array.length);
		for(int a : array) {
			insert(a);
		}
	}
	
	public int getParent(int n) {
		int index = (int)Math.ceil((float)n/2)-1;
		if(index == -1) {
			return -1;
		} else {
			return index;
		}			
	}
	
	public int getLeftChild(int n) {
		return n*2 + 1;
	}
	
	public int getRightChild(int n) {
		return n*2 + 2;
	}
	
	public void insert(int a) {
		heap.add(a);
		bubbleUp(heap.size()-1);
	}
	
	private void bubbleUp(int index) {
		if(index <= 0) {
			return;
		}
		if(heap.get(getParent(index)) > heap.get(index)) {
			Utils.swap(heap, index, getParent(index));
			bubbleUp(getParent(index));
		}
	}
	
	public int getMinimum() {
		int min = heap.get(0);
		int lastIndex = heap.size()-1;
		heap.set(0, heap.get(lastIndex));
		heap.remove(lastIndex);
		heapify(0);
		return min;
	}
	
	private void heapify(int index) {
		int left = getLeftChild(index);
		if(left < heap.size()) {
			if(heap.get(index) > heap.get(left)) {
				Utils.swap(heap, index, left);
				heapify(left);
			}
		}
		
		int right = getRightChild(index);
		if(right < heap.size()) {
			if(heap.get(index) > heap.get(right)) {
				Utils.swap(heap, index, right);
				heapify(right);
			}		
		}
	}
}
