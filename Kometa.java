package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {

	private boolean napravljen = false;
	public Kometa(int x, int y, int r) {
		super(x, y, Color.GRAY, r);
		
	}
	int[] tackeX = new int[5];
	int[] tackeY = new int[5];
	public void pravljenje() {
		double ugao = 2*Math.PI*Math.random();
		for(int i = 0; i < 5; i++) {
			int x = (int)(polupr*Math.cos(ugao));
			int y = (int)(polupr*Math.sin(ugao));
			
			tackeX[i] = x;
			tackeY[i] = y;
			ugao += 72*Math.PI/180;
		}
		napravljen = true;
	}

	@Override
	public void paint(Graphics g) {
		if(napravljen == false) {
			pravljenje();
		}
		g.setColor(color);
		g.fillPolygon(tackeX, tackeY, 5);
		
	}

}
