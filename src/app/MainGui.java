package app;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;

public class MainGui extends JFrame{
	
	JTextArea player1;
	JTextArea p1Money;
	private JButton p1Add;
	private JButton p1Sub;
	private JButton p1Trans;
	private JButton p1Set;
	JTextArea player2;
	JTextArea p2Money;
	private JButton p2Add;
	private JButton p2Sub;
	private JButton p2Trans;
	private JButton p2Set;
	JTextArea player3;
	JTextArea p3Money;
	private JButton p3Add;
	private JButton p3Sub;
	private JButton p3Trans;
	private JButton p3Set;
	JTextArea player4;
	JTextArea p4Money;
	private JButton p4Add;
	private JButton p4Sub;
	private JButton p4Trans;
	private JButton p4Set;
	private JTextPane P1Text;
	private JTextPane P2Text;
	private JTextPane P3Text;
	private JTextPane P4Text;
	private JTextPane MoneyText;
	private JTextPane MoneyText2;
	private JTextPane MoneyText3;
	private JTextPane MoneyText4;
	private JTextArea CharacterDescrip;
	private JTextArea CharacterDescrip2;
	private JTextArea CharacterDescrip3;
	private JTextArea CharacterDescrip4;
	private JTextPane times;
	private JTextPane txtSides;
	private JButton RollDice;
	private JTextArea NoteBox;
	private JScrollPane NoteBoxSP;
	private JTextPane NotePane;
	JTextPane RollNum;
	JTextPane RollSides;

