import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
public class Player {
	private ImageIcon bg = new ImageIcon("pixelated_angry_birds_1.png");
	private Image background = bg.getImage();
	private int velocityY = 0;
	private int userY = 340;
	private boolean hitGround = false;
	private int x = 200;
	private int w = 50;
	private int h = 50;
	public Player(int x, int y,Color c){
	}
	
	public void drawPlayer(Graphics g, FlappyBirdMain fbm){
		//player Image
		g.drawImage(background, x, userY, w, h,fbm);
		g.setColor(Color.GREEN);
		//g.fillOval(200, 340, 50, 50);
		
	}
	public void fly(){
		velocityY = 10;
	}
	
	public void resetPlayer(){
		x = 200;
		userY = 340;
	}
	public void move(){
		velocityY--;
		userY -= velocityY;
		//check if on ground - set a boolean to true when we hit it
		if (userY >= 545){
			hitGround = true;
			userY = 550;
		}
		
		
	}
	//method that returns if we hit ground or not
	public boolean groundCheck(){
		return hitGround;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return userY;
	}
	
	public int getW(){
		return w;
	}
	
	public int getH(){
		return h;
	}
	
}
