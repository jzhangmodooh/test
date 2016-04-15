package bibi;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Merge {
	public static void sort(int[] a, int low, int high){
		if(low < high){
			int mid = (low+high)/2;
//			System.out.println("a");
			sort(a, low, mid);
			sort(a, mid+1, high);
			
			merge(a, low, mid, high);
		}
	}

	private static void merge(int[] data, int left, int center, int right) {
		// TODO Auto-generated method stub
		int[] tempArr = new int[data.length];
	    int	mid = center+1;
		int third = left;
		int temp = left;
		while(left <= center && mid <= right){
			if(data[left] <= data[mid]){
				tempArr[third++] = data[left++];
			}else{
				tempArr[third++] = data[mid++];
			}
				
		}
		while(left <= center)
			tempArr[third++] = data[left++];
		while(mid <= right)
			tempArr[third++] = data[mid++];
		while(temp <= right){
			System.out.println(data[temp]);
			data[temp] = tempArr[temp++];
			
		}
		System.out.print(Arrays.toString(data));
	}
	
	public static void main(String[] args){
		int a[]={49,38,65,97};
		String[] b = {"a","b","c"};
		String m = "apple";
		String l = m.substring(0,1);
		String[] n = m.split("");
		List<String> list = new LinkedList<String>(Arrays.asList(n));
		Iterator it = list.listIterator(3);
		while(it.hasNext()){
			System.out.println(it.next());
		}
//		for(String t : n)
		System.out.println(String.join("-", b));
		sort(a, 0, a.length-1);
	}

}
//import java.util.Arrays;  
//
//public class Merge {  
//int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
// 
//public static void sort(int[] data, int left, int right) {  
//    // TODO Auto-generated method stub  
//    if(left<right){  
//        //找出中间索引  
//        int center=(left+right)/2;  
//        //对左边数组进行递归  
//        sort(data,left,center);  
//        //对右边数组进行递归  
//        sort(data,center+1,right);  
//        //合并  
//        merge(data,left,center,right);  
//          
//    }  
//}  
//public static void merge(int[] data, int left, int center, int right) {  
//    // TODO Auto-generated method stub  
//    int [] tmpArr=new int[data.length];  
//    int mid=center+1;  
//    //third记录中间数组的索引  
//    int third=left;  
//    int tmp=left;  
//    while(left<=center&&mid<=right){  
//        //从两个数组中取出最小的放入中间数组  
//        if(data[left]<=data[mid]){  
//            tmpArr[third++]=data[left++];  
//        }else{  
//            tmpArr[third++]=data[mid++];  
//        }  
//    }  
//    //剩余部分依次放入中间数组  
//    while(mid<=right){  
//        tmpArr[third++]=data[mid++];  
//    }  
//    while(left<=center){  
//        tmpArr[third++]=data[left++];  
//    }  
//    //将中间数组中的内容复制回原数组  
//    while(tmp<=right){  
//        data[tmp]=tmpArr[tmp++];  
//    }  
//    System.out.println(Arrays.toString(data));  
//}  
//public static void main(String[] args){
//	int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
////System.out.print(a.length-1);
//sort(a, 0, a.length-1);
//}
//} 