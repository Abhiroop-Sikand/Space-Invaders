package spaceInvaders;

import java.awt.Image;

import javax.swing.ImageIcon;

public class bomb extends characters {

	public bomb() {
	}

	// bomb Method
	/*
	 * Purpose: to set the images for the bomb Pre: x and y coordinates Return:
	 * Nothing
	 */
	public bomb(int x, int y) {
		// get the image into an icon
		bombIcon = new ImageIcon("Images/bomb.png");
		// set an image to be the icon
		Image bombImage = bombIcon.getImage();
		// scale to how is needed
		Image modiBombImage = bombImage.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
		// make it back into the icon
		bombIcon = new ImageIcon(modiBombImage);
		// set the bombs image to the image
		setImage(bombIcon.getImage());
		// set the x and y cords
		setX(x);
		setY(y);
	}

}
