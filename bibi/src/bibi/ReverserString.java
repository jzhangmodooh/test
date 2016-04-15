package bibi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReverserString {
	public static void main(String[] args){
		String t = "I love, you!";
		String[] y = t.split(" |!|, ");
		System.out.print(y[1]);
//1
//		char[] tArray = t.toCharArray();
//		char temp;
//		int tail = tArray.length-1;
//		for(int head = 0; head < tail; head++, tail--){
//			temp = tArray[head];
//			tArray[head] = tArray[tail];
//			tArray[tail] = temp;
//		}
//		for(char x:tArray){
//			System.out.print(x);
//		}
//2		
//		char[] tArray = t.toCharArray();
//		List<Character> temp= new LinkedList<>();
//		for(char x : tArray){
//			temp.add(x);
//		}
//		Collections.reverse(temp);
//		Iterator<Character> li = temp.iterator();
//		while(li.hasNext())
//			System.out.print(li.next());
		
		List<String> temp= new ArrayList<>(Arrays.asList(t.split("")));
		System.out.print(t.split("").length);
	}

}