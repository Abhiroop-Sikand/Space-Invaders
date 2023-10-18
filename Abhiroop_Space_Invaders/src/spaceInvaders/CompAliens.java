package spaceInvaders;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CompAliens extends characters {

	public CompAliens(int x, int y) {
		// call the initiator for alien
		InitCompAlien(x, y);
	}

	// alien initiator Method
	/*
	 * Purpose: set the image and x and y cords of the alien Pre: 2 int values for
	 * the x and y cord Return: Nothing
	 */
	private void InitCompAlien(int x, int y) {
		// get image in form of icon, make it an image, scale the image, make the image
		// into the image of the alien
		alienIcon = new ImageIcon("Images/alien.png");
		Image alienImage = alienIcon.getImage();
		Image modiAlienImage = alienImage.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		alienIcon = new ImageIcon(modiAlienImage);
		setImage(alienIcon.getImage());

		// set x and y cord to provided cords
		setX(x);
		setY(y);

	}

	// alien mover Method
	/*
	 * Purpose: move the alien in the x direction Pre: int for the movement Return:
	 * Nothing
	 */
	public void moveAlien(int horizAlien) {
		// set the x cord to new cord
		this.x = this.x + horizAlien;
	}
}
