package userinterface;

import entity.Customer;
import entity.Room;
import operation.HotelManagementSystem;

import java.util.Scanner;

public class HotelUI {
    private HotelManagementSystem hotel;

    public HotelUI(HotelManagementSystem hotel) {
        this.hotel = hotel;
    }

    public void displayMenu() {
        System.out.println("Welcome to the Hotel Management System");
        System.out.println("1. Add Room");
        System.out.println("2. Add Customer");
        System.out.println("3. Book Room");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    hotel.addRoom(new Room(roomNumber));
                    System.out.println("Room added successfully!");
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    hotel.addCustomer(new Customer(customerName));
                    System.out.println("Customer added successfully!");
                    break;
                case 3:
                    System.out.print("Enter customer name for booking: ");
                    String bookingCustomerName = scanner.nextLine();
                    System.out.print("Enter room number to book: ");
                    int bookingRoomNumber = scanner.nextInt();
                    try {
                        hotel.bookRoom(bookingCustomerName, bookingRoomNumber);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
