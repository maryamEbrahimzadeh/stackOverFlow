

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






public class Panel extends JPanel implements MouseListener,KeyListener{

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	JLabel j1,j0;
	JTextField t1;
	JButton browse;
	JTextArea display;
	JLabel j2;
	JRadioButton bst,tst,trie,hash,hashtable;
	JTextField t2,bsttext,tsttext,trietext,hashtext,hashtabletxt;
	JButton build,reset,help,exit;
	JFileChooser filechooser;
	FileInputStream input;
	File file;
	
	
	
	
	
	
	public Panel(){
		
		//------------------------------GUI-----------------------------------------
		
		GridLayout layoutthispanel = new GridLayout(2, 1);
		this.setLayout(layoutthispanel);
		
		JPanel p0 = new JPanel();
		GridLayout layoutthisuppanel = new GridLayout(6, 1);
		p0.setLayout(layoutthisuppanel);
		
		
		j0=new JLabel ("Invreted Index", SwingConstants.CENTER);	
		j0.setFont(new Font("SansSerif", Font.ITALIC,60));
		p0.add(j0);
		
		j1=new JLabel ("please enter a folder addres to use browse button", SwingConstants.CENTER);	
		j1.setFont(new Font("SansSerif", Font.ITALIC, 20));
		j1.setBackground(Color.getHSBColor(154, 254, 25));
		p0.add(j1);
		
		
		
		JPanel p1=new JPanel();
		FlowLayout layout1 = new FlowLayout();
		p1.setLayout(layout1);		
		t1=new JTextField();
		t1.setColumns(60);
		p1.add(t1);
		browse = new JButton("Browse");
		browse.addMouseListener(this);
		p1.add(browse);
		p1.setVisible(true);
		p0.add(p1);
		
		
	
	
		
		JPanel p2=new JPanel();
		GridLayout layout2 = new GridLayout(1,8);
		p2.setLayout(layout2);
		hash = new JRadioButton("Hash");
		p2.add(hash);
		hashtext = new JTextField();
		hashtext.setFont(new Font("SansSerif", Font.ITALIC,25));
		p2.add(hashtext);
		bst=new JRadioButton("BST");
		p2.add(bst);
		bsttext = new JTextField();
		bsttext.setFont(new Font("SansSerif", Font.ITALIC,25));
		p2.add(bsttext);
		bst.setSelected(true);
		tst=new JRadioButton("TST");
		p2.add(tst);
		tsttext = new JTextField();
		tsttext.setFont(new Font("SansSerif", Font.ITALIC,25));
		p2.add(tsttext);
		trie=new JRadioButton("TRIE");
		p2.add(trie);
		trietext = new JTextField();
		trietext.setFont(new Font("SansSerif", Font.ITALIC,25));
		p2.add(trietext);
		hashtable=new JRadioButton("HASHTABE");
		p2.add(hashtable);
		hashtabletxt = new JTextField();
		hashtabletxt.setFont(new Font("SansSerif", Font.ITALIC,25));
		p2.add(hashtabletxt);
		ButtonGroup bg=new ButtonGroup();
		bg.add(bst);
		bg.add(tst);
		bg.add(trie);
		bg.add(hash);
		bg.add(hashtable);
		p1.setVisible(true);
		p0.add(p2);
		
		
		t2=new JTextField();
		t2.setText("please enter your command");
		t2.setFont(new Font("SansSerif", Font.ITALIC,40));
		p0.add(t2);
		
		JPanel p3=new JPanel();
		FlowLayout layout3 = new FlowLayout();
		p3.setLayout(layout3);
		build =new JButton("build");
		Dimension d1 = new Dimension(d.width/15, d.height/30);
		build.setPreferredSize(d1);
		build.addMouseListener(this);
		p3.add(build);
		reset=new JButton("reset");
		reset.setPreferredSize(d1);
		reset.addMouseListener(this);
		reset.addKeyListener(this);;
		p3.add(reset);
		exit=new JButton("exit");
		exit.setPreferredSize(d1);
		exit.addMouseListener(this);
		p3.add(exit);
		help=new JButton("help");
		help.setPreferredSize(d1);
		help.addMouseListener(this);
		p3.add(help);
		p3.setVisible(true);
		p0.add(p3);
		
		this.add(p0);
		
		display=new JTextArea();
		display.setFont(new Font("SansSerif", Font.ITALIC,30));
        JScrollPane scroll = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setMinimumSize(new Dimension(160, 200));
        scroll.setPreferredSize(new Dimension(160, 200));
        this.add(scroll);


		
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
	
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	



	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			
				
					
		}
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
