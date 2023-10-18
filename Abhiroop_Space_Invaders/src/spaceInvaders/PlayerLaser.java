package spaceInvaders;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerLaser extends characters {

	public PlayerLaser() {

	}

	public PlayerLaser(int x, int y) {
		// cal the laser initiator
		initShot(x, y);
	}

	// laser initiator Method
	/*
	 * Purpose: initiate the laser Pre: 2 ints for the x and y cords Return: Nothing
	 */
	private void initShot(int x, int y) {

		// set icon to image, set new image to icon, scale image, set image to image of
		// laser
		laserIcon = new ImageIcon("Images/laser.png");
		Image laserImage = laserIcon.getImage();
		Image modiLaserImage = laserImage.getScaledInstance(3, 15, java.awt.Image.SCALE_SMOOTH);
		laserIcon = new ImageIcon(modiLaserImage);
		setImage(laserIcon.getImage());

		// set x and y cords
		setX(x + 14);

		setY(y - 1);
	}

}
