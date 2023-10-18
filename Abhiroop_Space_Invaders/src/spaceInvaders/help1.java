package spaceInvaders;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class help1 extends JFrame {

	// panel for screen
	private JPanel contentPane;

	public help1() {
		// Screen and dimensions
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 120, 716, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// Stop from changing screen size
		setResizable(false);

		/////// HELP BUTTONS

		// Menu Button
		JButton menu = new JButton("MAIN MENU");
		// Font and dimensions for button
		menu.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		menu.setBounds(10, 586, 231, 85);
		// Check if button clicked
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Bring in menu frame and dispose current frame
				MainSpaceInvaders MainSpaceInvaders = new MainSpaceInvaders();
				MainSpaceInvaders.setVisible(true);
				dispose();

			}
		});
		// add button to panel
		contentPane.setLayout(null);
		contentPane.add(menu);

		// Screen Background Image
		// Create Jlabel
		JLabel mainBackgroundLabel = new JLabel("New label");
		// Locate and assign icon to variable
		ImageIcon mainBackgroundIcon = new ImageIcon("Images/help.png");
		// Resize
		Image mainBackgroundImage = mainBackgroundIcon.getImage();
		Image modifiedMainBackgroundImage = mainBackgroundImage.getScaledInstance(716, 700,
				java.awt.Image.SCALE_SMOOTH);
		mainBackgroundIcon = new ImageIcon(modifiedMainBackgroundImage);
		// Set Jlabel Icon To Sreen Image/Icon
		mainBackgroundLabel.setIcon(mainBackgroundIcon);
		// Label Size
		mainBackgroundLabel.setBounds(0, 0, 716, 700);
		contentPane.add(mainBackgroundLabel);

	}

}