	public MainGui() {
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setTitle("Board Game Tracker");
		setSize(630, 425);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setBackground(Color.RED);
		getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (InstantiationException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
			System.exit(1);
		}

		player1 = new JTextArea();
		player1.setToolTipText("<html>This field holds the name of the first player.</html>");
		player1.setBounds(10, 30, 300, 20);
		player1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		player1.setBackground(Color.LIGHT_GRAY);
		player1.setText("Player 1");
		player1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                player1.setText("");
            }
        });
		getContentPane().add(player1);
		
		p1Money = new JTextArea();
		p1Money.setToolTipText("<html>This field holds the value of the first player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
		p1Money.setForeground(Color.BLACK);
		p1Money.setBounds(320, 30, 80, 20);
		p1Money.setEditable(false);
		p1Money.setFont(new Font("Times New Roman", Font.BOLD, 14));
		p1Money.setBackground(Color.DARK_GRAY);
		p1Money.setText("Money");
		getContentPane().add(p1Money);
		
		p1Add = new JButton("Add");
		p1Add.setToolTipText("<html>This button will add the value input with the first player's money.</html>");
		p1Add.setBounds(20, 60, 90, 20);
		p1Add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p1Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addValue = inputBox("How much would you like to add to " + p1Money.getText() + "?");
				try{
					addButton(e, p1Money, Integer.parseInt(addValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p1Add);
		
		p1Sub = new JButton("Subtract");
		p1Sub.setToolTipText("<html>This button will subtract the value input from the first player's money.</html>");
		p1Sub.setBounds(120, 60, 90, 20);
		p1Sub.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p1Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subValue = inputBox("How much would you like to subtract from " + p1Money.getText() + "?");
				try{
					subButton(e, p1Money, Integer.parseInt(subValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p1Sub);
		
		p1Trans = new JButton("Transfer");
		p1Trans.setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the first player's money.</html>");
		p1Trans.setBounds(220, 60, 90, 20);
		p1Trans.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p1Trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transButton(e, p1Money);
			}
		});
		getContentPane().add(p1Trans);
		
		p1Set = new JButton("Set");
		p1Set.setToolTipText("<html>This button will set first player's money to the value input.</html>");
		p1Set.setBounds(320, 60, 90, 20);
		p1Set.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p1Set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
				setButton(e, p1Money, setValue);
			}
		});
		getContentPane().add(p1Set);
		
		player2 = new JTextArea();
		player2.setToolTipText("<html>This field holds the name of the second player.</html>");
		player2.setBounds(10, 110, 300, 20);
		player2.setBackground(Color.LIGHT_GRAY);
		player2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		player2.setText("Player 2");
		player2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                player2.setText("");
            }
        });
		getContentPane().add(player2);
		
		p2Money = new JTextArea();
		p2Money.setToolTipText("<html>This field holds the value of the second player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
		p2Money.setForeground(Color.BLACK);
		p2Money.setBounds(320, 110, 80, 20);
		p2Money.setEditable(false);
		p2Money.setFont(new Font("Times New Roman", Font.BOLD, 14));
		p2Money.setBackground(Color.DARK_GRAY);
		p2Money.setText("Money");
		getContentPane().add(p2Money);
		
		p2Add = new JButton("Add");
		p2Add.setToolTipText("<html>This button will add the value input with <br>the second player's money.</html>");
		p2Add.setBounds(20, 140, 90, 20);
		p2Add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p2Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addValue = inputBox("How much would you like to add to " + p2Money.getText() + "?");
				try{
					addButton(e, p2Money, Integer.parseInt(addValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p2Add);
		
		p2Sub = new JButton("Subtract");
		p2Sub.setToolTipText("<html>This button will subtract the value input <br>from the second player's money.</html>");
		p2Sub.setBounds(120, 140, 90, 20);
		p2Sub.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p2Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subValue = inputBox("How much would you like to subtract from " + p2Money.getText() + "?");
				try{
					subButton(e, p2Money, Integer.parseInt(subValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p2Sub);
		
		p2Trans = new JButton("Transfer");
		p2Trans.setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the second player's money.</html>");
		p2Trans.setBounds(220, 140, 90, 20);
		p2Trans.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p2Trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transButton(e, p2Money);
			}
		});
		getContentPane().add(p2Trans);
		
		p2Set = new JButton("Set");
		p2Set.setToolTipText("<html>This button will set second player's money to the value input.</html>");
		p2Set.setBounds(320, 140, 90, 20);
		p2Set.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p2Set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
				setButton(e, p2Money, setValue);
			}
		});
		getContentPane().add(p2Set);
		
		player3 = new JTextArea();
		player3.setToolTipText("<html>This field holds the name of the third player.</html>");
		player3.setBounds(10, 190, 300, 20);
		player3.setText("Player 3");
		player3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		player3.setBackground(Color.LIGHT_GRAY);
		player3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                player3.setText("");
            }
        });
		getContentPane().add(player3);
		
		p3Money = new JTextArea();
		p3Money.setToolTipText("<html>This field holds the value of the third player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
		p3Money.setForeground(Color.BLACK);
		p3Money.setBounds(320, 190, 80, 20);
		p3Money.setText("Money");
		p3Money.setFont(new Font("Times New Roman", Font.BOLD, 14));
		p3Money.setEditable(false);
		p3Money.setBackground(Color.DARK_GRAY);
		getContentPane().add(p3Money);
		
		p3Add = new JButton("Add");
		p3Add.setToolTipText("<html>This button will add the value input with<br>the third player's money.</html>");
		p3Add.setBounds(20, 220, 90, 20);
		p3Add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p3Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addValue = inputBox("How much would you like to add to " + p3Money.getText() + "?");
				try{
					addButton(e, p3Money, Integer.parseInt(addValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p3Add);
		
		p3Sub = new JButton("Subtract");
		p3Sub.setToolTipText("<html>This button will subtract the value input from <br>the third player's money.</html>");
		p3Sub.setBounds(120, 220, 90, 20);
		p3Sub.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p3Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subValue = inputBox("How much would you like to subtract from " + p3Money.getText() + "?");
				try{
					subButton(e, p3Money, Integer.parseInt(subValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p3Sub);
		
		p3Trans = new JButton("Transfer");
		p3Trans.setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the third player's money.</html>");
		p3Trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		p3Trans.setBounds(220, 220, 90, 20);
		p3Trans.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p3Trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transButton(e, p3Money);
			}
		});
		getContentPane().add(p3Trans);
		
		p3Set = new JButton("Set");
		p3Set.setToolTipText("<html>This button will set third player's money to the value input.</html>");
		p3Set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
				setButton(e, p3Money, setValue);
			}
		});
		p3Set.setBounds(320, 220, 90, 20);
		p3Set.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		getContentPane().add(p3Set);
		
		player4 = new JTextArea();
		player4.setToolTipText("<html>This field holds the name of the fourth player.</html>");
		player4.setText("Player 4");
		player4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		player4.setBackground(Color.LIGHT_GRAY);
		player4.setBounds(10, 270, 300, 20);
		player4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                player4.setText("");
            }
        });
		getContentPane().add(player4);
		
		p4Money = new JTextArea();
		p4Money.setToolTipText("<html>This field holds the value of the fourth player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
		p4Money.setForeground(Color.BLACK);
		p4Money.setText("Money");
		p4Money.setFont(new Font("Times New Roman", Font.BOLD, 14));
		p4Money.setEditable(false);
		p4Money.setBackground(Color.DARK_GRAY);
		p4Money.setBounds(320, 270, 80, 20);
		getContentPane().add(p4Money);
		
		p4Add = new JButton("Add");
		p4Add.setToolTipText("<html>This button will add the value input with<br>the fourth player's money.</html>");
		p4Add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p4Add.setBounds(20, 300, 90, 20);
		p4Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addValue = inputBox("How much would you like to add to " + p4Money.getText() + "?");
				try{
					addButton(e, p4Money, Integer.parseInt(addValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p4Add);
		
		p4Sub = new JButton("Subtract");
		p4Sub.setToolTipText("<html>This button will subtract the value input from <br>the first player's money.</html>");
		p4Sub.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p4Sub.setBounds(120, 300, 90, 20);
		p4Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subValue = inputBox("How much would you like to subtract from " + p4Money.getText() + "?");
				try{
					subButton(e, p4Money, Integer.parseInt(subValue));
				} catch (NumberFormatException ex){
					error("That is not a number!");
				}
			}
		});
		getContentPane().add(p4Sub);
		
		p4Trans = new JButton("Transfer");
		p4Trans.setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the fourth player's money.</html>");
		p4Trans.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p4Trans.setBounds(220, 300, 90, 20);
		p4Trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transButton(e, p4Money);
			}
		});
		getContentPane().add(p4Trans);
		
		p4Set = new JButton("Set");
		p4Set.setToolTipText("<html>This button will set fourth player's money to the value input.</html>");
		p4Set.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		p4Set.setBounds(320, 300, 90, 20);
		p4Set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
				setButton(e, p4Money, setValue);
			}
		});
		getContentPane().add(p4Set);
		
		P1Text = new JTextPane();
		P1Text.setBackground(Color.BLACK);
		P1Text.setForeground(Color.GRAY);
		P1Text.setEnabled(false);
		P1Text.setEditable(false);
		P1Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		P1Text.setText("Player 1:");
		P1Text.setBounds(10, 11, 54, 20);
		getContentPane().add(P1Text);
		
		P2Text = new JTextPane();
		P2Text.setText("Player 2:");
		P2Text.setForeground(Color.GRAY);
		P2Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		P2Text.setEnabled(false);
		P2Text.setEditable(false);
		P2Text.setBackground(Color.BLACK);
		P2Text.setBounds(10, 91, 54, 20);
		getContentPane().add(P2Text);
		
		P3Text = new JTextPane();
		P3Text.setText("Player 3:");
		P3Text.setForeground(Color.GRAY);
		P3Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		P3Text.setEnabled(false);
		P3Text.setEditable(false);
		P3Text.setBackground(Color.BLACK);
		P3Text.setBounds(10, 171, 54, 20);
		getContentPane().add(P3Text);
		
		P4Text = new JTextPane();
		P4Text.setText("Player 4:");
		P4Text.setForeground(Color.GRAY);
		P4Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		P4Text.setEnabled(false);
		P4Text.setEditable(false);
		P4Text.setBackground(Color.BLACK);
		P4Text.setBounds(10, 251, 54, 20);
		getContentPane().add(P4Text);
		
		MoneyText = new JTextPane();
		MoneyText.setText("Money/Points:");
		MoneyText.setForeground(Color.GRAY);
		MoneyText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		MoneyText.setEnabled(false);
		MoneyText.setEditable(false);
		MoneyText.setBackground(Color.BLACK);
		MoneyText.setBounds(320, 11, 80, 20);
		getContentPane().add(MoneyText);
		
		MoneyText2 = new JTextPane();
		MoneyText2.setText("Money/Points:");
		MoneyText2.setForeground(Color.GRAY);
		MoneyText2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		MoneyText2.setEnabled(false);
		MoneyText2.setEditable(false);
		MoneyText2.setBackground(Color.BLACK);
		MoneyText2.setBounds(320, 91, 80, 20);
		getContentPane().add(MoneyText2);
		
		MoneyText3 = new JTextPane();
		MoneyText3.setText("Money/Points:");
		MoneyText3.setForeground(Color.GRAY);
		MoneyText3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		MoneyText3.setEnabled(false);
		MoneyText3.setEditable(false);
		MoneyText3.setBackground(Color.BLACK);
		MoneyText3.setBounds(320, 171, 80, 20);
		getContentPane().add(MoneyText3);
		
		MoneyText4 = new JTextPane();
		MoneyText4.setText("Money/Points:");
		MoneyText4.setForeground(Color.GRAY);
		MoneyText4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		MoneyText4.setEnabled(false);
		MoneyText4.setEditable(false);
		MoneyText4.setBackground(Color.BLACK);
		MoneyText4.setBounds(320, 251, 80, 20);
		getContentPane().add(MoneyText4);
		
		CharacterDescrip = new JTextArea();
		CharacterDescrip.setToolTipText("<html>This field holds a short description <br>of the first player's character.</html>");
		CharacterDescrip.setFont(new Font("Times New Roman", Font.BOLD, 12));
		CharacterDescrip.setBackground(Color.GRAY);
		CharacterDescrip.setForeground(Color.BLACK);
		CharacterDescrip.setText("P1 Character");
		CharacterDescrip.setBounds(80, 10, 200, 20);
		CharacterDescrip.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	CharacterDescrip.setText("");
            }
        });
		getContentPane().add(CharacterDescrip);
		
		
		CharacterDescrip2 = new JTextArea();
		CharacterDescrip2.setToolTipText("<html>This field holds a short description <br>of the second player's character.</html>");
		CharacterDescrip2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		CharacterDescrip2.setText("P2 Character");
		CharacterDescrip2.setForeground(Color.BLACK);
		CharacterDescrip2.setBackground(Color.GRAY);
		CharacterDescrip2.setBounds(80, 90, 200, 20);
		CharacterDescrip2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	CharacterDescrip2.setText("");
            }
        });
		getContentPane().add(CharacterDescrip2);
		
		CharacterDescrip3 = new JTextArea();
		CharacterDescrip3.setToolTipText("<html>This field holds a short description <br>of the third player's character.</html>");
		CharacterDescrip3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		CharacterDescrip3.setText("P3 Character");
		CharacterDescrip3.setForeground(Color.BLACK);
		CharacterDescrip3.setBackground(Color.GRAY);
		CharacterDescrip3.setBounds(80, 170, 200, 20);
		CharacterDescrip3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	CharacterDescrip3.setText("");
            }
        });
		getContentPane().add(CharacterDescrip3);
		
		CharacterDescrip4 = new JTextArea();
		CharacterDescrip4.setToolTipText("<html>This field holds a short description <br>of the fourth player's character.</html>");
		CharacterDescrip4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		CharacterDescrip4.setText("P4 Character");
		CharacterDescrip4.setForeground(Color.BLACK);
		CharacterDescrip4.setBackground(Color.GRAY);
		CharacterDescrip4.setBounds(80, 250, 200, 20);
		CharacterDescrip4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	CharacterDescrip4.setText("");
            }
        });
		getContentPane().add(CharacterDescrip4);
		
		RollDice = new JButton("Roll Dice");
		RollDice.setToolTipText("<html>This button will roll a dice with an input number of<br>faces an input number of times.<br>The number of faces and the number of times are<br>input in the \"Time(s)\" field and the \"Sides\" field.</html>");
		RollDice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		RollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollButton(e);
			}
		});
		RollDice.setBounds(220, 350, 90, 20);
		getContentPane().add(RollDice);
		
		NoteBox = new JTextArea();
		NoteBox.setToolTipText("<html>This field will hold notes you may need to set during the game.</html>");
		NoteBoxSP = new JScrollPane(NoteBox);
		NoteBoxSP.setToolTipText("<html>This field will hold notes you may need to set during the game.</html>");
		NoteBox.setWrapStyleWord(true);
		NoteBox.setLineWrap(true);
		NoteBox.setText("Click to add notes.");
		NoteBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		NoteBox.setBounds(420, 30, 190, 340);
		NoteBoxSP.setWheelScrollingEnabled(true);
		NoteBoxSP.getVerticalScrollBar();
		NoteBoxSP.setBounds(420, 30, 190, 340);
		getContentPane().add(NoteBoxSP);
		
		NotePane = new JTextPane();
		NotePane.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		NotePane.setEnabled(false);
		NotePane.setEditable(false);
		NotePane.setBackground(Color.BLACK);
		NotePane.setForeground(Color.LIGHT_GRAY);
		NotePane.setText("Notes:");
		NotePane.setBounds(420, 10, 60, 20);
		getContentPane().add(NotePane);
		
		RollNum = new JTextPane();
		RollNum.setToolTipText("<html>This field holds the amount of times you want to roll the dice.</html>");
		RollNum.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		RollNum.setText("1");
		RollNum.setBounds(90, 350, 25, 20);
		getContentPane().add(RollNum);
		
		RollSides = new JTextPane();
		RollSides.setToolTipText("<html>This field holds the amount of sides your die has.</html>");
		RollSides.setText("6");
		RollSides.setBounds(170, 350, 30, 20);
		getContentPane().add(RollSides);
		
		times = new JTextPane();
		times.setEditable(false);
		times.setEnabled(false);
		times.setBackground(Color.BLACK);
		times.setForeground(Color.GRAY);
		times.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		times.setText("Time(s):");
		times.setBounds(55, 330, 55, 20);
		getContentPane().add(times);
		
		txtSides = new JTextPane();
		txtSides.setText("Sides:");
		txtSides.setForeground(Color.GRAY);
		txtSides.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtSides.setEnabled(false);
		txtSides.setEditable(false);
		txtSides.setBackground(Color.BLACK);
		txtSides.setBounds(145, 330, 40, 20);
		getContentPane().add(txtSides);
	}
	
	public void setButton(ActionEvent e, JTextArea text, String valueToSet) {
		AppMechanics.set(text, valueToSet, this);
	}
	
	public void addButton(ActionEvent e, JTextArea text, int valueToAdd) {
		AppMechanics.add(text, valueToAdd, this);
	}
	
	public void transButton(ActionEvent e, JTextArea text) {
		AppMechanics.transfer(text, this);
	}
	
	public void error(String error){
		JOptionPane.showMessageDialog(this, error,  "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public String inputBox(String text){
		return JOptionPane.showInputDialog(this, text, "Input");
	}
	
	public void subButton(ActionEvent e, JTextArea text, int valueToSub) {
		AppMechanics.subtract(text, valueToSub, this);
	}
	
	public void rollButton(ActionEvent e){
		AppMechanics.rollDice(this);
	}
}
