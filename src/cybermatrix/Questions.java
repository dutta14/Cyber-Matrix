package cybermatrix;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

class Questions extends JFrame implements Runnable {

	private static final String quitStr = "Quit",
			poweredBy = "Powered by IE CSE Studios",
			incorrectStr = "Incorrect!",
			checkStr = "Check",
			timeStr = "Time:",
			title = "IE E&C presents Cyber Matrix";

	
	static int i = 0;
	JPanel np, p;
	JLabel tr, ms, jl[];
	Thread t;
	ReadWrite o;
	String readfrom;

	public Questions() {
		o = new ReadWrite("", "x.txt");
		readfrom = o.readfrom();
		i =  readfrom.equals("error")? 0: Integer.parseInt(readfrom.substring(0, readfrom.indexOf(" ")));
		
		setTitle(title);
		initComponents();
		qstn.setText(Repository.qs[i]);
		img.setVisible(false);
		t = new Thread(this);
		t.start();
		incorrect.setVisible(false);
	}

		private void initComponents() {

		timel = new JLabel();
		time = new JLabel();
		jScrollPane1 = new JScrollPane();
		qstn = new JTextPane();
		img = new JLabel();
		ans = new JTextField();
		check = new JButton();
		incorrect = new JLabel();
		jLabel3 = new JLabel();
		quit = new JButton();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);

		timel.setText(timeStr);

		qstn.setEditable(false);
		qstn.setOpaque(false);
		jScrollPane1.setViewportView(qstn);

		check.setText(checkStr);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				checkActionPerformed(evt);
			}
		});

		incorrect.setForeground(new Color(255, 0, 0));
		incorrect.setText(incorrectStr);

		jLabel3.setText(poweredBy);

		quit.setText(quitStr);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quitActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
																.addGap(0,0,Short.MAX_VALUE)
																.addComponent(timel)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(time)
																.addGap(63, 63, 63))
												.addGroup(layout.createSequentialGroup().addComponent(jScrollPane1)
																.addContainerGap())))
				.addGroup(layout.createSequentialGroup()
								.addGap(49, 49, 49)
								.addComponent(ans, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(check)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(incorrect, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(quit)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabel3))
												.addGroup(layout.createSequentialGroup()
																.addGap(32, 32, 32)
																.addComponent(img, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(timel)
												.addComponent(time))
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(img, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(ans, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(check)
												.addComponent(incorrect))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(quit))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void checkActionPerformed(ActionEvent evt) {
		incorrect.setVisible(false);
		
		int flag = 0, flag2 = 0;

		if (i == 27)
			flag = 1;
		if (flag == 1) {
			for (int k = 0; k < Repository.ansr.length; k++) {
				if (ans.getText().equalsIgnoreCase(Repository.ans28[k])) {
					flag2 = 1;
					break;
				}
			}
		
			incorrect.setVisible(flag2 == 0);
		}

		if (flag != 1 && !ans.getText().equalsIgnoreCase(Repository.ansr[i])) {
			flag2 = 0;
			incorrect.setVisible(true);
		} else
			flag2 = 1;

		if (flag2 == 1) {
			ReadWrite o;
			System.out.println(time.getText());
			o = new ReadWrite((i + 1) + " " + time.getText(), "x.txt");
			o.writeinto();
			i++;
			if (i == 102) {
				showresult();
				this.setVisible(false);
			} else {
				qstn.setText(Repository.qs[i]);
				ans.setText("");
				if (i == 35 || i == 51 || i == 60 || i == 63 || i == 67 || i == 69 || i == 70) {
					img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cybermatrix/drawables" + (i + 1) + ".jpg")));
					img.setVisible(true);
				} else
					img.setVisible(false);
			}
		}
	}

	private void quitActionPerformed(java.awt.event.ActionEvent evt) {
		showresult();
		ReadWrite o = new ReadWrite(i + " " + time.getText(), "x.txt");
		o.writeinto();
	}

	public void run() {
		int k, j;
		if (readfrom.equals("error")) {
			k = 59;
			j = 59;
		} else {
			k = Integer.parseInt(readfrom.substring(readfrom.indexOf(" ") + 1, readfrom.indexOf(" ") + 3));
			j = Integer.parseInt(readfrom.substring(readfrom.indexOf(":") + 1, readfrom.indexOf(":") + 3));
		}
		
		String min="",sec="";
		try {
			Thread.sleep(1000);
			for (; k >= 0; k--) {
				min = (k<10? "0":"") + k;
				for (; j >= 0; j--) {
					sec= (j<10? "0":"") + j;
					time.setText(min+":"+sec);
					Thread.sleep(1000);
					if (k == 0 && j == 0) {
						showresult();
						setVisible(false);
					}
				}
				j = 59;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void showresult() {
		JFrame fin = new JFrame();
		fin.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fin.setSize(200, 100);
		 
		fin.add(new JLabel("You attempted " + i + " questions"));
		fin.setVisible(true);
		setVisible(false);
	}
	
	private JTextField ans;
	private JButton check, quit;
	private JLabel img, incorrect, jLabel3, time, timel;
	private JScrollPane jScrollPane1;
	private JTextPane qstn;
}
