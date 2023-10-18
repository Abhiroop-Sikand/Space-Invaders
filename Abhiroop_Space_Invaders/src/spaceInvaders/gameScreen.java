package spaceInvaders;

import javax.swing.JFrame;

public class gameScreen extends JFrame {

	// gameScreen frame constructor
	/*
	 * Purpose: To create the fram Pre: void, so no parameters Return: Nothing
	 */
	public gameScreen() {
		// add the panel
		add(new playArea());

		// components of the frame
		setTitle("Space Invaders");
		setBounds(550, 120, 716, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

}
