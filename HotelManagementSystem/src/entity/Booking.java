package entity;

public class Booking {
    private String customerName;
    private int roomNumber;

    // Constructor to create a booking
    public Booking(String customerName, int roomNumber) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
    }

    // Generates booking details
    public void generateBooking() {
        System.out.println("----- Booking Details -----");
        System.out.println("Customer: " + customerName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("---------------------------");
    }
}
