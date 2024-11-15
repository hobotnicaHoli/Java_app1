package gui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat {
	
	protected int polupr; 
	//u pikselima
	
	public NebeskoTelo(int x, int y, Color color, int r) {
		super(x, y, color);
		polupr = r;
	}

	@Override
	public abstract void paint(Graphics g);

}
