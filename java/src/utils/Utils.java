package utils;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
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
	
	public static <T> boolean isSorted(Collection<T> collection, Comparator<T> cmp) {
		Iterator<T> iter = collection.iterator();
		T previous = iter.next();
		T current = null;
		
		while(iter.hasNext()) {
			current = iter.next();
			if(cmp.compare(previous, current) > 0) {
				return false;
			}
			previous = current;
		}
		
		return true;
	}
	
	public static class IntegerComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.signum(o1 - o2);
		}
	}
}


