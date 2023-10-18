package spaceInvaders;

import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.ImageIcon;

public class PlayerShip extends characters {
	// for the width of the player ship, to be used later
	private int width;

	public PlayerShip() {

		playerInit();
	}

	// player initiator Method
	/*
	 * Purpose: To initiate the player Pre: void, so no parameters Return: Nothing
	 */
	private void playerInit() {
		// set icon to image, set new image to icon, scale image, set image to image of
		// laser
		playerIcon = new ImageIcon("Images/Laser_Cannon.png");
		Image playerImage = playerIcon.getImage();
		Image modiPlayerImage = playerImage.getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH);
		playerIcon = new ImageIcon(modiPlayerImage);
		setImage(playerIcon.getImage());
		// get width
		width = playerIcon.getImage().getWidth(null);

		// set x and y cords
		setX(540);

		setY(560);
	}

	// player mover Method
	/*
	 * Purpose: To move the player in the x direction Pre: void, so no parameters
	 * Return: Nothing
	 */
	public void move() {

		// add the neccesary movement to the current x cord
		x += tx;

		// check to see if the cord is acceptable
		if (x <= 2) {

			// if not change to acceptable quantity
			x = 2;
		}
		// check to see if the cord is acceptable
		if (x >= 716 - width) {
			// if not change to acceptable quantity
			x = 716 - width;
		}
	}

	// key pressed dector Method
	/*
	 * Purpose: To see if the key is pressed, if so change the movement of the
	 * player Pre: key Return: Nothing
	 */
	public void keyPressed(KeyEvent e) {

		// get the code
		int key = e.getKeyCode();

		// if the code matches the left arrow key
		if (key == KeyEvent.VK_LEFT) {
			// then player should move 6 to the left
			tx = -6;
		}

		// if the code matches the right arrow key
		if (key == KeyEvent.VK_RIGHT) {
			// then player should move 6 to the right
			tx = 6;
		}
	}

	// key released dector Method
	/*
	 * Purpose: To see if the key is released, if so change the movement of the
	 * player back to 0 Pre: key Return: Nothing
	 */
	public void keyReleased(KeyEvent e) {
		// get the code
		int key = e.getKeyCode();
		// if the code matches the left arrow key
		if (key == KeyEvent.VK_LEFT) {
			// change move back to zero
			tx = 0;
		}
		// if the code matches the right arrow key
		if (key == KeyEvent.VK_RIGHT) {
			// change move back to zero
			tx = 0;
		}
	}
}
