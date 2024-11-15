package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public abstract class Objekat {

	int x;
	int y;
	Color color;
	
	public Objekat(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void pomeriX(int pomeraj) {
		x += pomeraj;
	}
	public void pomeriY(int pomeraj) {
		y += pomeraj;
	}
	public abstract void paint(Graphics g);
	
}
