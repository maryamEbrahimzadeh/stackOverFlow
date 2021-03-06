//package finaldbproject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
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
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.bson.Document;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author fatemeh saligheh
 */
public class answerPanel extends JPanel implements MouseListener, KeyListener, ActionListener {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	// JTextField t1;
	JButton registration;
	JTextField question,ans;
	JTextArea answer;
	Client c;
	Frame f;
	Document q;
        
	// JMenuBar menubar = new JMenuBar();
	// JMenuItem allQus;
	// JMenuItem favQus;
	// JTextField asktag;
	Document user;

	public answerPanel(Frame f, Client c, Document user, Document q) {
		this.f = f;
		this.c = c;
		this.user = user;
		this.q=q;
		// —----------------------------GUI---------------------------------------
		System.out.println("answerPanel.answerPanel()");

		JPanel p0 = new JPanel();
		GridLayout layoutthisuppanel = new GridLayout(4, 1);
		p0.setLayout(layoutthisuppanel);

		Dimension d1 = new Dimension(d.width / 15, d.height / 30);
		GridLayout layout3 = new GridLayout(1, 1);
		this.setLayout(layout3);

		registration = new JButton("submit");
		registration.setPreferredSize(d1);
		registration.addMouseListener(this);
		registration.addActionListener(this);
		p0.add(registration);

		question = new JTextField(q.getString("question"));
		question.setFont(new Font("SansSerif", Font.ITALIC, 20));
		p0.add(question);

		answer = new JTextArea();
		answer.setFont(new Font("SansSerif", Font.ITALIC, 30));
		JScrollPane scroll = new JScrollPane(answer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setMinimumSize(new Dimension(10, 20));
		scroll.setPreferredSize(new Dimension(10, 20));

		p0.add(scroll);
                
                
                
                
                
                
		this.setBackground(Color.getHSBColor(154, 254, 25));
		p0.addKeyListener(this);
		p0.setVisible(true);

		this.add(p0);
		this.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == registration) {
			String a = answer.getText();
			Document ad = new Document("answer",a)
					         .append("username", user.getString("username"))
					         .append("updates", new ArrayList<Document>());
			c.sendMessage(new Message(Message.ANSWER,q.getInteger("qId"),ad));
			
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
	}

}