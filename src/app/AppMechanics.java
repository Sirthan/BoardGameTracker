package app;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class AppMechanics {
	public static void add(JTextArea text, int numToAdd, MainGui Gui){
		int current = 0;
		try{
		current = Integer.parseInt(text.getText().trim());
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		text.setText(current + numToAdd + "");
	}
	
	public static void subtract(JTextArea text, int numToSub, MainGui Gui){
		int current = 0;
		try{
		current = Integer.parseInt(text.getText().trim());
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		text.setText(current - numToSub + "");
	}
	
	public static void set(JTextArea text, String textToSet, MainGui Gui){
		text.setText(textToSet);
	}
	
	public static void transfer(JTextArea text, MainGui Gui){
		Object[] players = {"Player 1", "Player 2", "Player 3", "Player 4"}; 
		String player = (String)JOptionPane.showInputDialog(Gui, "Which player would you like to give money to?", "Input", JOptionPane.PLAIN_MESSAGE, null, players, "Player 1");
		String current = JOptionPane.showInputDialog(Gui, "How much would you like to give to " + player + "?", "Input");
		int curint = 0;
		try {
			curint = Integer.parseInt(current);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(Gui, "The value you entered is not a Number!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(player.equals("Player 1")){
			try{
				Gui.p1Money.setText(Integer.parseInt(Gui.p1Money.getText()) + curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player1.getText() + "'s money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try{
				text.setText(Integer.parseInt(text.getText()) - curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else if(player.equals("Player 2")){
			try{
				Gui.p2Money.setText(Integer.parseInt(Gui.p2Money.getText()) + curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player2.getText() + "'s money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try{
				text.setText(Integer.parseInt(text.getText()) - curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else if(player.equals("Player 3")){
			try{
				Gui.p3Money.setText(Integer.parseInt(Gui.p3Money.getText()) + curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player3.getText() + "'s money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try{
				text.setText(Integer.parseInt(text.getText()) - curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else if(player.equals("Player 4")){
			try{
				Gui.p4Money.setText(Integer.parseInt(Gui.p4Money.getText()) + curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in " + Gui.player4.getText() + "'s money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try{
				text.setText(Integer.parseInt(text.getText()) - curint + "");
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(Gui, "The value entered in money is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
	
	public static void rollDice(MainGui Gui){
		int times = 0;
		int faces = 0;
		try{
		times = Integer.parseInt(Gui.RollNum.getText().trim());
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(Gui, "The value entered in rolls is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} 
		try{
		faces = Integer.parseInt(Gui.RollSides.getText().trim());
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(Gui, "The value entered in Sides is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(times == 1){
			int random = (int) ((Math.random() * faces) + 1);
			JOptionPane.showMessageDialog(Gui, "You rolled a " + random + "!", "Roll Result", JOptionPane.PLAIN_MESSAGE);
		} else if(times <= 0){
			JOptionPane.showMessageDialog(Gui, "The value entered in times is not a positive number!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int[] randoms = new int[times];
			for(int i = 0; i < times; i++) randoms[i] = (int) ((Math.random() * faces) + 1);
			JOptionPane.showMessageDialog(Gui, "You rolled a... " + concatIntArray(randoms) + "and the sum of these numbers is " + addIntArray(randoms) + "!" , "Roll Result", JOptionPane.PLAIN_MESSAGE);
		}
	}
	private static String concatIntArray(int[] numbs){
		String num = "\n";
		for(int i = 0; i < numbs.length; i++)num += numbs[i] + "\n";
		return num;
	}
	
	private static int addIntArray(int[] numbs){
		int num = 0;
		for(int i = 0; i < numbs.length; i++)num += numbs[i];
		return num;
	}
}
