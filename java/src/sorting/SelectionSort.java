package sorting;

import java.util.Comparator;

import junit.framework.Assert;

import org.junit.Test;

import utils.Utils;

public class SelectionSort {
	public static int[] sort(int[] unsorted, Comparator<Integer> cmp) {
		for(int i=0; i < unsorted.length; i++) {
			int min = i;
			for(int j=i; j < unsorted.length; j++) {
				if(cmp.compare(unsorted[j], unsorted[min]) < 0) {
					min = j;
				}
			}
			Utils.swap(unsorted, i, min);
		}
		return unsorted;
	}
	
	@Test
	public void testSort() {
		int[] test = {1,5,3,7,8,4,2};
		
		test = SelectionSort.sort(test, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.signum(o1 - o2);
			}
		});
		
		Assert.assertTrue(Utils.isSorted(test));
	}
}

