/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 *
 * @author fatemeh saligheh
 */
public class DelUpPanel extends JPanel implements MouseListener,KeyListener, ActionListener{
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	JTextField qusId;
	JButton delQus,upQus,delOp,upOp;
	JTextArea updateQus,updateOp;
	Client c ;
	Frame f;
        Document user;
        
        public DelUpPanel(Frame f,Client c,Document user){
                this.f = f;
		this.c = c;
		this.user = user;
                
                JPanel p0 = new JPanel();
		GridLayout layoutthisuppanel = new GridLayout(4, 1);
		p0.setLayout(layoutthisuppanel);

		Dimension d1 = new Dimension(d.width / 15, d.height / 30);
		GridLayout layout3 = new GridLayout(1, 1);
		this.setLayout(layout3);
                
                
                qusId = new JTextField("Enter question id for delete or update");
		qusId.setFont(new Font("SansSerif", Font.ITALIC, 20));
		p0.add(qusId);
                
                
                delQus = new JButton("delete");
		delQus.setPreferredSize(d1);
		delQus.addMouseListener(this);
		delQus.addActionListener(this);
		p0.add(delQus);
                
                
                

		

		updateQus = new JTextArea("ENTER Update");
		updateQus.setFont(new Font("SansSerif", Font.ITALIC, 30));
		JScrollPane scroll = new JScrollPane(updateQus, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setMinimumSize(new Dimension(10, 20));
		scroll.setPreferredSize(new Dimension(10, 20));

		p0.add(scroll);
                
                upQus = new JButton("update");
		upQus.setPreferredSize(d1);
		upQus.addMouseListener(this);
		upQus.addActionListener(this);
		p0.add(upQus);
                
                
                this.setBackground(Color.getHSBColor(154, 254, 25));
		p0.addKeyListener(this);
		p0.setVisible(true);

		this.add(p0);
		this.setVisible(true);
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == delQus) {
			String a = qusId.getText();
			Document qusDoc = new Document("qId",Integer.parseInt(a));
                      //  System.out.println(qusDoc.getInteger("qId"));
			c.sendMessage(new Message(Message.DELQUESTION,qusDoc,user));
                
		}else if(e.getSource() == upQus) {
			String a =  qusId.getText();
                        String b =  updateQus.getText();
                        Document q = new Document("qId",Integer.parseInt(a));
			c.sendMessage(new Message(Message.UPQUESTION,q,b));	
		
	}
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
