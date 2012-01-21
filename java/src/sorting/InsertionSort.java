package sorting;

import junit.framework.Assert;

import org.junit.Test;

import utils.Utils;

public class InsertionSort {
	public static int[] sort(int[] unsorted) {
		for(int i=1; i<unsorted.length; i++) {
			int current = unsorted[i];
			
			boolean done = false;
			int j = i-1;
			do {
				if(unsorted[j] > current) {
					unsorted[j+1] = unsorted[j];
					j -= 1;
					if(j < 0){
						done = true;
					}
				} else {
					done = true;
				}				
			} while(!done);
			unsorted[j+1] = current;
		}
		return unsorted;
	}
	
	@Test
	public void testSort() {
		int[] test = {1,5,3,7,8,4,2};
		
		test = InsertionSort.sort(test);
		
		Assert.assertTrue(Utils.isSorted(test));
	}
}
