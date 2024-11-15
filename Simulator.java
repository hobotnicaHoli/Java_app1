package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	private Svemir svemir;
	Panel pokretanje = new Panel();
	private Generator gen;
	Button pokreni = new Button("Pokreni!");
	
	public Simulator() {
		setBounds(700, 200, 200, 400);
		pokretanje.add(pokreni);
		svemir = new Svemir();
		add(svemir, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				svemir.thread.interrupt();
				gen.interrupt();
				
			}
		});
		add(pokretanje, BorderLayout.SOUTH);
		pokreni.addActionListener((ae)->{
			gen = new Generator(svemir);
			pokreni.setEnabled(false);
			
		});
		
		setResizable(false);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Simulator();
	}
}
