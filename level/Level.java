
package lab2.level;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Level extends Observable {

//	private int [] roomCoordArray;
	// in theory, a infinite long list
	private List<Room> placedRooms = new ArrayList<>(); // Needs to be package visible
	private int x;
	private int y;
	boolean doNotPlaceRoom = false;
	private Color color;


	public boolean place(Room r, int x, int y) {

		/*
		 * rum 1 = [x1, y1, dx1, dy1] rum 2= [x2, y2, dx2, dy2]
		 */

		// Ska vi returnera true eller false, returnerar vi false.
		// Returnera om det är bra eller dåligt, då true om det gick bra att lägga till
		// i lista
		// och false om det inte läggs i en lista.
		if (doNotPlaceRoom) {
			return false;
		}

		// Variable for int collision
		int coll = 0;

		// Iterate formulated differently
		// If it finds any collision it will register on the int variable coll.
		for (Room room : placedRooms) {
			if (x < room.getX() + room.dx && room.getX() < x + r.dx && (-y - r.dy) < room.getY()
					&& (room.getY() - room.dy) < y) {
				coll++;
			}
		}

		// Iterates through all the rooms inside the ArrayList and checks for
		// collisions.
		// If it finds any collision it will register on the int variable coll.
//		for (Room room : placedRooms) {
//			if (x < (room.getX() + room.dx) && room.getX() < (x + r.dx) && y < (room.getY() + room.dy)
//					&& room.dy < (y + r.dy)) {
//				coll++;
//			}
//		}

		// Checks collisions of the int variable coll.
		// If the collisions is 0, the if-statement will set x and y.
		if (coll == 0) {
			r.setX(x); // Adds x to object r.
			r.setY(y); // Adds x to object r.
			placedRooms.add(r); // adds the room to the ArrayList.
			return true;
		} else {
			// If it collides, it will return false;.
			return false;
		}

	}

	// A getter so that other classes inside the package can reach the ArrayList.
	public List<Room> getRooms() {
		return placedRooms;
	}

	public void firstLocation(Room r) {

		doNotPlaceRoom = true;
		r.playerPlaced = true;
		setChanged();
		notifyObservers();

	}

}
