package bibi;

public class Multi extends Thread {
	 
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                	try{
                		Thread.sleep(1000);
                		System.out.println(str1 + str2);
                		str1.wait();
                	}catch(InterruptedException e){
                		e.printStackTrace();
                	}
//                    synchronized(str2){
//                        System.out.println(str1 + str2);
//                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str1){
                	try {
                		str1.notify();
						Thread.sleep(1000);						
						System.out.println(str2 + str1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//                    synchronized(str2){               	
//                        System.out.println(str2 + str1);
//                        str2.notify();
//                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
    	Multi mdl = new Multi();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}
