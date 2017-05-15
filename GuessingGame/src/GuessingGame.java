import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
public class GuessingGame extends JFrame{
	private JTextField txtGuess;
	private JLabel lblOutput;
	public int theNumber;
	private int triesLeft = 7;
	
	public void checkGuess(){
		
		String guessText = txtGuess.getText();
		String message = "";
		try {	
		int guess = Integer.parseInt(guessText);
		triesLeft--;
		if(guess>theNumber)
		{
			message = guess + " was too high." + "You have" + triesLeft +"tries left!";  
			lblOutput.setText(message);
		}
		else if (guess<theNumber)
		{
			message = guess + " was too low." + "You have" + triesLeft +"tries left!";
			lblOutput.setText(message);
		}
		else  
		{
			message = guess + " was rigt! You win! Let's Play Again ";
			lblOutput.setText(message);
			newGame();
		}
		if (triesLeft <=0){
			javax.swing.JOptionPane.showConfirmDialog(null, 
					"Sorry you ran out of tries .The number was" + theNumber + " .Play Again! ");
			newGame();
		}
			
		}
		catch (Exception e){
			lblOutput.setText("Enter a Whole Number between 1 and 100!");
		}
		finally {
		txtGuess.requestFocus();
		txtGuess.selectAll();

	}}
	public void newGame(){
		
		theNumber = (int)(Math.random() * 100 + 1 );
		triesLeft = 7;
		
	}
		
	public GuessingGame() {
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setBackground(new Color(0, 255, 204));
		setBackground(new Color(0, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblHiloguessinggame = new JLabel("Hi-Lo Guessing Game");
		lblHiloguessinggame.setForeground(Color.BLACK);
		lblHiloguessinggame.setBounds(10, 11, 434, 16);
		lblHiloguessinggame.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblHiloguessinggame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHiloguessinggame);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setBounds(51, 78, 211, 14);
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setBounds(287, 75, 65, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener(){
			

			
			@Override

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				checkGuess();

			}

		});
		btnGuess.setBounds(179, 143, 98, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a Number Above .You have 7 Tries!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(80, 200, 314, 14);
		getContentPane().add(lblOutput);
	}
	public static void main(String[]args){
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430,330));
		theGame.setVisible(true);
		
		 
	}
}
