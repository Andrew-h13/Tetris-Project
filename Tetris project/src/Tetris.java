/**
 * Create and control the game Tetris.
 * 
 *
 *
 */
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tetris extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;

	/**
	 * Sets up the parts for the Tetris game, display and user control
	 */
	public Tetris() {
		game = new Game(this);
		JFrame f = new JFrame("The Tetris Game");
		f.add(this);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(400, 550);
		f.setVisible(true);
		EventController ec = new EventController(game);
		f.addKeyListener(ec);
		setBackground(Color.YELLOW);
		sound music = new sound();
		music.playSound("tet.waw");
	}

	/**
	 * Updates the display
	 */
	public void update() {
		repaint();
	}

	/**
	 * Paint the current state of the game
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.draw(g);
		if (game.isGameOver()) {
			g.setFont(new Font("Palatino", Font.BOLD, 40));
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 80, 300);
		}
	}

	public static void main(String[] args) {
		new Tetris();
	}

}
