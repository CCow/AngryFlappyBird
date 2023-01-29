import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FlappyBirdMain extends JPanel implements KeyListener, ActionListener{
	private Color c = new Color(135, 206, 250);
	private Dash dash = new Dash(300,250,Color.GREEN);
	private Cloud cloud = new Cloud(300,250, (int)((450 - 425 + 1)*Math.random() + 425), new Color(254, 254, 254));
	private Pipe pipe = new Pipe(1000, 600, new Color(0, 148, 39));
	private Player player = new Player(300,250,Color.PINK);
	private Timer timer;
	private Timer begin;
	private int gamecounter = 3;
	private JButton button;
	private JTextField field;
	private JLabel label;
	public FlappyBirdMain(){
		JFrame frame = new JFrame("Angry Flappy Bird");
		setPreferredSize(new Dimension (1280, 675));
		setBackground (c);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container can = frame.getContentPane();
		can.add(this);
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);	
		begin = new Timer(1000, this);
		timer = new Timer(1000/60, this);
		begin.start();
	}

	public void keyPressed(KeyEvent a) {
		int keyID = a.getKeyCode();
		
		if (keyID == KeyEvent.VK_SPACE){
			player.fly();
			repaint();
		}
	}
	
	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		
		
		
		if (source == begin){
			gamecounter--;
			if (gamecounter == 0){
				timer.start();
				
			}
			if (gamecounter == -1){
				begin.stop();
			}
		}
		else if (source == timer){
			//moving the dash
			dash.dashMove();
			repaint();
			
			//moving pipe
			pipe.pipeMove();
			player.move();
			if (pipe.birdHitPipe(player.getX(), player.getY(),player.getW(), player.getH())){
				timer.stop();
				
				
			}
			//check the method if we hit ground
			if (player.groundCheck()){
				timer.stop();
			}
		}
		
		if (player.getY() <= -50){
			timer.stop();
		}
			//stop the timer
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//cloud
		cloud.drawCloud(g);
		
		//player
		
		//pipe
		pipe.drawPipe(g);
				
		//grass
		g.setColor(new Color(65, 166, 5));
		g.fillRect(0, 600, getWidth(), getHeight());
		
		//ground
		g.setColor(new Color(240, 230, 140));
		g.fillRect(0, 625, getWidth(), getHeight());
		
		//dashed Line
		dash.drawDash(g);
		
		//Player Movement
		player.drawPlayer(g, this);
		if (gamecounter > 0){
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString(gamecounter+"", 600, 300);
		}
		if (gamecounter == 0){
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString("BEGIN", 550, 300);
		}
		if (player.groundCheck()){
			timer.stop();
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString("GAME OVER", 480, 200);
		}
		if (pipe.birdHitPipe(player.getX(), player.getY(),player.getW(), player.getH())){
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString("GAME OVER", 480, 200);
		}
	}
	public void dashMove(){
		repaint();
	}
	
	public static void main (String[]args){
		new FlappyBirdMain();
	}
}