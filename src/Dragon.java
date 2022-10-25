import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class Dragon extends Character implements Moveable {
    private Random randGen; //random num generator used for moving
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
    private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire breathing dragon!\n";

    Dragon(Room currentRoom) throws IllegalArgumentException {
        super(currentRoom, "DRAGON");

        if (!(currentRoom instanceof TreasureRoom))
            throw new IllegalArgumentException("The current room is not the treasure room!");

    }

    @Override
    public boolean changeRoom(Room destination){
        if (super.getAdjacentRooms().contains(destination)) {
            super.setCurrentRoom(destination);
            return true;
        }

        return false;
    }

    @Override
    public boolean canMoveTo(Room destination){
        if (super.getAdjacentRooms().contains(destination))
            return true;
        return false;
    }

    public Room pickRoom(){
        randGen = new Random();
        int randNum = randGen.nextInt(super.getAdjacentRooms().size());
        return super.getAdjacentRooms().get(randNum);
    }

    public static String getDragonWarning(){
        return DRAGON_WARNING;
    }

    public static String getDragonEncounter(){
        return DRAGON_ENCOUNTER;
    }




}
