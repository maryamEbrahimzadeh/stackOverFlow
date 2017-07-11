
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
import javax.swing.text.html.HTML.Tag;

import org.bson.Document;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainPanel extends JPanel implements MouseListener, KeyListener, ActionListener {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	JTextField t1;
	JButton search, ask;
	JTextArea display;
	JTextField searchQuestion, asktext;
	Client c;
	Frame f;
	JMenuBar menubar = new JMenuBar();
	JMenuItem allQus;
	JMenuItem favQus;
	JMenu logout, deleteAccount, question;
	JTextField asktag;
	Document user;
	JButton answer;
	JTextField qusId;
	JMenuItem tagQus;
	Document q;
	private JMenuItem exit;
	private JMenuItem delete;
	private JMenuItem tag;
	TagPanel tp;
	private JButton answermark;

	public MainPanel(Frame f, Client c, Document user) {
		this.f = f;
		this.c = c;
		this.user = user;
		// ------------------------------GUI---------------------------------------—
		logout = new JMenu("logout");
		exit = new JMenuItem("logout");
		logout.add(exit);
		exit.addActionListener(this);
		deleteAccount = new JMenu("delete account");
		delete = new JMenuItem("delete account");
		deleteAccount.add(delete);
		delete.addActionListener(this);
		question = new JMenu("question");
		tag = new JMenuItem("based on tag");
		question.add(tag);
		tag.addActionListener(this);
		tagQus = new JMenuItem("tag Question");
		question.setMnemonic(KeyEvent.VK_Q);
		allQus = new JMenuItem("All Question");
		allQus.addActionListener(this);
		allQus.setMnemonic(KeyEvent.VK_A);
		favQus = new JMenuItem("Favorit Question");
		favQus.addActionListener(this);
		favQus.setMnemonic(KeyEvent.VK_F);
		// question.add(answer);
		question.add(allQus);
		question.add(favQus);
		menubar.add(question);
		menubar.add(logout);
		menubar.add(deleteAccount);
		GridLayout layoutthispanel = new GridLayout(3, 1);
		this.setLayout(layoutthispanel);

		JPanel p0 = new JPanel();
		GridLayout layoutthisuppanel = new GridLayout(0, 1);
		p0.setLayout(layoutthisuppanel);
		p0.add(menubar);

		Dimension d1 = new Dimension(d.width / 15, d.height / 30);
		JPanel p3 = new JPanel();
		BorderLayout layout3 = new BorderLayout();
		p3.setLayout(layout3);

		ask = new JButton("ask question");
		ask.setPreferredSize(d1);
		ask.addMouseListener(this);
		ask.addActionListener(this);

		search = new JButton("search");
		search.setPreferredSize(d1);
		search.addMouseListener(this);
		search.addActionListener(this);
		p3.add(search);

		p3.setVisible(true);

		asktext = new JTextField("enter your ask question");
		asktext.setFont(new Font("SansSerif", Font.ITALIC, 30));
		asktag = new JTextField("enter your  questions tag(s)");
		asktag.setFont(new Font("SansSerif", Font.ITALIC, 30));

		qusId = new JTextField("enter your  questions ID for answering or mark its answer");
		qusId.setFont(new Font("SansSerif", Font.ITALIC, 30));

		display = new JTextArea();
		display.setFont(new Font("SansSerif", Font.ITALIC, 30));
		JScrollPane scroll = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setMinimumSize(new Dimension(10, 20));
		scroll.setPreferredSize(new Dimension(10, 20));

		searchQuestion = new JTextField("enter your search question ");
		searchQuestion.setFont(new Font("SansSerif", Font.ITALIC, 30));
		p0.add(searchQuestion);

		p0.add(p3);
		p0.add(asktext);
		p0.add(asktag);
		p0.add(ask);
		p0.add(qusId);
		this.add(p0);
		this.add(scroll);
		
		answer = new JButton("answer");
		answer.setPreferredSize(d1);
		answer.addMouseListener(this);
		answer.addActionListener(this);
		answermark = new JButton("mark answer of my quistion");
		answermark.setPreferredSize(d1);
		answermark.addMouseListener(this);
		answermark.addActionListener(this);
		JPanel panswer = new JPanel();
		GridLayout layoutanswer = new GridLayout(2, 1);
		panswer.setLayout(layoutanswer);
		panswer.add(answer);
		panswer.add(answermark);
		this.add(panswer);
		this.setBackground(Color.getHSBColor(154, 254, 25));
		p0.addKeyListener(this);

		// ----------------------------end
		// GUI------------------------------------

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ask) {
			String[] tag = asktag.getText().split("\\s+");
			Vector<String> tagdoc = new Vector<String>();
			for (int i = 0; i < tag.length; i++) {
				tagdoc.addElement(tag[i]);
			}
			Document info = new Document("question", asktext.getText())
					.append("tags", tagdoc)
					.append("date", (new Date()).toString())
					.append("questioner", user.getString("username"))
					.append("qId", 0)
					.append("answers", new ArrayList<Document>());
			c.sendMessage(new Message(Message.ASK, info));
		} else if (e.getSource() == search) {
			Document q = new Document("question", searchQuestion.getText());
			c.sendMessage(new Message(Message.SEARCH, q));
		} else if (e.getSource() == allQus) {
			Document d = new Document();
			display.setText("");
			c.sendMessage(new Message(Message.SHOWALL, d));
		} else if (e.getSource() == favQus) {
			List<Document> dv = (List<Document>) user.get("intrest");
			display.setText("");
			for (Document d : dv) {
				display.append(d.getString("intrest") + "\n");
				c.sendMessage(new Message(Message.SHOWFAV, d));
			}

		} else if (e.getSource() == answer) {
			// this.setVisible(false);
			Document id = new Document("qId", Integer.parseInt(qusId.getText()));
			c.sendMessage(new Message(Message.QUESTIONTOANSWER, id, user));
			// f.getContentPane().add(new answerPanel(f, c,
			// user,),BorderLayout.CENTER);
		} else if (e.getSource() == exit) {
			c.sendMessage(new Message(Message.LOGOUT, user));
		} else if (e.getSource() == delete) {
			c.sendMessage(new Message(Message.DELETE, user));
		}
		else if (e.getSource() == tag) {
			tp = new TagPanel(f,c,user);
			c.sendMessage(new Message(Message.SHOWTAG));
			this.setVisible(false);
			f.getContentPane().add(tp);
		}else if(e.getSource() == answermark){
			this.setVisible(false);
			Document qid = new Document("qId", Integer.parseInt(qusId.getText()));
			c.sendMessage(new Message(Message.RATE1,qid,user));		
		}

	}

	// setter
	void setQuestion(Document q) {
		this.q = q;
	}

}