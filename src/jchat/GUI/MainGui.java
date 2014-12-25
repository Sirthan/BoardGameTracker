package jchat.GUI;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jchat.networking.MessageListener;
import jchat.networking.MessageTransmitter;
import jchat.networking.WriteableGui;

public class MainGui extends JFrame implements WriteableGui{
	JTextArea Chat;
	JTextArea IP;
	JTextArea Users;
	JTextArea Message;
	JTextArea ReceivePort;
	JTextArea HostNum;
	JScrollPane chat;
	JButton Send;
	JButton Listener;
	MessageListener MessageListener;
 	public MainGui() {
		setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().setBackground(Color.BLACK);
		setTitle("JChat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(550,390);
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

		IP = new JTextArea();
		IP.setBounds(180, 10, 240, 20);
		IP.setText("Enter IP here");
		IP.setFont(new Font("Times New Roman", Font.BOLD, 12));
		IP.setBackground(Color.GRAY);
		getContentPane().add(IP);

		HostNum = new JTextArea();
		HostNum.setFont(new Font("Times New Roman", Font.BOLD, 12));
		HostNum.setBackground(Color.GRAY);
		HostNum.setText("Host#");
		HostNum.setBounds(430, 10, 80, 20);
		getContentPane().add(HostNum);

		Chat = new JTextArea();
		chat = new JScrollPane(Chat);
		Chat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Chat.setEditable(false);
		Chat.setLineWrap(true);
		Chat.setWrapStyleWord(true);
		Chat.setBackground(Color.LIGHT_GRAY);
		Chat.setBounds(10, 40, 410, 230);
		chat.setBounds(10, 40, 410, 230);
		chat.setWheelScrollingEnabled(true);
		chat.getVerticalScrollBar();
		getContentPane().add(chat);


		Users = new JTextArea();
		Users.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Users.setEditable(false);
		Users.setBackground(Color.LIGHT_GRAY);
		Users.setBounds(430, 40, 100, 230);
		getContentPane().add(Users);


		Message = new JTextArea();
		Message.setBackground(Color.WHITE);
		Message.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Message.setBounds(10, 280, 410, 70);
		Message.setLineWrap(true);
		Message.setWrapStyleWord(true);
		getContentPane().add(Message);


		Send = new JButton("Send!");
		Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendActionPerformed(e);
			}
		});
		Send.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Send.setBounds(430, 280, 100, 70);
		getContentPane().add(Send);


		ReceivePort = new JTextArea();
		ReceivePort.setText("Recive Port");
		ReceivePort.setFont(new Font("Times New Roman", Font.BOLD, 12));
		ReceivePort.setBackground(Color.GRAY);
		ReceivePort.setBounds(10, 10, 70, 20);
		getContentPane().add(ReceivePort);

		Listener = new JButton("Listen");
		Listener.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Listener.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ListenerActionPerformed(evt);
			}
		});
		Listener.setBounds(90, 10, 80, 20);
		getContentPane().add(Listener);
		setVisible(true);
		
		InputMap im = Message.getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "none");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
        this.Message.getRootPane().setDefaultButton(Send);
	}

	@Override
	public void write(String s) {
		Chat.append(s + System.lineSeparator());

	}
	
	public void ListenerActionPerformed(ActionEvent e) {
		try{
		MessageListener = new MessageListener(this, Integer.parseInt(ReceivePort.getText()));
		} catch(NumberFormatException ie){
			write("ERROR - Make sure the value in receive port is an integer!");
			JOptionPane.showMessageDialog(this, "Make sure the value in receive port is an integer!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		MessageListener.start();
	}
	public void SendActionPerformed(ActionEvent e){
		MessageTransmitter transmitter = null;
		try{
			transmitter = new MessageTransmitter(Message.getText(), IP.getText(), Integer.parseInt(HostNum.getText()), this);
		} catch(NumberFormatException ie){
			write("ERROR - Make sure the value in host number is an integer!");
			JOptionPane.showMessageDialog(this, "Make sure the value in host number is an integer!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		Message.setText("");
		transmitter.start();
	}
	
}
