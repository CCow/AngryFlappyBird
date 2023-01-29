import java.awt.*;
import javax.swing.*;
public class Cloud extends JPanel{
	int[] height = new int[10000];
	public Cloud(int x, int y, int h, Color c){
		for(int i =0 ; i < height.length;i++){
			height[i] = (int) ((450 - 420 + 1)*Math.random() + 420);
		}
	}
	public void drawCloud(Graphics g){
		
		for (int x = 0; x < 10000; x += 100){
			int height = this.height[x];
			g.setColor(new Color(255, 255, 255));
			g.fillOval(x-100, height+25, 175, 250);	
		}
	}
	public void height(int h){

	}
}
