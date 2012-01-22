package sorting;

import java.util.Comparator;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

import utils.Utils;

class QuickSort {
	private int[] array;
	private Comparator<Integer> cmp;
	
	public QuickSort(int[] unsorted, Comparator<Integer> cmp) {
		array = unsorted;
		this.cmp = cmp;
	}
	public int[] sort() {
		sort(0, array.length-1);
		return array;
	}
	
	private void sort(int l, int r) {
		if(l < r) {
			int p = partition(l,r);
			sort(l, p-1);
			sort(p+1, r);
		}
	}
	
	private int partition(int l, int r) {
		int pivotIndex = new Random().nextInt(r-l+1) + l;
		int pivot = array[pivotIndex];
		Utils.swap(array, pivotIndex, r);
		
		int firstHigh = l;
		
		for(int i = l; i < r; i++) {
			if(cmp.compare(array[i], pivot) < 0) {
				Utils.swap(array, i, firstHigh);
				firstHigh += 1;
			}
		}
		
		Utils.swap(array, r, firstHigh);
		
		return firstHigh;
	}
}

public class QuickSortTest {
	@Test
	public void testSort() {
		int[] test = {1,5,3,7,8,4,2};
		
		test = new QuickSort(test, new Utils.IntegerComparator()).sort();
		
		Assert.assertTrue(Utils.isSorted(test));
	}
}
