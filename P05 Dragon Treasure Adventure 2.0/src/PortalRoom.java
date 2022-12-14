import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class PortalRoom extends Room{
    private Random randGen; //random number generator for location picking
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
    private static final String TELEPORT_MESSAGE = "The space distortion teleported you to another room!\n";
    private static PImage portalImage; //image of a portal to be shown in all portal rooms

    PortalRoom(int ID, String description, processing.core.PImage image) {
        super(ID, description, image);
    }

    public static String getPortalWarning(){
        return PORTAL_WARNING;
    }

    public static String getTeleportMessage(){
        return TELEPORT_MESSAGE;
    }

    public Room getTeleportLocation(){
        Room room1 = new Room(1, "", null);
        return room1.getAdjacentRooms().get(randGen.nextInt(room1.getAdjacentRooms().size()));
    }

    @Override
    public void draw(){
        processing.image(this.portalImage, 0, 0);
        processing.fill(7028);
        processing.rect(0, 500, 800, 600);
        processing.fill(0);
        processing.text(this.getDescription(), 300, 525);
    }

    public static void setPortalImage(PImage image){
        portalImage = image;
    }

}
