package spaceInvaders;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class winScreen extends JFrame {
	private JPanel contentPane;

	public winScreen() {
		// add 1 to the level
		MainSpaceInvaders.level++;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Dimensions
		setBounds(550, 120, 716, 700);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// Stop from changing size via dragging
		setResizable(false);

		// Play Button
		JButton play = new JButton("");
		// Font and dimensions for button
		// play.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		play.setBounds(167, 466, 383, 78); // 167
		// Check if button clicked
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// start the game again
				MainSpaceInvaders.gameScreen = new gameScreen();
				MainSpaceInvaders.gameScreen.setVisible(true);
				dispose();

			}
		});
		// make button invisible
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		// add button to panel
		contentPane.setLayout(null);
		contentPane.add(play);

		// Screen Background Image
		// Create Jlabel
		JLabel mainBackgroundLabel = new JLabel("New label");
		// Locate and assign icon to variable
		ImageIcon mainBackgroundIcon = new ImageIcon("Images/winScreen.png");
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
