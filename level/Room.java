
package lab2.level;

import java.awt.Color;
import java.util.Arrays;


public class Room { 
	
	int dx;
	int dy;
	int posX;
	int posY;
	Color color;
	boolean playerPlaced;


	
	Room northWall;
	Room southWall;
	Room eastWall;
	Room westWall;
	

	/**
	 * Room constructor gives the created room-object a height, a width and a color.
	 * */
	public Room(int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		this.playerPlaced = playerPlaced;

//		System.out.println("Room created with dimensions:");
//		System.out.println(dx + " x-dimension");
//		System.out.println(dy + " y-dimension");
//		System.out.println("And color: " + color.toString());
//		System.out.println("And this is the: " + counter + " room.");
	}
	
	//Koordinater, mitten p� sidan som "arc" ska b�rja fr�n.
	public int getNorthX() {
		return posX + dx/2;
	}
	
	public int getNorthY() {
		return posY;
	}
	
	public int getEastX() {
		return posX + dx;
	}
	
	public int getEastY() {		//	_____
		return posY + dy/2; 	//	|   |
	}							//  -----
	
	public int getWestX() {
		return posX;
	}
	
	public int getWestY() {
		return posY + dy/2;
	}
	
	public int getSouthX() {
		return posX + dx/2;
	}
	
	public int getSouthY() {
		return posY + dy;
	}
	
	public int getMiddleX() {
		return posX + dx/2;
	}
	
	public int getMiddleY() {
		return posY + dy/2;
	}

	
	public int getDx() {
		return dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	
	public int getX() {
		return posX;
	}
	
	public void setX(int x) {
		this.posX = x;
	}
	
	public int getY() {
		return posY;
	}
	
	public void setY(int y) {
		this.posY = y;
	}
	
	public Color getColor() {
		return color;
	}
	
	
	
	//Nodes are rooms, connected by corridors
	public void connectNorthTo(Room r) {
		this.northWall = r;
		System.out.println(r.getColor() + " Connected to North wall");
	}
	public void connectEastTo(Room r) {
		this.eastWall = r;
		System.out.println(r.getColor().toString() + " Connected to East wall");
	}
	public void connectSouthTo(Room r) {
		this.southWall = r;
		System.out.println(r.getColor().toString() + " Connected to South wall");
	}
	public void connectWestTo(Room r) {
		this.westWall = r;
		System.out.println(r.getColor().toString() + " Connected to West wall");
	}
}
