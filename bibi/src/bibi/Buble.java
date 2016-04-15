package bibi;

public class Buble {
	public static void Buble(int[] a){
		int len = a.length;
		for(int i = 0; i < len-1; i++){
			for(int j = 0; j < len - i - 1; j++){
				if(a[j] > a [j+ 1]){
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int x: a)
		System.out.println(x);
	}
	public static void main(String[] args){
		int[] a = {1,54,6,3,78,34,12,45};
		Buble(a);
	}

}
