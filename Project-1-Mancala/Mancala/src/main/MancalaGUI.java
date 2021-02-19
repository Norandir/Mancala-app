package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Basic Mancala board GUI.
 * @author Natalie Williams
 * @version 1.2
 */
public class MancalaGUI {

	private JFrame frmMancala;
	private JTextField txtLeftMancala;
	private JTextField txtRightMancala;
	private JTextField txtPocketA1;
	private RoundedTextField txtPocketA2;
	private RoundedTextField txtPocketA3;
	private RoundedTextField txtPocketA4;
	private RoundedTextField txtPocketA5;
	private RoundedTextField txtPocketA6;
	private RoundedTextField txtPocketB1;
	private RoundedTextField txtPocketB2;
	private RoundedTextField txtPocketB3;
	private RoundedTextField txtPocketB4;
	private RoundedTextField txtPocketB5;
	private RoundedTextField txtPocketB6;
	private JButton btnExit;
	private JButton btnStart;
	private JButton btnA1;
	private JButton btnA2;
	private JButton btnA3;
	private JButton btnA4;
	private JButton btnA5;
	private JButton btnA6;
	private JButton btnB1;
	private JButton btnB2;
	private JButton btnB3;
	private JButton btnB4;
	private JButton btnB5;
	private JButton btnB6;
	private JTextArea txtrGameLog;
	
