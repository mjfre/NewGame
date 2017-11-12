import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class NewGame extends JComponent implements ActionListener, Runnable, MouseListener, KeyListener {
	static int x = 0;
	static int y = 0;
	static boolean moveLeft = false;
	static boolean moveRight = false;
	static boolean moveUp = false;
	static boolean moveDown = false;
	private int widthOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private int heightOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private JFrame mainGameWindow = new JFrame("NewGame");// Makes window with title "NewGame"
	private Rectangle2D.Double floor = new Rectangle2D.Double(x, 10, 100, 100);
	private Timer paintTicker = new Timer(20, this); // Ticks every 20 milliseconds (50 times per second); calls on
														// actionPerformed() when it ticks.

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new NewGame());
	}

	public void run() {
		mainGameWindow.setTitle("NewGame");
		mainGameWindow.setSize(widthOfScreen, heightOfScreen);
		mainGameWindow.add(this);// Adds the paint method
		mainGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGameWindow.addMouseListener(this);
		mainGameWindow.addKeyListener(this);
		mainGameWindow.setVisible(true);
		paintTicker.start();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.fill(floor);
		g2.setColor(Color.red);
		g2.draw(floor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (moveLeft == true) {
			x -= 10;
		}
		if (moveRight == true) {
			x += 10;
		}
		if (moveUp == true) {
			y -= 10;
		}
		if (moveDown == true) {
			y += 10;
		}
		floor.setRect(x, y, 100, 100);
		repaint(); // Calls on the paint() method.
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		if ((e.getX() > x && e.getX() < x + 100) && (e.getY() > 10 && e.getY() < 110)) {
			JOptionPane.showMessageDialog(null, "You caught it!");
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x += 1;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_A) {
			moveLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			moveDown = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			moveUp = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			moveRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_A) {
			moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			moveDown = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			moveUp = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			moveRight = false;
		}
	}
}
