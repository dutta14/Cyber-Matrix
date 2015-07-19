package cybermatrix;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Welcome extends JFrame {

	private static final String cyberMatrix = "CYBER MATRIX",
			title = "IE E&C presents Cyber Matrix",
			welcome = "IE E&C PRESENTS",
			begin = "BEGIN",
			atb = "ALL THE BEST!",
			instructions = "Instructions:",
			rules = "1. You are given 1 hour of time to \nattempt as many questions as\npossible.\n\n2. You cannot attempt the next\nquestion unless you clear the present\none, i.e, there is no option for\nskipping the question.\n\n3. The moment you press the \"BEGIN\"\nbutton the timer is started.",
			poweredBy = "Powered by IE CSE Studios";

	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
	private JTextArea jTextArea1;
	private JButton start;

	Font titleFont = new Font("Arial", 1, 18);
	ImageIcon logo = new ImageIcon(getClass().getResource("/cybermatrix/drawables/IEI-Logo.gif"));

	public Welcome() {
		initComponents();
		setTitle(title);
		setResizable(false);
	}

	private void initComponents() {

		jLabel1 = new JLabel(welcome);
		start = new JButton(begin);
		jLabel2 = new JLabel(cyberMatrix);
		jLabel3 = new JLabel(atb);
		jLabel4 = new JLabel(logo);
		jLabel5 = new JLabel(instructions);
		jTextArea1 = new JTextArea();
		jLabel6 = new JLabel();

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Questions().setVisible(true);
					}
				});
			}
		});

		jLabel2.setFont(titleFont);

		jTextArea1.setEditable(false);
		jTextArea1.setText(rules);
		jTextArea1.setOpaque(false);

		jLabel6.setText(poweredBy);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(Alignment.LEADING)
											  .addGroup(layout.createSequentialGroup()
																.addGap(24, 24, 24)
																.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
											   .addGroup(layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(jLabel2))
												.addGroup(layout.createSequentialGroup()
																.addGap(32, 32, 32)
																.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(38, 38, 38)
																.addComponent(jLabel3)))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
																.addComponent(start)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabel6)
																.addContainerGap())
												.addComponent(jTextArea1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))));
		
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										           .addGroup(layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(jLabel1)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(jLabel2)
																.addGap(60, 60, 60)
																.addComponent(jLabel3))
												.addGroup(layout.createSequentialGroup()
																.addGap(27, 27, 27)
																.addComponent(jLabel5)
																.addGap(18, 18,18)
																.addComponent(jTextArea1, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
																.addComponent(start)
																.addContainerGap())
												.addComponent(jLabel6, Alignment.TRAILING))));

		pack();
	}
	
	public static void main(String[] args) {
	    java.awt.EventQueue.invokeLater(new Runnable() {
		    public void run() {
		        new Welcome().setVisible(true);
		    }
		});
		    }
}
