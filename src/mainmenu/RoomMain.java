package mainmenu;

import models.Room;
import services.RoomService;

import java.util.Scanner;

public class RoomMain {

    public static RoomService service = new RoomService();
    public static Scanner scanner = new Scanner(System.in);

    public static int inputRoomNumbers() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("Please enter a number between 1 and 9 (press 0 to go back): ");
            try {
                number = scanner.nextInt();
                if (number == 0) {
                    System.out.println("Going back to menu...");
                    return -1; // Special value to indicate going back to the menu
                } else if (number > 0 && number < 10) {
                    return number; // Return the valid number
                } else {
                    System.out.println("Room numbers must be between 1 and 9. Please try again");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    public static long inputPrice() {
        Scanner scanner = new Scanner(System.in);
        long number;
        while (true) {
            System.out.println("Please enter a price (press 0 to go back): ");
            try {
                number = scanner.nextLong();
                if (number == 0) {
                    System.out.println("Going back to menu...");
                    return -1; // Special value to indicate going back to the menu
                } else {
                    return number; // Return the valid number
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.next(); // Consume invalid input
            }
        }
    }

    public static String inputStatus() {
        Scanner scanner = new Scanner(System.in);
        String status;
        while (true) {
            System.out.println("Please enter room status (press 0 to go back): ");
            try {
                status = scanner.nextLine();
                if (status.equals("0")) {
                    System.out.println("Going back to menu...");
                    return "-1";
                } else {
                    return status; // Return the valid number
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid status");
                scanner.next(); // Consume invalid input
            }
        }
    }

    public static void menu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Add room");
            System.out.println("2. Delete room");
            System.out.println("3. Update room");
            System.out.println("4. See room list");
            System.out.println("5. Back");
            System.out.println("0. Quit");
            switch (scanner.nextInt()) {
                case 1: {
                    addNewRoom();
                    break;
                }
                case 2: {
                    deleteRoom();
                    break;
                }
                case 3: {
                    updateRoom();
                    break;
                }
                case 4: {
                    service.printList();
                    break;
                }
                case 5: {
                    MainMenu.chooseService();
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Please enter a valid option (0, 1, 2, 3, 4, 5)");
                }
            }
        }
    }

    public static void updateRoom() {
        System.out.println("Enter the room ID to update: ");
        long roomId = scanner.nextLong();
        Room roomToUpdate = service.findById(roomId);

        if (roomToUpdate == null) {
            System.out.println("Room with ID " + roomId + " not found.");
            return;
        }

        System.out.println("Room found. Please enter updated information (press 0 to skip)");

        System.out.println("Enter new number of bedrooms (current: " + roomToUpdate.getNumberOfBedrooms() + "): ");
        long newBedrooms = scanner.nextLong();
        if (newBedrooms != 0) {
            roomToUpdate.setNumberOfBedrooms(newBedrooms);
        }

        System.out.println("Enter new number of bathrooms (current: " + roomToUpdate.getNumberOfBathrooms() + "): ");
        long newBathrooms = scanner.nextLong();
        if (newBathrooms != 0) {
            roomToUpdate.setNumberOfBathrooms(newBathrooms);
        }

        System.out.println("Enter new status (current: " + roomToUpdate.getStatus() + "): ");
        String newStatus = scanner.next();
        if (!newStatus.equals("0")) {
            roomToUpdate.setStatus(newStatus);
        }

        System.out.println("Enter new price (current: " + roomToUpdate.getPrice() + "): ");
        long newPrice = scanner.nextLong();
        if (newPrice != 0) {
            roomToUpdate.setPrice(newPrice);
        }

        System.out.println("Room updated successfully!");
        service.printList();
    }

    public static void deleteRoom() {
        Scanner scanner = new Scanner(System.in);
        long roomId = 0; // Initialize roomId
        boolean isValidInput = false; // Flag to indicate whether input is valid

        while (!isValidInput) {
            System.out.println("Please give room ID to delete (press 0 to go back): ");
            try {
                roomId = scanner.nextLong(); // Retrieve the room ID from user input
                if (roomId == 0) {
                    // User chose to go back
                    System.out.println("Going back...");
                    break;
                }
                isValidInput = true; // Set the checker to true if input is valid
            } catch (Exception e) {
                System.out.println("Please give a valid number");
                scanner.next();
            }
        }

        service.delete(roomId);
        service.printList();
    }

    public static void addNewRoom() {
        System.out.println("Awaiting bedroom numbers ");
        int numberOfBedrooms = inputRoomNumbers();
        if (numberOfBedrooms == -1) {
            menu();
        }

        System.out.println("Awaiting bathroom numbers ");
        int numberOfBathrooms = inputRoomNumbers();
        if (numberOfBathrooms == -1) {
            menu();
        }

        long price = inputPrice();
        if (price == -1) {
            menu();
        }

        String status = inputStatus();
        if (status.equals("-1")) {
            menu();
        }
        Room room = new Room(1, status, numberOfBedrooms, numberOfBathrooms, price);
        service.add(room);
        service.printList();
    }

}
