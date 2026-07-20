import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean booked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();

    public static void initializeRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    public static void displayRooms() {
        System.out.println("\n===== ROOM LIST =====");
        for (Room room : rooms) {
            System.out.println("Room No: " + room.roomNumber +
                    " | Category: " + room.category +
                    " | Status: " + (room.booked ? "Booked" : "Available"));
        }
    }

    public static void bookRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                if (!room.booked) {
                    room.booked = true;
                    System.out.println("Room booked successfully!");
                } else {
                    System.out.println("Room is already booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public static void cancelBooking(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                if (room.booked) {
                    room.booked = false;
                    System.out.println("Booking cancelled successfully.");
                } else {
                    System.out.println("Room is not booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        initializeRooms();

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayRooms();
                    break;

                case 2:
                    System.out.print("Enter Room Number to Book: ");
                    int bookRoomNo = sc.nextInt();
                    bookRoom(bookRoomNo);
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel Booking: ");
                    int cancelRoomNo = sc.nextInt();
                    cancelBooking(cancelRoomNo);
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}