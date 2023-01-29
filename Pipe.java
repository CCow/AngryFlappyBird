import javax.swing.*;
import java.awt.*;
public class Pipe {
	private double moveX = 0;
	private int locX;
	private int locY;
	private Color color;
	private int i;
	private int y = (int) ((100 - 1 + 1)*Math.random() + 1);
	int[] height = new int[10000];
	private int score = 0;
	private int oldScore = -1;
	public Pipe(int x, int y,Color c){
		locX = x;
		locY = y;
		color = c;
		for(int i = 0 ; i < height.length; i++){
			height[i] = (int) ((500 - 300 + 1)*Math.random() + 300);
		}
	}
	public void pipeMove(){
		moveX+=2.5;
	}
	public void drawPipe(Graphics g){
		for (int x = 600 - (int)moveX; x < 10000; x += 250){
			g.setColor(new Color(0, 148, 39));
			int height = this.height[(x+(int)moveX)%10000];
			
			//bottom pipe
			g.fillRect(x, height, 50, height);
			
			//top pipe
			g.fillRect(x, 0, 50, height-150);
			
			if (x == 200){
				score++;
			}

			if (score <= 0){
				
			}
			else if (score > 0){
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString(score+"", 600, 300);
			}
			
			
		}
	}
	public boolean birdHitPipe(int xx, int y, int w, int h){
		Rectangle bird = new Rectangle(xx,y,w,h);
		Rectangle botPipe;
		Rectangle topPipe;
		for (int x = 600 - (int)moveX; x < 10000; x += 250){
			
			int height = this.height[(x+(int)moveX)%10000];
			
			//bottom pipe
			botPipe = new Rectangle(x, height, 50, height);
			
			//top pipe
			topPipe = new Rectangle(x, 0, 50, height-150);
			if (bird.intersects(botPipe) || bird.intersects(topPipe)){
				return true;
			}
		}
		return false;
	}
	
	public int oldScore(){
		return oldScore;
	}
	
	public int getScore(){
		return score;
	}
	public void winner(){
		while (getScore() < 100){
			//Don't do anything because I tried something earlier but it didn't work
		}
	}
}
