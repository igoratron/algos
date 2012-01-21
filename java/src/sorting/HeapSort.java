package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import junit.framework.Assert;

import org.junit.Test;

import utils.Utils;
import datastructures.Heap;

public class HeapSort {
	public static int[] sort(int[] unsorted) {
		Heap heap = new Heap(unsorted);
		
		for(int i=0; i < unsorted.length; i++) {
			unsorted[i] = heap.getMinimum();
		}
		
		return unsorted;
	}
	
	@Test
	public void testSort() {
		int[] test = {1,5,3,7,8,4,2};
		
		test = HeapSort.sort(test);
		
		Assert.assertTrue(Utils.isSorted(test));
	}
	
	@Test
	public void testJavaHeapSort() {
		int[] test = {1,5,3,7,8,4,2};
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int a : test) {
			heap.add(a);
		}
		
		for(int i = 0; i < test.length; i++) {
			test[i] = heap.poll();
		}
		
		Assert.assertTrue(Utils.isSorted(test));
	}
}

