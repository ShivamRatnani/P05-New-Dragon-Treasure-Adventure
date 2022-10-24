//TODO File Header

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class DragonTreasureGame extends PApplet {
    public static void main(String[] args) {
        PApplet.main("DragonTreasureGame");
    }

    private ArrayList<Room> roomList = new ArrayList<Room>();



    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup(){
        this.getSurface().setTitle("Dragon Treasure Adventure"); // sets the title of the window
        this.imageMode(PApplet.CORNER); //Images are drawn using the x,y-coordinate
        //as the top-left corner
        this.rectMode(PApplet.CORNERS); //When drawing rectangles interprets args
        //as top-left corner and bottom-right corner respectively
        this.focused = true; // window will be active upon running program
        this.textAlign(CENTER); // sets the text alignment to center
        this.textSize(20); //sets the font size for the text


        PApplet DragonTreasureGame = new PApplet();
        Room.setProcessing(DragonTreasureGame);

        PImage image1 = this.loadImage("1.jng");
        PImage image2 = this.loadImage("2.jng");
        PImage image3 = this.loadImage("3.jng");
        PImage image4 = this.loadImage("4.jng");
        PImage image5 = this.loadImage("5.jng");
        PImage imagePortal = this.loadImage("portal.jng");
        PImage imageTreasure = this.loadImage("treasure.jng");


        Room room1 = new Room(1, "", image1);
        roomList.add(room1);// TODO Do I add room to roomList or adjRooms?
        room1.addToAdjacentRooms(room1);
        Room room2 = new Room(2, "", image2);
        room1.addToAdjacentRooms(room2);
        Room room3 = new Room(3, "", image3);
        room1.addToAdjacentRooms(room3);
        Room room4 = new Room(4, "", image4);
        room1.addToAdjacentRooms(room4);
        Room room5 = new Room(5, "", image5);
        room1.addToAdjacentRooms(room5);
        PortalRoom roomPortal = (PortalRoom) new Room(6, "", imagePortal);
        room1.addToAdjacentRooms(roomPortal);
        TreasureRoom roomTreasure = (TreasureRoom) new Room(7, "", imageTreasure);
        room1.addToAdjacentRooms(roomTreasure);

        StartRoom startRoom = new StartRoom(1, image1);
        roomList.add(startRoom); // TODO How the fuck do I do this (4.1 Checkpoint) ?

    }

    public void draw(){
        // roomList.get(1).draw();
        // TODO: figure out how to draw the rooms

        //TODO Draw treasure room

        //TODO Draw portal room

    }


}
