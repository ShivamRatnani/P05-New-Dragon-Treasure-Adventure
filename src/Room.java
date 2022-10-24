import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;
public class Room {
    private String description; //verbal description of the room
    private ArrayList<Room> adjRooms; //list of all rooms directly connect
    private final int ID; // a "unique" identifier for each room
    protected static PApplet processing; //PApplet object which the rooms will use to draw stuff to the GUI
    private PImage image; //stores the image that corresponds to the background of a room

    Room(int ID, String description, processing.core.PImage image){
        this.ID = ID;
        this.description = description;
        this.image = image;
        this.adjRooms = new ArrayList<Room>();
    }

    public void addToAdjacentRooms(Room toAdd){
        this.adjRooms.add(toAdd);
    }

    public void draw(){
        processing.image(this.image, 0, 0);
        processing.fill(7028);
        processing.rect(0, 500, 800, 600);
        processing.fill(0);
        processing.text(this.description, 300, 525);

    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Room){
            Room otherRoom = (Room) other;
            return this.ID == otherRoom.ID;
        }
        return false;
    }

    public ArrayList<Room> getAdjacentRooms(){
        return this.adjRooms;
    }

    public String getDescription(){
        return this.description;
    }

    public int getID(){
        return this.ID;
    }

    public boolean isAdjacent(Room r){
        return this.adjRooms.contains(r);
    }

    public static void setProcessing(processing.core.PApplet processing){
        Room.processing = processing;
    }

    @Override
    public String toString(){
        return this.ID + ":" + this.description + "\n Adjacent Rooms: " + this.adjRooms;
    }
}
