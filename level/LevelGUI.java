
package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import org.graalvm.compiler.nodes.calc.IntegerTestNode;

public class LevelGUI implements Observer {

	private Level lv;
	private Display d;

	public LevelGUI(Level level, String name) {

		this.lv = level;

		lv.addObserver(this); // Funkar detta f�r att man ropar p� sig sj�lv?
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO: You should change 200 to a value
		// depending on the size of the level
		d = new Display(lv, 400, 400);

		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0, 0);
		frame.setVisible(true);
	}

	public void update(Observable arg0, Object arg1) {
		// ska finnas en repaint(); h�r.
		d.repaint(); // �r detta korrekt? Anv�nder d som �r ett Display objekt.
	}

	private class Display extends JPanel {

		public Display(Level fp, int x, int y) {

			addKeyListener(new Listener());

			setBackground(Color.GREEN);
			setPreferredSize(new Dimension(x + 20, y + 20));
			setFocusable(true);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Room room : lv.getRooms()) {

				g.setColor(room.getColor());
				g.drawRect(room.getX(), room.getY(), room.getDx(), room.getDy());
				g.fillRect(room.getX(), room.getY(), room.getDx(), room.getDy());
				drawArcs(room, g);// Ska rita upp alla Arcs!

			}
		}

		// j�mf�ra vart rummen �r
		public int calculateStartAngle(int xWall1, int xCenter2, int yWall1, int yCenter2) {
			float distX = xCenter2 - xWall1;
			float distY = yCenter2 - yWall1;
			float teta = (float)Math.atan2(distY, distX); // oriented angle
			float hyp = (float)Math.sqrt(distX * distX + distY * distY);
			float radius = hyp / 2;
			float x0 = xWall1 + (distX / 2);
			float y0 = yWall1 + (distY / 2);
			return (int) (180 / Math.PI * Math.atan2(yWall1 - y0, xWall1 - x0));
		}

		public int calculateEndAngle(int xWall1, int xCenter2, int yWall1, int yCenter2) {
			float distX = xCenter2 - xWall1;
			float distY = yCenter2 - yWall1;
			float x0 = xWall1 + (distX / 2);
			float y0 = yWall1 + (distY / 2);
			return (int) (180 / Math.PI * Math.atan2(yCenter2 - y0, xCenter2 - x0));
		}

		public void drawPoint(Graphics g, Color brush, float x, float y){
			g.setColor(Color.black);
        	g.drawLine((int)x, (int)(x-1), (int)y, (int)(y-1));
    	}

		// Ska rita Arcs f�r varje sida av rummet f�r att undvika upprepnningskod
		public void drawArcs(Room r, Graphics g) {
			// dx1 = 50, dy1 = 50 ;
			// dx2= 100, dy2=100
			// x1 = 5, y2= 5
			// x2=100, y2=100
			if (r.northWall != null) {
				g.setColor(r.color);
				drawPoint(g, r.color, r.getNorthX(), r.getNorthY());
				g.drawArc(r.getNorthX(), r.getNorthY(), r.getDx(), r.getDy(),
						calculateStartAngle(r.getNorthX(), r.northWall.getMiddleX(), r.getNorthY(),
								r.northWall.getMiddleY()),
						calculateEndAngle(r.getNorthX(), r.northWall.getMiddleX(), r.getNorthY(),
								r.northWall.getMiddleY()));
			}

			if (r.southWall != null) {
				g.setColor(r.color);
				drawPoint(g, r.color, r.getSouthX(), r.getSouthX());
				g.drawArc(r.getSouthX(), r.getSouthY(), r.getDx(), r.getDy(),
						calculateStartAngle(r.getSouthX(), r.southWall.getMiddleX(), r.getSouthY(),
								r.southWall.getMiddleY()),
						calculateEndAngle(r.getSouthX(), r.southWall.getMiddleX(), r.getSouthY(),
								r.southWall.getMiddleY()));
			}

			if (r.eastWall != null) {
				g.setColor(r.color);
				drawPoint(g, r.color, r.getEastY(), r.getEastY());
				g.drawArc(r.getEastX(), r.getEastY(), r.getDx(), r.getDy(),
						calculateStartAngle(r.getEastX(), r.eastWall.getMiddleX(), r.getEastY(),
								r.eastWall.getMiddleY()),
						calculateEndAngle(r.getEastX(), r.eastWall.getMiddleX(), r.getEastY(),
								r.eastWall.getMiddleY()));
			}

			if (r.westWall != null) {
				g.setColor(r.color);
				drawPoint(g, r.color, r.getWestX(), r.getWestX());
				g.drawArc(r.getWestX(), r.getWestY(), r.getDx(), r.getDy(),
						calculateStartAngle(r.getWestX(), r.westWall.getMiddleX(), r.getWestY(),
								r.westWall.getMiddleY()),
						calculateEndAngle(r.getWestX(), r.westWall.getMiddleX(), r.getWestY(),
								r.westWall.getMiddleY()));
			}

			// Resten �r f�r east, west och south wall
			// Sedan beh�ver jag k�ra draw
		}

		private class Listener implements KeyListener {

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}

			public void keyTyped(KeyEvent event) {
			}
		}

	}

}
