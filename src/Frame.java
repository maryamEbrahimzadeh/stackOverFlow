//package finaldbproject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;


public class Frame extends JFrame  {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	Client c;
	Panel panel;
	public Frame(Client c) {
		// TODO Auto-generated constructor stub
		this.c = c;
		for (LookAndFeelInfo a : UIManager.getInstalledLookAndFeels())// lookAndfellinfo
			{
			if ("Nimbus".equals(a.getName()))
			try {
			UIManager.setLookAndFeel(a.getClassName());
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			}

        
		//Client c = new Client("127.0.0.1",8000,"user");
		setLayout(new BorderLayout());
		setSize(d.width/2,d.height/2);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Inverted Index");
//		GridLayout layoutthispanel = new GridLayout(1,1);
//		getContentPane().setLayout(layoutthispanel);
		panel = new Panel(this,c); 
		//panel = new answerPanel(this, c) ;
		getContentPane().add(panel,BorderLayout.CENTER);
		//panel.setFocusable(true);
		//panel.addKeyListener(panel);
		setVisible(true);
	} 
	

}
