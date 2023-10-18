package spaceInvaders;

import java.awt.Image;

import javax.swing.ImageIcon;

public class characters {

	// for the different sprites/characters status in the game
	private boolean visible;
	// image for the characters
	private Image image;
	// for character status
	private boolean dying;
	// image for the laser, player, alien and bombs
	protected ImageIcon laserIcon;
	protected ImageIcon playerIcon;
	protected ImageIcon alienIcon;
	protected ImageIcon bombIcon;
	// x and y cords to be used
	int x, tx, y;

	// make the characters visible
	public characters() {

		visible = true;
	}

	// death Method
	/*
	 * Purpose: To set the visibility status to false Pre: void, so no parameters
	 * Return: Nothing
	 */
	public void die() {

		visible = false;
	}

	// visibility Method
	/*
	 * Purpose: to check visibility status Pre: void, so no parameters Return:
	 * whether the characters are visible or not
	 */
	public boolean isVisible() {

		return visible;
	}

	// set visibility Method
	/*
	 * Purpose: To set the visibility status to false Pre: void, so no parameters
	 * Return: nothing
	 */
	protected void setVisible(boolean visible) {

		this.visible = visible;
	}

	// set image Method
	/*
	 * Purpose: To set the image for the characters Pre: void, so no parameters
	 * Return: nothing
	 */
	public void setImage(Image image) {

		this.image = image;
	}

	// get image Method
	/*
	 * Purpose: To get the image for the characters Pre: void, so no parameters
	 * Return: the image
	 */
	public Image getImage() {

		return image;
	}

	// set x Method
	/*
	 * Purpose: To set the x cord for the for the characters Pre: x cord in int form
	 * Return: nothing
	 */
	public void setX(int x) {

		this.x = x;
	}

	// set y Method
	/*
	 * Purpose: To set the y cord for the for the characters Pre: y cord in int form
	 * Return: nothing
	 */
	public void setY(int y) {

		this.y = y;
	}

	// get y Method
	/*
	 * Purpose: To get the y cord for the for the characters Pre: none Return: int
	 * for the y cord
	 */
	public int getY() {

		return y;
	}

	// get x Method
	/*
	 * Purpose: To get the x cord for the for the characters Pre: none Return: int
	 * for the x cord
	 */
	public int getX() {

		return x;
	}

	// set death status Method
	/*
	 * Purpose: To set the status of whether a character is dead Pre: boolean for
	 * the status Return: nothing
	 */
	public void dying(boolean dying) {

		this.dying = dying;
	}

	// get death status Method
	/*
	 * Purpose: To get the status of whether a character is dying Pre: boolean for
	 * the status Return: nothing
	 */
	public boolean isDying() {

		return this.dying;
	}
}
