package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {
	
//	Room roomBlue = new Room(5, 5, Color.blue);
//	Room roomBlack = new Room(10, 10, Color.black);
//	Room roomCyan = new Room(6, 6, Color.cyan);
	
//	Level testLvl = new Level();
//	
	Room r1 = new Room(50,50,Color.blue); 			
	Room r2 = new Room(100,100,Color.yellow);		
	Room r3 = new Room(50,100,Color.magenta);
	//TEST
//	Room r1 = new Room(200,100,Color.blue);
//	Room r2 = new Room(100,60,Color.red);
//	Room r3 = new Room(70,30,Color.green);
	Room r4 = new Room(170,60,Color.yellow);
	Room r5 = new Room(100,100,Color.white);
//	Room r6 = new Room(40,200,Color.gray);
//	Room r7 = new Room(270,160,Color.pink);
//	Room r8 = new Room(120,70,Color.magenta);
//	Room r9 = new Room(110,120,Color.orange);
	            
	Level testLevel = new Level();
	            

	//deklarerar metod
	LevelGUI lvlGUI = new LevelGUI(testLevel, "overlap test");
	


	public void run() {
		
		//k�r metod
//		System.out.println(testLvl.place(roomBlue, 150, 150));
//		testLevel.place(roomBlack, 50, 40);
//		System.out.println(roomCyan);
//		System.out.println(testLvl.place(roomBlue, 10, 10));
//		System.out.println(testLvl.place(roomBlue, 10, 10));
		
		//TEST
//		testLevel.place(r1,50,40);
//		testLevel.place(r2,30,25);
//		testLevel.place(r3,210,20);
//		testLevel.place(r4,230,100);
//		testLevel.place(r5,20,80);
//		testLevel.place(r6,90,10);
//		testLevel.place(r7,20,20);
//		testLevel.place(r8,80,50);
//		testLevel.place(r9,130,100);
//		
		testLevel.place(r1, 5, 5); 				
		testLevel.place(r2, 100, 100);			
		testLevel.place(r3, 250, 250);
//		
		r1.connectNorthTo(r2);
		r2.connectSouthTo(r3);
		r3.connectNorthTo(r1);
//		r4.connectNorthTo(r5);
		

		


		
		
		
	}

}