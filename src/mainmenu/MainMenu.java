package mainmenu;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Quit");
            switch (scanner.nextInt()) {
                case 1: {
                    UserMain.login();
                    break;
                }
                case 2: {
                    UserMain.register();
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Please enter a valid option (0, 1, 2)");
                }
            }
        }
    }

    public static void chooseService() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select service");
            System.out.println("1. Room management");
            System.out.println("2. Customer management");
            System.out.println("3. Back to login");
            System.out.println("4. Go to register");
            System.out.println("0, Quit");
            switch (scanner.nextInt()) {
                case 1: {
                    RoomMain.menu();
                    break;
                }
                case 2: {
                    CustomerMain.menu();
                    break;
                }
                case 3: {
                    UserMain.login();
                }
                case 4: {
                    UserMain.register();
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Please enter valid choice (0, 1, 2, 3, 4)");
                }
            }
        }
    }
}
