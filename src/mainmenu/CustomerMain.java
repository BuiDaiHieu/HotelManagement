package mainmenu;

import models.Customer;
import models.Room;
import services.CustomerService;

import java.util.Scanner;

public class CustomerMain {
    public static CustomerService customerService = new CustomerService();

    public static void menu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Add customer");
            System.out.println("2. Delete customer");
            System.out.println("3. Update customer");
            System.out.println("4. See customer list");
            System.out.println("5. Back");
            System.out.println("0. Quit");
            switch (scanner.nextInt()) {
                case 1: {
                    addCustomer();
                    break;
                }
                case 2: {
                    deleteCustomer();
                    break;
                }
                case 3: {
                    updateCustomer();
                    break;
                }
                case 4: {
                    customerService.printList();
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

    public static void addCustomer() {
        String citizenID = inputCitizenID();
        if (citizenID.isEmpty()) {
            menu();
        }

        int age = inputAge();
        if (age == -1) {
            menu();
        }

        String phoneNumber = inputPhoneNumber();
        if (phoneNumber.isEmpty()) {
            menu();
        }

        Customer customer = new Customer(citizenID, age, phoneNumber);
        customerService.add(customer);
        customerService.printList();
    }

    public static String inputCitizenID() {
        Scanner scanner = new Scanner(System.in);
        String citizenId;
        while (true) {
            System.out.println("Please enter citizen ID (press Enter to go back): ");
            try {
                citizenId = scanner.nextLine();
                // Return the valid number
                if (citizenId.isEmpty()) {
                    System.out.println("Going back to menu...");
                }
                return citizenId; // Special value to indicate going back to the menu
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }
    }

    public static int inputAge() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("Please enter age (press Enter to go back): ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Going back to menu...");
                    return -1; // Special value to indicate going back to the menu
                } else {
                    number = Integer.parseInt(input);
                    return number; // Return the valid number
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
    }

    public static String inputPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        while (true) {
            System.out.println("Please enter phone number (press Enter to go back): ");
            try {
                phoneNumber = scanner.nextLine();
                // Return the valid number
                if (phoneNumber.isEmpty()) {
                    System.out.println("Going back to menu...");
                }
                return phoneNumber; // Special value to indicate going back to the menu
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }
    }

    public static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the customer ID to update: ");
        long roomId = scanner.nextLong();
        scanner.nextLine();
        Customer customerToUpdate = customerService.findById(roomId);

        if (customerToUpdate == null) {
            System.out.println("Customer with ID " + roomId + " not found.");
            return;
        }

        System.out.println("Customer found. Please enter updated information (press Enter to skip)");

        String newCitizenId;
        while (true) {
            System.out.println("Enter new citizen ID (current: " + customerToUpdate.getCitizenIdentificationCard() + "): ");
            try {
                newCitizenId = scanner.nextLine();
                // Return the valid number
                if (newCitizenId.isEmpty()) {
                    break;
                }
                customerToUpdate.setCitizenIdentificationCard(newCitizenId);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }

        int newAge;
        while (true) {
            System.out.println("Enter new age (current: " + customerToUpdate.getAge() + "): ");
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    break;
                }
                newAge = Integer.parseInt(input);
                customerToUpdate.setAge(newAge);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }

        String newPhoneNumber;
        while (true) {
            System.out.println("Enter new phone number (current: " + customerToUpdate.getPhoneNumber() + "): ");
            try {
                newPhoneNumber = scanner.nextLine();
                // Return the valid number
                if (newPhoneNumber.isEmpty()) {
                    break;
                }
                customerToUpdate.setPhoneNumber(newPhoneNumber);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }

        System.out.println("Customer updated successfully!");
        customerService.printList();
    }

    public static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        long customerId = 0; // Initialize roomId
        boolean isValidInput = false; // Flag to indicate whether input is valid

        while (!isValidInput) {
            System.out.println("Please give customer ID to delete (press 0 to go back): ");
            try {
                customerId = scanner.nextLong(); // Retrieve the room ID from user input
                if (customerId == 0) {
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

        customerService.delete(customerId);
        customerService.printList();
    }
}
