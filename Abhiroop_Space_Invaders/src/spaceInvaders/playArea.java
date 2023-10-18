package spaceInvaders;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class playArea extends JPanel {

	private PlayerShip player; // new object/instance of playerShip class
	private PlayerLaser laser; // new object/instance of playerLaser class
	private CompAliens[] alien; // new array of objects/instances of alien class
	private bomb[] bomb, bomb2; // new array of objects/instances of bomb class
	private boolean game, direction = true, playerWin = false; // game is for determining if game is still on, direction
																// for left right movement of alien, playerWin for
																// determining if player has won
	private boolean[] respawn; // array for each alien to determine if it should respawn
	private Timer timer; // timer for repainting the screen
	private ImageIcon explosionIcon = new ImageIcon("Images/explosion8.png"); // icon for the explosion of alien and
																				// player
	private Image explosionImage = explosionIcon.getImage();// use icon and put into image
	private int deadAliens = 0; // to keep track of how many aliens have died

	public playArea() {

		// call the board method
		board();
		// call the game starter method
		gameStart();

		// create the timer
		timer = new Timer(17, null);
		// start the timer
		timer.start();
		// when the specified time goes by cycle/refresh the game screen
		timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doGameCycle();
			}
		});
	}

	// Board Method
	/*
	 * Purpose: Set the floor for the game Pre: void, so no parameters Return:
	 * Nothing
	 */
	private void board() {

		// for detecting action on the keys
		addKeyListener(new keys());
		// set the panel to be focused in order to receive inputs. precautionary only as
		// it is default set true
		setFocusable(true);
		// set background to be black
		setBackground(Color.black);

		// call game start method
		gameStart();

	}

	private void gameStart() {
		// game has started
		game = true;
		// new instance of the players ship
		player = new PlayerShip();
		// new instance of the laser
		laser = new PlayerLaser();
		// new instance of the alien
		alien = new CompAliens[24];
		// 2 new instances of the bombs.
		bomb = new bomb[24];
		bomb2 = new bomb[24];
		// 24 boolean array
		respawn = new boolean[24];

		// for which alien is currently being given spawn points
		int i = 0;
		// loop to go through row by row
		for (int y = 0; y < 4; y++) {
			// loop to go through each column in the current row
			for (int x = 0; x < 6; x++) {
				// set the aliens coordinates and bombs coordinates
				alien[i] = new CompAliens(300 + 36 * x, 10 + 36 * y);
				bomb2[i] = new bomb(alien[i].getX(), alien[i].getY());
				bomb[i] = new bomb(alien[i].getX(), alien[i].getY());
				// make bomb2 visible false as only the first bombs will show in the start
				bomb2[i].die();
				// make respawn for the first bombs true
				respawn[i] = true;
				// next alien
				i++;
			}
		}
	}

	// player drawing Method
	/*
	 * Purpose: To draw the players ship Pre: graphics Return: Nothing
	 */
	private void playerDraw(Graphics g) {

		// check if the player is still alive first
		if (player.isVisible()) {

			// if player is alive redraw
			g.drawImage(player.getImage(), player.getX(), player.getY(), this);
		}
		// check if the player is dying
		if (player.isDying()) {

			// if player was dying, kill it
			player.die();
			// set game to false to signify the game is over
			game = false;
		}

	}

	// laser drawing Method
	/*
	 * Purpose: To draw the players laser Pre: graphics Return: Nothing
	 */
	private void laserDraw(Graphics g) {

		// check if the laser is visible/fired first
		if (laser.isVisible()) {

			// redraw the laser
			g.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
		}

	}

	// bomb drawing Method
	/*
	 * Purpose: To draw the aliens bomb Pre: graphics Return: Nothing
	 */
	private void bombDraw(Graphics g) {
		// loop through the bomb for each alien, total 24
		for (int i = 0; i < 24; i++) {

			// if the first set of bombs is visible
			if (bomb[i].isVisible()) {
				// check first if the bomb is respawning
				if (respawn[i]) {
					// if the bomb is respawning then set its coordinates to under the alien it is
					// with
					bomb[i].setX(alien[i].getX() + 4);
					bomb[i].setY(alien[i].getY() + 10);

				}
				// redraw the bomb
				g.drawImage(bomb[i].getImage(), bomb[i].getX(), bomb[i].getY(), this);

				// set respawn to false, meaning that the next bombs to respawn is from the 2nd
				// set
				respawn[i] = false;

			}
			// check of the second set of bombs is visible
			else if (bomb2[i].isVisible()) {
				// check first if the bomb is respawning
				if (!respawn[i]) {
					// if the bomb is respawning then set its coordinates to under the alien it is
					// with
					bomb2[i].setX(alien[i].getX() + 4);
					bomb2[i].setY(alien[i].getY() + 10);
				}
				// redraw the bomb
				g.drawImage(bomb2[i].getImage(), bomb2[i].getX(), bomb2[i].getY(), this);
				// set respawn to false, meaning that the next bombs to respawn is from the
				// first set
				respawn[i] = true;

			}

		}
	}

	// alien drawing Method
	/*
	 * Purpose: To draw the aliens Pre: graphics Return: Nothing
	 */
	private void alienDraw(Graphics g) {

		// loop to go through all 24 aliens
		for (int i = 0; i < 24; i++) {
			// check if the alien is still alive
			if (alien[i].isVisible()) {

				// if it is the redraw
				g.drawImage(alien[i].getImage(), alien[i].getX(), alien[i].getY(), this);
			}

			// if the alien is dying, meaning its shot
			if (alien[i].isDying()) {
				// then kill it
				alien[i].die();

			}
		}

	}

	// paint Method
	/*
	 * Purpose: overiding the paint method inorder to set our own rules to what is
	 * repainted Pre: graphics Return: Nothing
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// set the drawing colour to blue
		g.setColor(Color.blue);

		// check if all aliens are dead
		if (deadAliens == 24) {
			// if all aliens are dead then game is won by player
			game = false;
			playerWin = true;
		}

		// if the game is still going then
		if (game) {

			// draw the line to represent the ground
			g.drawLine(0, 580, 716, 580);

			// draw each of the visible
			playerDraw(g);
			laserDraw(g);
			alienDraw(g);
			bombDraw(g);

		}
		// otherwise if the player has won the game then
		else if (playerWin) {
			// create new instance if the winning Screen
			winScreen ws = new winScreen();
			ws.setVisible(true);
			// stop the timer
			timer.stop();
			// hide the screen
			MainSpaceInvaders.gameScreen.setVisible(false);
		}
		// last option would mean the game is over
		else {
			// create a new instance of the game over screen, make it visible, hide this
			// screen.
			gameOverScreen gos = new gameOverScreen();
			gos.setVisible(true);
			timer.stop();
			MainSpaceInvaders.gameScreen.setVisible(false);

		}

	}

	// update Method
	/*
	 * Purpose: time has elapsed so we must update the game, move the alien, player,
	 * bombs and laser. then check for any changes Pre: none Return: Nothing
	 */
	private void update() {

		// call the method to move the player
		player.move();

		// y cord of the laser
		int y = laser.getY();
		// make it go up
		y -= 8;
		// before finalizing change check to make sure laser has not reached the top
		if (y < 0) {
			laser.die();
		} else {
			laser.setY(y);
		}

		// SHOT
		// go through all 24 aliens to check for a hit
		for (int i = 23; i > -1; i--) {
			// first make sure the laser is still visible and the alien we are checking is
			// alive
			if (laser.isVisible() && alien[i].isVisible()) {
				// then check for a hit
				if (laser.getX() >= alien[i].getX() && laser.getX() <= alien[i].getX() + 24
						&& laser.getY() >= alien[i].getY() && laser.getY() <= alien[i].getY() + 24) {

					// the laser has hit the alien, so kill it inorder to be fired again
					laser.die();
					// set the alien to explode
					Image modiexplosionImage = explosionImage.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
					explosionIcon = new ImageIcon(modiexplosionImage);
					alien[i].setImage(explosionIcon.getImage());
					// alien does not immediatly go away so glimpse of explosion is shown
					alien[i].dying(true);
					// add count to dead alien
					deadAliens++;

				}
			}
		}
		// ALIEN
		// go through all 24 aliens
		for (int i = 23; i > -1; i--) {
			// check if the alien is alive and above the ground
			if (alien[i].isVisible() && alien[i].getY() < 556) {
				// check the direction and move accordingly
				if (direction) {
					alien[i].moveAlien(-2);
				} else {
					alien[i].moveAlien(2);
				}
				// check fi alien has reached a wall, if so change directions and lower it
				if (alien[i].getX() == 0) {
					direction = false;
					for (int j = 0; j < 24; j++) {
						alien[j].setY(alien[j].getY() + 30);
					}
				}
				if (alien[i].getX() >= 692) {
					direction = true;
					for (int j = 0; j < 24; j++) {
						alien[j].setY(alien[j].getY() + 30);
					}
				}

			}
			// if the alien has reached the ground then kill all aliens to signify the game
			// is over
			else if (alien[i].getY() > 556) {
				for (int j = 0; j < 24; j++) {
					alien[j].die();

				}
			}
		}

		// Bomb
		// go through all 24 bombs
		for (int i = 0; i < 24; i++) {

			// first check to see if the alien is visible and bomb from this set is visible
			if (alien[i].isVisible() && bomb[i].isVisible()) {
				// lower the bomb based off the level
				bomb[i].setY(bomb[i].getY() + 1 * MainSpaceInvaders.level);
				// check to see if the bomb has hit the player
				if (bomb[i].getX() >= player.getX() - 9 && bomb[i].getX() <= player.getX() + 29
						&& bomb[i].getY() + 10 >= player.getY()) {
					// if so then kill the player
					Image modiexplosionImage = explosionImage.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
					explosionIcon = new ImageIcon(modiexplosionImage);
					player.setImage(explosionIcon.getImage());
					player.dying(true);
				}
				// check if the bomb has reach the ground if so then kill it and make the second
				// set of bombs visible
				if (bomb[i].getY() >= 570) {
					bomb[i].die();
					bomb2[i].setVisible(true);
				}
			}
			// check to see if the alien is visible and bomb from this set is visible
			else if (alien[i].isVisible() && bomb2[i].isVisible()) {
				// lower the bomb based off the level
				bomb2[i].setY(bomb2[i].getY() + 1 * MainSpaceInvaders.level);
				if (bomb2[i].getX() >= player.getX() - 9 && bomb2[i].getX() <= player.getX() + 29
						&& bomb2[i].getY() + 10 >= player.getY()) {
					// if so then kill the player
					Image modiexplosionImage = explosionImage.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
					explosionIcon = new ImageIcon(modiexplosionImage);
					player.setImage(explosionIcon.getImage());
					player.dying(true);
				}
				// check if the bomb has reach the ground if so then kill it and make the first
				// set of bombs visible
				if (bomb2[i].getY() >= 570) {
					bomb2[i].die();
					bomb[i].setVisible(true);

				}
			}
			// if the alien has died and bomb is still active continue moving it till it
			// hits the floor
			else {
				bomb[i].setY(bomb[i].getY() + 1 * MainSpaceInvaders.level);
				
				if(bomb2[i].isVisible()) {
				bomb2[i].setY(bomb2[i].getY() + 1 * MainSpaceInvaders.level);
				}
				
				if (bomb[i].getY() >= 570) {
					bomb[i].die();

				}
				if (bomb2[i].getY() >= 570) {
					bomb2[i].die();
					

				}
				if(bomb2[i].isVisible()) {
					if ((bomb2[i].getX() >= player.getX() - 9 && bomb2[i].getX() <= player.getX() + 29
							&& bomb2[i].getY() + 10 >= player.getY())) {
						// if so then kill the player
						Image modiexplosionImage = explosionImage.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
						explosionIcon = new ImageIcon(modiexplosionImage);
						player.setImage(explosionIcon.getImage());
						player.dying(true);
					}}
					
					if(bomb[i].isVisible()) {
						if ((bomb[i].getX() >= player.getX() - 9 && bomb[i].getX() <= player.getX() + 29
								&& bomb[i].getY() + 10 >= player.getY())) {
							// if so then kill the player
							Image modiexplosionImage = explosionImage.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
							explosionIcon = new ImageIcon(modiexplosionImage);
							player.setImage(explosionIcon.getImage());
							player.dying(true);
						}}
			}

			
			

		}

	}

	// game cycle Method
	/*
	 * Purpose: To go through the components of the game again. Pre: void, so no
	 * parameters Return: Nothing
	 */
	private void doGameCycle() {

		// call the update method to move the player, laser, alien
		update();
		// repaint to match new settings
		repaint();
		requestFocusInWindow();

	}

	// key input detector Method
	/*
	 * Purpose: To print the castle Pre: void, so no parameters Return: Nothing
	 */
	private class keys extends KeyAdapter {

		// if key is released then do key released method in the player ship class for
		// the player
		@Override
		public void keyReleased(KeyEvent e) {

			player.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// if key is pressed then do key pressed method in the player ship class for the
			// player
			player.keyPressed(e);

			// get the new cords of the player
			int x = player.getX();
			int y = player.getY();

			// get the key code
			int key = e.getKeyCode();

			// if the code matches the space event code
			if (key == KeyEvent.VK_SPACE) {

				// and the game is still one
				if (game) {

					// and the laser is not visible already
					if (!laser.isVisible()) {
						// then make another laser
						laser = new PlayerLaser(x, y);
					}

				}
			}

		}
	}

}
