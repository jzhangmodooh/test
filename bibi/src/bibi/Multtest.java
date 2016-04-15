package bibi;

public class Multtest {
	static class Res{
		private int value;
		private boolean available = false;
		public synchronized int get(){
			while(available == false){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			available = false;
			notifyAll();
			return value;
		}
		public synchronized void put(int i){
			while(available == true){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			available = true;
			value = i;
		    notifyAll();
			}
		}
     
	static class consumer extends Thread{
		private int id;
		private Res res;
		public consumer(Res res, int id){
			this.id = id;
			this.res = res;
		}
		public void run(){
			int value;
			for(int i = 0; i < 10; i++){
				value = res.get();
				System.out.println("consumed " + value);
			}
		}
	}
	
	static class producer extends Thread{
		private int id;
		private Res res;
		public producer(Res res, int id){
			this.id = id;
			this.res = res;
		}
		public void run(){
			for(int i = 0; i < 10; i++){
				res.put(i);
				System.out.println("produced " + i);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args){
		Res res = new Res();
		Thread p = new producer(res, 1);
		Thread c = new consumer(res, 1);
		p.start();
		c.start();
	}
}
