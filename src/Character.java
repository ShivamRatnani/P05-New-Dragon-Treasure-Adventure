import java.util.ArrayList;

public class Character {
    private Room currentRoom; //current room the character is in
    private String label; //a label giving a basic description of the character

    Character(Room currentRoom, String label) throws IllegalArgumentException {
        this.currentRoom = currentRoom;
        this.label = label;
        if (currentRoom == null)
            throw new IllegalArgumentException("Room is null!");

    }

    private Room getCurrentRoom() {
        return currentRoom;
    }

    private String getLabel() {
        return label;
    }


    public ArrayList<Room> getAdjacentRooms() {
        return currentRoom.getAdjacentRooms();
    }

    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
    }



}
