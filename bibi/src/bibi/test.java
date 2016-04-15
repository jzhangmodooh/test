package bibi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class test {
	public static int test(int[] a){
		if(a.length == 0)
			return 0;
		else if (a.length == 1)
			return a[0];
		int maxcount;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int x : a){
			Integer count = m.get(x);
		    m.put(x, count != null ? count+1 : 0);

		}
		List<Map.Entry<Integer,Integer>> l = new ArrayList<Map.Entry<Integer,Integer>>(m.entrySet());
		Collections.sort(l,new Comparator<Map.Entry<Integer, Integer>>(){
			@Override
			public int compare(Entry<Integer, Integer> arg0, Entry<Integer, Integer> arg1) {
				// TODO Auto-generated method stub
				return arg0.getValue().compareTo(arg0.getValue());
			}
		});
		int index = l.size();
		int result = l.get(index).getKey();
		return result;
	}
	public static void main(){
		System.out.println(test(new int[]{1,2,3,4,5,6,7,7,7,7}));
	}

}
