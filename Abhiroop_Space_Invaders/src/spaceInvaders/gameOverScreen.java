package spaceInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameOverScreen extends JFrame {
	// panel
	private JPanel contentPane;

	public gameOverScreen() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Dimensions
		setBounds(550, 120, 716, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		// Stop from changing size via dragging
		setResizable(false);

		// Play Button
		JButton play = new JButton("");
		// Font and dimensions for button
		play.setBounds(220, 546, 280, 56);
		// Check if button clicked
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new instance of main menu
				MainSpaceInvaders ms = new MainSpaceInvaders();
				// set the new frame to be visble and current frame disposed of
				ms.setVisible(true);
				dispose();

			}
		});
		// set the button to be transparent and add it to the frame
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		contentPane.setLayout(null);
		contentPane.add(play);

		scores(MainSpaceInvaders.level - 1);
		System.out.println(MainSpaceInvaders.level);

	}

	// Method
	public void scores(int score) {
		// Check if new highscore is created

		// Find File
		File f = new File("highscore.txt");
		Scanner file = null;
		ArrayList<Integer> highscores = new ArrayList<Integer>();
		try {
			// reading from file
			file = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Continue reading so long as theres another line
		while (file.hasNextLine()) {
			// read in next line
			String temp = file.nextLine();
			// make sure string is not empty
			if (!temp.equals("")) {
				// convert string to int and add to highscore list
				highscores.add(Integer.parseInt(temp));
			}
		}

		// check id there are high scores
		if (highscores.size() > 0) {
			// Go through the high scores
			for (int i = 0; i < highscores.size(); i++) {
				// Is the current user score higher than a highscore
				if (highscores.get(i) < score) {
					// Add the user score into the index of the old highscore it is larger than
					highscores.add(i, score);
					// If there are more than 5 high scores, remove the last high score
					if (highscores.size() > 5)
						highscores.remove(highscores.size() - 1);
					// Exit because we are done adding highscores
					break;
				}
			}
		} else {
			// No highscores, current score is a highscore
			highscores.add(score);
		}

		try {
			// Write to the file
			PrintWriter pw = new PrintWriter(f);
			// Empty the file contents
			pw.write("");
			// Go through the highscores list
			for (int i : highscores) {
				// Add the highscore to the list
				pw.print(i);
				// Add in the nextline
				pw.print("\n");
			}
			// Close the printerWriter
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create Jlabel
		JLabel scores = new JLabel("Score: " + (MainSpaceInvaders.level - 1));
		scores.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		scores.setForeground(Color.WHITE);

		// Label Size
		scores.setBounds(260, 346, 680, 56);
		contentPane.setLayout(null);

		contentPane.add(scores);

		// HIGHSCORE TEXT
		// hold higschore list in text format
		String scoresList = "";
		// Go through all highscores
		for (int i = 0; i < highscores.size(); i++) {
			// add highscore to the scoreList variable
			scoresList += i + 1 + ": " + highscores.get(i) + ",  ";
		}
		// Show the label with all the highscores
		JLabel lblNewLabel_1_1 = new JLabel("HIGHSCORES= " + scoresList);

		// Font
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel_1_1.setForeground(Color.WHITE);

		lblNewLabel_1_1.setBounds(260, 396, 580, 56);
		contentPane.add(lblNewLabel_1_1);

		// Screen Background Image
		// Create Jlabel
		JLabel mainBackgroundLabel = new JLabel("New label");
		// Locate and assign icon to variable
		ImageIcon mainBackgroundIcon = new ImageIcon("Images/Game Over.png");
		// Resize
		Image mainBackgroundImage = mainBackgroundIcon.getImage();
		Image modifiedMainBackgroundImage = mainBackgroundImage.getScaledInstance(716, 700,
				java.awt.Image.SCALE_SMOOTH);
		mainBackgroundIcon = new ImageIcon(modifiedMainBackgroundImage);
		// Set Jlabel Icon To Sreen Image/Icon
		mainBackgroundLabel.setIcon(mainBackgroundIcon);
		// Label Size
		mainBackgroundLabel.setBounds(0, 0, 716, 700);
		contentPane.setLayout(null);

		contentPane.add(mainBackgroundLabel);
	}

}
