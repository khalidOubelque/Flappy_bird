package Flappy_bird;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel {
	
	protected final int WIDTH = 800, HEIGHT = 800;
	protected Rectangle bird; // bird
	protected Rectangle rec1; 
	protected Rectangle rec2; 
	private final int x_bar = WIDTH+100 , bar_width = 100 , space =150; 
	BufferedImage img ;
	Random r = new Random();
	int Low = 300;
	int High = 700;
	
	public MyPanel() {
		int random = r.nextInt(High-Low) + Low;
		bird = new Rectangle(WIDTH/2,HEIGHT/2,30,30);
		rec1 = new Rectangle(x_bar,0,bar_width,HEIGHT - random);
		rec2 = new Rectangle(x_bar,(rec1.height+space),bar_width,HEIGHT);

	}

	public void paint(Graphics g) {
		
		try {
			 img = ImageIO.read(new File("img/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel background = new JLabel(new ImageIcon(img));
	    g.drawImage(img, 0, 0, this);


		
		g.setColor(Color.red);
		g.fillRect(bird.x,bird.y,bird.width,bird.height);
		
		
		g.setColor(Color.GREEN);
		g.fillRect(rec1.x,rec1.y,rec1.width,rec1.height);
		
		g.setColor(Color.GREEN);
		g.fillRect(rec2.x,rec2.y,rec2.width,rec2.height);
	  }
	
	public void createRects(){
		int random = r.nextInt(High-Low) + Low;
		rec1.height = HEIGHT - random;
		rec2.y = rec1.height+space;
		rec1.x = x_bar;
		rec2.x = x_bar;
		/* good thinking each time you don t need to instantiat class =D
		rec1 = new Rectangle(x_bar,0,bar_width,HEIGHT - random);
		rec2 = new Rectangle(x_bar,(rec1.height+space),bar_width,HEIGHT);
		*/
		System.out.println(rec1.height);
	}
	
}
