import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class TreasureRoom extends Room {
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
    private static PImage treasureBackground; //the image ALWAYS used for treasure rooms

    public TreasureRoom(int ID){
        super(ID, "You find yourself in a room with a pile of treasure.", treasureBackground);
    }

    public static String getTreasureWarning(){
        return TREASURE_WARNING;
    }


    public boolean playerCanGrabTreasure(Player p){
        return p.isTreasureNearby();
    }


    public static void setTreasureBackground(PImage image){
        treasureBackground = image;
    }

}
