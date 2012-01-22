package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import utils.Utils;

class MergeSortImpl {
	private int[] array;
	private Comparator<Integer> cmp;
	
	public MergeSortImpl(int[] array, Comparator<Integer> cmp) {
		this.array = array;
		this.cmp = cmp;
	}
	
	public int[] sort() {
		sort(0, array.length-1);
		return array;
	}
	
	private void sort(int left, int right) {
		if(left >= right)
			return;
		int m = (left + right)/2;
		sort(left, m);
		sort(m+1, right);
		merge(left, m, right);
	}
	
	private void merge(int left, int middle, int right) {
		LinkedList<Integer> leftQ = new LinkedList<Integer>();
		LinkedList<Integer> rightQ = new LinkedList<Integer>();
		
		int i;
		for(i = left; i <= middle; i++) leftQ.add(array[i]);
		for(i = middle+1; i <= right; i++) rightQ.add(array[i]);
		
		i = left;
		while(!leftQ.isEmpty() && !rightQ.isEmpty()) {
			if(cmp.compare(leftQ.peek(), rightQ.peek()) < 0) {
				array[i] = leftQ.remove();
			} else {
				array[i] = rightQ.remove();
			}
			i += 1;
		}
		
		while(!leftQ.isEmpty()) {
			array[i] = leftQ.remove();
			i += 1;
		}
		
		while(!rightQ.isEmpty()) {
			array[i] = rightQ.remove();
			i += 1;
		}
	}
}

public class MergeSort {
	@Test
	public void testSort() {
		int[] test = new int[] {1,5,3,7,8,4,2};

		test = new MergeSortImpl(test, new Utils.IntegerComparator()).sort();
		
		Assert.assertTrue(Utils.isSorted(test));
	}
}