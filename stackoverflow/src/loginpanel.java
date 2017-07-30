
//package finaldbproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.bson.Document;






public class loginpanel extends JPanel implements MouseListener,KeyListener{

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	JLabel j1,j0;
	JTextField t1;
	JButton browse;
	JTextArea display;
	JLabel j2;
	JLabel pass,email,username,name,favoritetxt;
	JTextField t2,passtext,emailtext,usernametext,nametext;
	JButton signin,reset,help,exit;
	JFileChooser filechooser;
	FileInputStream input;
	File file;
	Client c ;
	Frame f;
	
	
	
	
	
	public loginpanel(Frame f,Client c){
		this.f =f;
		this.c = c;
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(d.width/2,d.height/2);
		//------------------------------GUI-----------------------------------------
		
		GridLayout layoutthispanel = new GridLayout(2, 1);
		this.setLayout(layoutthispanel);
		
		JPanel p0 = new JPanel();
		GridLayout layoutthisuppanel = new GridLayout(6, 1);
		p0.setLayout(layoutthisuppanel);
		
		
		j0=new JLabel ("StackoverFlow", SwingConstants.CENTER);	
		j0.setFont(new Font("SansSerif", Font.ITALIC,60));
		p0.add(j0);
		
		
		
		

		JPanel p2=new JPanel();
		GridLayout layout2 = new GridLayout(1,8);
		p2.setLayout(layout2);
		
		
		
		username = new JLabel("Enter User name",SwingConstants.CENTER);
		p2.add(username);
		usernametext = new JTextField();
		usernametext.setFont(new Font("SansSerif", Font.ITALIC,25));
		p2.add(usernametext);
		
		
		
		pass = new JLabel("Enter User name",SwingConstants.CENTER);
		p2.add(pass);
		passtext = new JTextField();
		passtext.setFont(new Font("SansSerif", Font.ITALIC,25));
		p2.add(passtext);
		
		
		
		
		p2.setVisible(true);
		p0.add(p2);
		
		
		
		
				
		
		JPanel p3=new JPanel();
		FlowLayout layout3 = new FlowLayout();
		p3.setLayout(layout3);
		signin =new JButton("sign in");
		signin.setFont(new Font("SansSerif", Font.ITALIC, 30));
		Dimension d1 = new Dimension(d.width/15, d.height/30);
		signin.setPreferredSize(d1);
		signin.addMouseListener(this);
		p3.add(signin);
		p3.setVisible(true);
		p0.add(p3);
		
		this.add(p0);
		
//		display=new JTextArea();
//		display.setFont(new Font("SansSerif", Font.ITALIC,30));
//        JScrollPane scroll = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scroll.setMinimumSize(new Dimension(160, 200));
//        scroll.setPreferredSize(new Dimension(160, 200));
//        this.add(scroll);


		
		this.setBackground(Color.getHSBColor(154, 254, 25));
		p0.addKeyListener(this);
		
		//----------------------------end GUI------------------------------------

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==signin){
			Document doc = new  Document("username",usernametext.getText()).append("password",passtext.getText());
			c.sendMessage(new Message(Message.LOGIN, doc));
			System.out.println("loginpanel.mousePressed()");			
		}
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	



	@Override
	public void keyPressed(KeyEvent e) {
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
