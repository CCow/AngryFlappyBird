import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dash {
	private int locX;
	private int locY;
	private int diameter;
	private Color color;
	private int x = 20;
	private double moveX = 0;
	public int uselessvariable;
	public Dash(int x, int y,Color c){
		locX = x;
		locY = y;
		color = c;
	}
	
	public void dashMove(){
		moveX+=2.5;
		if (locX <= 0){
			locX = 1280;
		}
	}
	
	public void drawDash(Graphics g){
		for (int locX = 20 - (int)moveX; locX < 10000; locX+=30){
			g.setColor(Color.GREEN);
			g.drawLine(locX, 600, locX-20, 625);
			g.drawLine(locX-1, 600, locX-20, 625);
			g.drawLine(locX-2, 600, locX-21, 625);
			g.drawLine(locX-3, 600, locX-22, 625);
			g.drawLine(locX-4, 600, locX-23, 625);
			g.drawLine(locX-5, 600, locX-24, 625);
			g.drawLine(locX-6, 600, locX-25, 625);
			g.drawLine(locX-7, 600, locX-26, 625);
			g.drawLine(locX-8, 600, locX-27, 625);
			g.drawLine(locX-9, 600, locX-28, 625);
			g.drawLine(locX-10, 600, locX-29, 625);
			g.drawLine(locX-11, 600, locX-30, 625);
			g.drawLine(locX-12, 600, locX-31, 625);
			g.drawLine(locX-13, 600, locX-32, 625);
			g.drawLine(locX-14, 600, locX-33, 625);
		}
	}
	
	public void resetDash(){
		locX = 20;
	}
}