	private int[] pocketCount = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0};
	/* First 6 elements are the bottom pockets from left to right,
	 * next 6 elements are the top pockets from left to right,
	 * and the last two elements are the left and right Mancala in that order.
	 */
	
	private int pocketIndex;	// Index of selected pocket.
	private int playerTurn = 0; // Keeps track of the players turn. 1 = Player 1, 2 = Player 2
	private boolean bonusTurn = false;	// Stores whether or not the player gets an extra turn that round.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MancalaGUI window = new MancalaGUI();
					window.frmMancala.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MancalaGUI() {
		initialize();
		eventHandler();
	}
	/**
	 * Method for handling turns,
	 * pocketIndex should be passed to i.
	 * @param i
	 */
	private void turnHandler(int i) {
		if (pocketCount[i] <= 0) {
			txtrGameLog.append("\n\nError: Pocket empty.\n");
		}
		else {
			//TODO: Add method call for GameRules class.
			
			switch (playerTurn) {
			case 1:
				txtrGameLog.append("\nPlayer 1 moved their pieces.");
				if (bonusTurn) {
					txtrGameLog.append("\nPlayer 1 landed in their own Mancala! Go again.");
					bonusTurn = false;
				}
				else {
					txtrGameLog.append("\n\nPlayer 2's turn.");
					
					btnA1.setEnabled(false);
					btnA2.setEnabled(false);
					btnA3.setEnabled(false);
					btnA4.setEnabled(false);
					btnA5.setEnabled(false);
					btnA6.setEnabled(false);
					
					btnB1.setEnabled(true);
					btnB2.setEnabled(true);
					btnB3.setEnabled(true);
					btnB4.setEnabled(true);
					btnB5.setEnabled(true);
					btnB6.setEnabled(true);
				}
				break;
				
			case 2:
				txtrGameLog.append("\nPlayer 2 moved their pieces.");
				if (bonusTurn) {
					txtrGameLog.append("\nPlayer 2 landed in their own Mancala! Go again.");
					bonusTurn = false;
				}
				else {
					txtrGameLog.append("\n\nPlayer 1's turn.");
					
					btnB1.setEnabled(false);
					btnB2.setEnabled(false);
					btnB3.setEnabled(false);
					btnB4.setEnabled(false);
					btnB5.setEnabled(false);
					btnB6.setEnabled(false);
					
					btnA1.setEnabled(true);
					btnA2.setEnabled(true);
					btnA3.setEnabled(true);
					btnA4.setEnabled(true);
					btnA5.setEnabled(true);
					btnA6.setEnabled(true);
				}
				break;
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	// EVENT HANDLER
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Handles events.
	 */
	private void eventHandler() {
		btnA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 1;
				pocketIndex = 0;
				turnHandler(pocketIndex);
			}
		});
		
		btnA2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 1;
				pocketIndex = 1;
				turnHandler(pocketIndex);
			}
		});
		
		btnA3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 1;
				pocketIndex = 2;
				turnHandler(pocketIndex);
			}
		});
		
		btnA4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 1;
				pocketIndex = 3;
				turnHandler(pocketIndex);
			}
		});
		
		btnA5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 1;
				pocketIndex = 4;
				turnHandler(pocketIndex);
			}
		});
		
		btnA6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 1;
				pocketIndex = 5;
				turnHandler(pocketIndex);
			}
		});
		
		btnB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 2;
				pocketIndex = 6;
				turnHandler(pocketIndex);
			}
		});
		
		btnB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 2;
				pocketIndex = 7;
				turnHandler(pocketIndex);
			}
		});
		
		btnB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 2;
				pocketIndex = 8;
				turnHandler(pocketIndex);
			}
		});
		
		btnB4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 2;
				pocketIndex = 9;
				turnHandler(pocketIndex);
			}
		});
		
		btnB5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 2;
				pocketIndex = 10;
				turnHandler(pocketIndex);
			}
		});
		
		btnB6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerTurn = 2;
				pocketIndex = 11;
				turnHandler(pocketIndex);
			}
		});
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrGameLog.append("\n\nPlayer 1's turn.");
				btnStart.setEnabled(false);
				btnA1.setEnabled(true);
				btnA2.setEnabled(true);
				btnA3.setEnabled(true);
				btnA4.setEnabled(true);
				btnA5.setEnabled(true);
				btnA6.setEnabled(true);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	// INITIALIZER
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMancala = new JFrame();
		frmMancala.setTitle("Mancala");
		frmMancala.setBounds(100, 100, 1049, 632);
		frmMancala.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(frmMancala.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(414)
							.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(60)
							.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(405)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnStart))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		txtLeftMancala = new RoundedTextField(15);
		txtLeftMancala.setColumns(10);
		txtLeftMancala.setEditable(false);
		txtLeftMancala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLeftMancala.setText("        " + pocketCount[12]);
		txtLeftMancala.setBackground(SystemColor.textHighlightText);
		
		txtRightMancala = new RoundedTextField(15);
		txtRightMancala.setColumns(10);
		txtRightMancala.setEditable(false);
		txtRightMancala.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRightMancala.setText("        " + pocketCount[13]);
		txtRightMancala.setBackground(SystemColor.textHighlightText);
		
		txtPocketA1 = new RoundedTextField(15);
		txtPocketA1.setColumns(10);
		txtPocketA1.setEditable(false);
		txtPocketA1.setBackground(SystemColor.textHighlightText);
		txtPocketA1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketA1.setText("      " + pocketCount[0]);
		
		txtPocketA2 = new RoundedTextField(15);
		txtPocketA2.setColumns(10);
		txtPocketA2.setEditable(false);
		txtPocketA2.setBackground(SystemColor.textHighlightText);
		txtPocketA2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketA2.setText("      " + pocketCount[1]);
		
		txtPocketA3 = new RoundedTextField(15);
		txtPocketA3.setColumns(10);
		txtPocketA3.setEditable(false);
		txtPocketA3.setBackground(SystemColor.textHighlightText);
		txtPocketA3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketA3.setText("      " + pocketCount[2]);
		
		txtPocketA4 = new RoundedTextField(15);
		txtPocketA4.setColumns(10);
		txtPocketA4.setEditable(false);
		txtPocketA4.setBackground(SystemColor.textHighlightText);
		txtPocketA4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketA4.setText("      " + pocketCount[3]);
		
		txtPocketA5 = new RoundedTextField(15);
		txtPocketA5.setColumns(10);
		txtPocketA5.setEditable(false);
		txtPocketA5.setBackground(SystemColor.textHighlightText);
		txtPocketA5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketA5.setText("      " + pocketCount[4]);
		
		txtPocketA6 = new RoundedTextField(15);
		txtPocketA6.setColumns(10);
		txtPocketA6.setEditable(false);
		txtPocketA6.setBackground(SystemColor.textHighlightText);
		txtPocketA6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketA6.setText("      " + pocketCount[5]);
		
		txtPocketB1 = new RoundedTextField(15);
		txtPocketB1.setColumns(10);
		txtPocketB1.setEditable(false);
		txtPocketB1.setBackground(SystemColor.textHighlightText);
		txtPocketB1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketB1.setText("      " + pocketCount[6]);
		
		txtPocketB2 = new RoundedTextField(15);
		txtPocketB2.setColumns(10);
		txtPocketB2.setEditable(false);
		txtPocketB2.setBackground(SystemColor.textHighlightText);
		txtPocketB2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketB2.setText("      " + pocketCount[7]);
		
		txtPocketB3 = new RoundedTextField(15);
		txtPocketB3.setColumns(10);
		txtPocketB3.setEditable(false);
		txtPocketB3.setBackground(SystemColor.textHighlightText);
		txtPocketB3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketB3.setText("      " + pocketCount[8]);
		
		txtPocketB4 = new RoundedTextField(15);
		txtPocketB4.setColumns(10);
		txtPocketB4.setEditable(false);
		txtPocketB4.setBackground(SystemColor.textHighlightText);
		txtPocketB4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketB4.setText("      " + pocketCount[9]);
		
		txtPocketB5 = new RoundedTextField(15);
		txtPocketB5.setColumns(10);
		txtPocketB5.setEditable(false);
		txtPocketB5.setBackground(SystemColor.textHighlightText);
		txtPocketB5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketB5.setText("      " + pocketCount[10]);
		
		txtPocketB6 = new RoundedTextField(15);
		txtPocketB6.setColumns(10);
		txtPocketB6.setEditable(false);
		txtPocketB6.setBackground(SystemColor.textHighlightText);
		txtPocketB6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPocketB6.setText("      " + pocketCount[11]);
		
		btnA1 = new JButton("A-1");
		btnA1.setEnabled(false);
		btnA1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnA2 = new JButton("A-2");
		btnA2.setEnabled(false);
		btnA2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnA3 = new JButton("A-3");
		btnA3.setEnabled(false);
		btnA3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnA4 = new JButton("A-4");
		btnA4.setEnabled(false);
		btnA4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnA5 = new JButton("A-5");
		btnA5.setEnabled(false);
		btnA5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnA6 = new JButton("A-6");
		btnA6.setEnabled(false);
		btnA6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnB1 = new JButton("B-1");
		btnB1.setEnabled(false);
		btnB1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnB2 = new JButton("B-2");
		btnB2.setEnabled(false);
		btnB2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnB3 = new JButton("B-3");
		btnB3.setEnabled(false);
		btnB3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnB4 = new JButton("B-4");
		btnB4.setEnabled(false);
		btnB4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnB5 = new JButton("B-5");
		btnB5.setEnabled(false);
		btnB5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnB6 = new JButton("B-6");
		btnB6.setEnabled(false);
		btnB6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(txtLeftMancala, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnA1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtPocketA1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
							.addComponent(txtPocketB1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
						.addComponent(btnB1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPocketA2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPocketB2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnA2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnB2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPocketA3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPocketB3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnA3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnB3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPocketA4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPocketB4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnA4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnB4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnB5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPocketB5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnA5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtPocketA5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnB6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnA6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPocketA6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPocketB6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(txtRightMancala, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLeftMancala, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRightMancala, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPocketB1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketB2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketB3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketB4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketB6, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketB5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnB1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnB2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnB3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnB4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnB6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnB5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPocketA1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketA2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketA3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketA4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketA6, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocketA5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnA1)
									.addComponent(btnA2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnA3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnA4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnA6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnA5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addGap(23))))
		);
		panel.setLayout(gl_panel);
		
		txtrGameLog = new JTextArea();
		txtrGameLog.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrGameLog.setText("Press Start to begin.");
		scrollPane.setViewportView(txtrGameLog);
		frmMancala.getContentPane().setLayout(groupLayout);
	}
}