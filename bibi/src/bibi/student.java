package bibi;

public class student {
	private int id;
	private String name;
	public  student(int a, String b){
		this.setId(a);
		this.setName(b);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = new String(name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean equals(student x){
		if(this.getId() == x.getId()&& this.getName()==x.getName())
			return true;
		else
			return false;
		
	}
	public static void main(String[] args){
		student A = new student(1,"xiao B");
		student B = new student(1,"xiao B");
		System.out.print(A.getName() == B.getName());
	}
}
