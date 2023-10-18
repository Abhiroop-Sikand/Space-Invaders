package spaceInvaders;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

/* Abhiroop Sikand
 * Space Invaders Game, player avoids shots and eliminates aliens
 * Monday, January 24, 2022
 */
public class MainSpaceInvaders extends JFrame {

	// This is the panel where I add the menu
	private JPanel contentPane;
	// Int variable to keep track of the players level and increase difficulty
	public static int level;
	// For calling the game screen and hiding it. Used across multiple classes
	public static gameScreen gameScreen;

	// Main Menu Constructor
	/*
	 * Purpose: To add the menu contents Pre: void, no parameters Return: Nothing
	 */
	public MainSpaceInvaders() {
		// Set the level to one as new game is starting
		level = 1;

		// For the frame/panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Dimensions
		setBounds(550, 120, 716, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// Stop from changing size via dragging
		setResizable(false);

		// help 1 frame variable
		help1 help1 = new help1();

		/////// MAIN MENU BUTTONS

		// Play Button
		JButton play = new JButton("PLAY");
		// Font and dimensions for button
		play.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		play.setBounds(10, 586, 231, 85);
		// Check if button clicked
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bring in the game screen and dispose of this screen
				gameScreen = new gameScreen();
				gameScreen.setVisible(true);
				dispose();

			}
		});
		// add the button to panel/frame
		contentPane.setLayout(null);
		contentPane.add(play);

		// Help Button
		JButton btnHelp = new JButton("HELP");
		// Fonts and dimensions
		btnHelp.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		btnHelp.setBounds(475, 586, 231, 85);
		// Check if button clicked
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bring in help screen, dispose of current screen
				help1.setVisible(true);
				dispose();
			}
		});
		// add button to screen
		contentPane.add(btnHelp);

		// Main Screen Background Image
		// Create Jlabel
		JLabel mainBackgroundLabel = new JLabel("New label");
		// Locate and assign icon to variable
		ImageIcon mainBackgroundIcon = new ImageIcon("Images/MainBackground.jpeg");
		// Resize
		Image mainBackgroundImage = mainBackgroundIcon.getImage();
		Image modifiedMainBackgroundImage = mainBackgroundImage.getScaledInstance(716, 700,
				java.awt.Image.SCALE_SMOOTH);
		mainBackgroundIcon = new ImageIcon(modifiedMainBackgroundImage);
		// Set Jlabel Icon To Main Sreen Image/Icon
		mainBackgroundLabel.setIcon(mainBackgroundIcon);
		// Label Size
		mainBackgroundLabel.setBounds(0, -15, 716, 716);
		contentPane.add(mainBackgroundLabel);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// call in the above code/ bring in the frame
		MainSpaceInvaders msi = new MainSpaceInvaders();
		msi.setVisible(true);

	}
}
