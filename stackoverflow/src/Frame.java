import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;


public class Frame extends JFrame  {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public Frame() {
		// TODO Auto-generated constructor stub
		
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

        
		setLayout(null);
		setSize(d.width/2,d.height/2);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Inverted Index");
		GridLayout layoutthispanel = new GridLayout(1,1);
		getContentPane().setLayout(layoutthispanel);
		Panel panel = new Panel();
		getContentPane().add(panel);
		//panel.setFocusable(true);
		//panel.addKeyListener(panel);
		setVisible(true);
	} 
	public static void main(String[] args) {
		new Frame();
	}

}
