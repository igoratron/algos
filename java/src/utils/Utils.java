package utils;

import java.util.List;

public class Utils {
	public static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	public static <T> void swap(List<T> array, int a, int b) {
		T tmp = array.get(a);
		array.set(a, array.get(b));
		array.set(b, tmp);
	}
	
	public static boolean isSorted(int[] array) {
		for(int i=1; i<array.length; i++) {
			if(array[i] < array[i-1])
				return false;
		}
		return true;
	}
	
	
}


