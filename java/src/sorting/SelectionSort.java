package sorting;

import junit.framework.Assert;

import org.junit.Test;

import utils.Utils;

public class SelectionSort {
	public static int[] sort(int[] unsorted) {
		for(int i=0; i < unsorted.length; i++) {
			int min = i;
			for(int j=i; j < unsorted.length; j++) {
				if(unsorted[j] < unsorted[min]) {
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
		
		test = SelectionSort.sort(test);
		
		Assert.assertTrue(Utils.isSorted(test));
	}
}

