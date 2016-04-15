package bibi;

import java.util.Arrays;

public class Quick {
	public static void sort(int[] a, int low, int high){
		if(low < high){
			int position = getPosition(a, low, high);
			sort(a, low, position-1);
			sort(a, position+1, high);
		}
	}
	public static int getPosition(int[] a, int low, int high){
		int temp = a[low];
		while(low < high){
			while(low < high && a[high] >= temp){
				high--;
			}
			a[low] = a[high];
			while(low < high && a[low] <= temp){			
				low++;
			}
			a[high] = a[low];
		}
		return low;
	}
	public static void main(String[] args){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51}; 
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
