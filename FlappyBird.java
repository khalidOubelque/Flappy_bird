package Flappy_bird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class FlappyBird extends JFrame implements ActionListener,MouseListener{
	
	private static FlappyBird instance;
	private MyPanel panel ;
	private int speed,motion ,up ;
    private Timer timer ;
    JLabel game_overLbl = new JLabel("Game over");
    JLabel start_Lbl = new JLabel("Click to start");
    Boolean gameOver = false;
    Boolean start = false;

	private FlappyBird(){
		start = true;
		this.addMouseListener(this);
		panel = new MyPanel();

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(panel.WIDTH, panel.HEIGHT);
		this.setResizable(false);
		this.setTitle("Flappy bird");

        timer = new Timer(20, this);
        timer.start();
		//paint();
        
		game_overLbl.setForeground(Color.WHITE);
		game_overLbl.setBounds(panel.WIDTH/2 -200 ,panel.HEIGHT/2-100, 500, 200);
		game_overLbl.setFont(new Font("Serif",Font.PLAIN,100));
		game_overLbl.setVisible(false);
		
		start_Lbl.setForeground(Color.WHITE);
		start_Lbl.setBounds(panel.WIDTH/2 -200 ,panel.HEIGHT/2, 500, 200);
		start_Lbl.setFont(new Font("Serif",Font.PLAIN,50));
		start_Lbl.setVisible(true);

		this.add(game_overLbl);
		this.add(start_Lbl);
		this.add(panel);

		this.setVisible(true);

	}
	
	public static FlappyBird getInstance(){
		
		if(instance == null){
			return instance = new FlappyBird();
		}
		return instance;
	}

	@Override  
	public void actionPerformed(ActionEvent arg0) {
		
		gameOver = false;
		motion += 2;
		panel.bird.y += motion;
		speed = 10;
		birdTouchRect();
		panel.rec1.x -= speed;
		panel.rec2.x -= speed;
		if(panel.rec1.x + panel.rec1.width < 0 ){
			speed = 8;
			up=0;
			panel.createRects();
		}
		panel.repaint();
		
		/***************GAME OVER **************/
		if(panel.bird.y >= panel.HEIGHT || panel.bird.y <= 10 || birdTouchRect()){
			
			game_overLbl.setVisible(true);
			start_Lbl.setVisible(false);
		    gameOver = true;
			start_Lbl.setVisible(true);

		}
		if(gameOver){
		    timer.stop();
		}
		/****************************************/
		
	}
	//test if bird touches Rectangle
	public Boolean birdTouchRect(){
		if(panel.bird.intersects(panel.rec1) || panel.bird.intersects(panel.rec2)){
			System.out.println("true");
			return true;
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		start_Lbl.setVisible(false);
		game_overLbl.setVisible(false);
		System.out.println("test mouse");
		motion=0;
		motion -= 15;
		if(gameOver){
			timer.start();
			start_Lbl.setVisible(true);
			panel.bird.y = panel.HEIGHT/2;
			panel.createRects();
			this.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
