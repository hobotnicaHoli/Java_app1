package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable{
	private ArrayList<NebeskoTelo> nebeskaTela = new ArrayList<>();
	Thread thread;
	private boolean work;
	
	public Svemir() {
		if(thread != null) {
			thread.interrupt();
		}
		setBackground(Color.BLACK);
		thread = new Thread(this);
		thread.start();
		go();
	}

	public void paint(Graphics g) {
		for(int i = 0; i < nebeskaTela.size(); i++) {
			Graphics g1 = getGraphics();
			if(g1 != null) {
			g1.translate(nebeskaTela.get(i).x, nebeskaTela.get(i).y);
			nebeskaTela.get(i).paint(g1);
		}}
	}

	public void dodajTelo(NebeskoTelo t) {
		nebeskaTela.add(t);
	}
	@Override
	public void run() {
		try {
			while(!thread.isInterrupted()) {
				synchronized(this) {
					while(!work) {
						wait();
					}
				}
				
				for(int j = 0; j < nebeskaTela.size(); j++) {
					nebeskaTela.get(j).pomeriY(5);
				}
				repaint();
				Thread.sleep(100);
				}
			
			}catch(InterruptedException e) {}
		
	}
	public synchronized void go() {
		work = true;
		notify();
	}
	
}
