package bibi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static boolean isAnagrams1(String a, String b){
		if(a.length() != b.length()){
			System.out.println(a.length()+"....."+b.length());
			return false;
		}
		char[] tempA = a.toCharArray();
		char[] tempB = b.toCharArray();
		Arrays.sort(tempA);
//		System.out.print(tempA[0]);
		Arrays.sort(tempB);
//		System.out.print(tempB[0]);
		if(Arrays.equals(tempA, tempB))
			return true;
		else
			return false;
		
	}
	
	public static boolean isAnagrams2(String a, String b){
		if(a.length() != b.length()){
			System.out.println(a.length()+"....."+b.length());
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<a.length(); i++)
		{
			int occurA = map.containsKey(a.charAt(i))?(int) map.get(a.charAt(i)):0;
			System.out.println(map.size());
			System.out.println(map.toString());
			map.put(a.charAt(i), ++occurA);
			int occurB = map.containsKey(b.charAt(i))?(int) map.get(b.charAt(i)):0;
			map.put(b.charAt(i), --occurB);				
//			String m = "abcde";
//			StringBuilder sb = new StringBuilder(m);
		}
		for(int j : map.values()){
			if(j != 0)
				return false;
		}
			return true;
	}
	
	public static void main(String[] args){
		System.out.print(isAnagrams2("asdf","fdas"));
	}

}
