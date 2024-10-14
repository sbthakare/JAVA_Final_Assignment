package userinterface;

import operation.HotelManagementSystem;
import userinterface.HotelUI;

public class Main {
    public static void main(String[] args) {
        HotelManagementSystem hotel = new HotelManagementSystem();
        HotelUI ui = new HotelUI(hotel);
        ui.start();
    }
}
