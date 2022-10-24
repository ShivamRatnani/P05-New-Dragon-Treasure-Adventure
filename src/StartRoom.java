import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class StartRoom extends Room {
    public StartRoom(int ID, PImage image){
        super(ID, "You find yourself in the entrance to a cave holding treasure.", image);
    }


}
