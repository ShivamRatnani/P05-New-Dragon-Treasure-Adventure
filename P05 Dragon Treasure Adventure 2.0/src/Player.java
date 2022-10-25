import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends Character implements Moveable {
    private boolean hasKey;

    Player(Room currentRoom) throws IllegalArgumentException {
        super(currentRoom, "PLAYER");
        this.hasKey = false;

        if (!(currentRoom instanceof StartRoom))
            throw new IllegalArgumentException("The current room is not the start room!");

    }

    public boolean hasKey() {
        return hasKey;
    }

    public void obtainKey() {
        hasKey = true;
    }

    @Override public boolean changeRoom(Room destination) {
        if (super.getAdjacentRooms().contains(destination)) {
            super.setCurrentRoom(destination);
            return true;
        }

        return false;
    }

    @Override public boolean canMoveTo(Room destination) {
        if (super.getAdjacentRooms().contains(destination))
            return true;
        return false;
    }

    //TODO
    //Check if isTreasureNearby() is needed too and if character needs to be moved to the teleportation room
    public boolean teleport() {
        if (isPortalNearby() || isTreasureNearby()) return true;
        return false;
    }

    public boolean isDragonNearby(Dragon d) {
        for (int i = 0; i < super.getAdjacentRooms().size(); i++) {
            if (d.canMoveTo(super.getAdjacentRooms().get(i))) return true;
        }
        return false;
    }


    /**
     * Determines whether or not a portal room is in a nearby room.
     * @return true if a portal room is nearby, false otherwise
     */
    public boolean isPortalNearby()
    {
        ArrayList<Room> adjRooms = super.getAdjacentRooms();
        for (Room r : adjRooms) {
            if (r instanceof PortalRoom)
                return true;
        }

        return false;
    }

    /**
     * Determines whether or not the treasure room is in a nearby room.
     * @return true if the treasure room is nearby, false otherwise
     */
    public boolean isTreasureNearby()
    {
        ArrayList<Room> adjRooms = super.getAdjacentRooms();
        for(Room r: adjRooms) {
            if(r instanceof TreasureRoom)
                return true;
        }

        return false;
    }
}

