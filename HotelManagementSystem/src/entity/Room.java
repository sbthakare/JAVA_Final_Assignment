package entity;

public class Room {
    private int roomNumber;
    private boolean available;

    // Constructor to create a room
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.available = true;
    }

    // Returns the room number
    public int getRoomNumber() {
        return roomNumber;
    }

    // Checks if the room is available
    public boolean isAvailable() {
        return available;
    }

    // Marks the room as booked
    public void bookRoom() {
        this.available = false;
    }
}
