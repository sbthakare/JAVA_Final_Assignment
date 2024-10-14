package operation;

import entity.Customer;
import entity.Room;
import entity.Booking;

import java.util.ArrayList;
import java.util.List;

public class HotelManagementSystem {
    private List<Room> rooms;
    private List<Customer> customers;

    public HotelManagementSystem() {
        this.rooms = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Adds a room to the hotel
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Adds a customer to the system
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Books a room for a customer
    public void bookRoom(String customerName, int roomNumber) throws Exception {
        Customer customer = findCustomer(customerName);
        Room room = findRoom(roomNumber);

        if (customer != null && room != null) {
            if (room.isAvailable()) {
                room.bookRoom();
                Booking booking = new Booking(customerName, roomNumber);
                booking.generateBooking();
            } else {
                throw new Exception("Room is not available.");
            }
        } else {
            throw new Exception("Invalid customer or room.");
        }
    }

    private Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }

    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
