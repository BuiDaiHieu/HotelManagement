package mainmenu;

import com.sun.tools.javac.Main;
import models.User;
import services.UserService;

import java.util.Scanner;

public class UserMain {

    public static UserService userService = new UserService();

    public static Scanner scanner = new Scanner(System.in);

    public static void login() {
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        boolean check = userService.checkLogin(username, password);
        if (check) {
            System.out.println("Log in successfully");
            System.out.println("Greetings, " + UserService.user.getUserName());
            try {
                MainMenu.chooseService();
            } catch (Exception e) {
                MainMenu.chooseService();
            }
        } else {
            System.out.println("Incorrect username or password. Directing to main menu");
        }
    }

    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        User user = new User(username, password);
        userService.add(user);
        userService.printList();
    }
}
