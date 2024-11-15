package gui;


public class Generator extends Thread {

	private Svemir svemir;
	private boolean work1;
	public Generator(Svemir svemir) {
		this.svemir = svemir;
		start();
		go();
	}
	
	public void run() {
		try {
			while(!isInterrupted()) {
				
				synchronized(this) {
					while(!work1) {
						wait();
					}
				}
				
			
				sleep(900);
				int x = (int)(Math.random()*200);
				int y = 0;
				int r = 10 + (int)(Math.random()*20);
				Kometa k = new Kometa(x, y, r);
				svemir.dodajTelo(k);
			}
		}catch(InterruptedException e) {}
		
	}
		
	public synchronized void go() {
		work1 = true;
		notify();
	}
}
