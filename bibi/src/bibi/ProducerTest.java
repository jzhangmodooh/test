package bibi;

public class ProducerTest {
	static class  CubbyHole {
		private int content;
		private boolean available = false;
		public synchronized int get(){
			while (available == false){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
			available = false;
			notifyAll();
			return content;
		}
		public synchronized void put(int value){
			while(available == true){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			content = value;
			System.out.println(value);
			available = true;
			notifyAll();
		}
	}
	
	static class consumer extends Thread{
		private CubbyHole cubbyhole;
		private int number;
		public consumer(CubbyHole c, int number){
			this.cubbyhole = c;
			this.number = number;
		}
		public void run(){
			int value = 0;
			for(int i = 0; i < 10; i++){
				value = cubbyhole.get();
				System.out.println("consumer #"+number+" consumed "+ value);
			}
		}
	}
	
	static class producer extends Thread{
		private CubbyHole cubbyhole;
		private int number;
		public producer(CubbyHole c, int number){
			this.cubbyhole = c;
			this.number = number;
		}
		public void run(){
			for(int i = 0; i < 10; i++){
				cubbyhole.put(i);
				System.out.println("producer #"+number+" produced "+ i);
				try {
					sleep((int)(Math.random() * 100));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	   public static void main(String[] args) {
		      CubbyHole c = new CubbyHole();
		      producer p1 = new producer(c, 1);
		      consumer c1 = new consumer(c, 1);
		      p1.start(); 
		      c1.start();
		   }
}
