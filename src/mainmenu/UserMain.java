package mainmenu;

import models.User;
import services.UserService;

import java.util.Scanner;

public class UserMain {

    public static UserService userService = new UserService();

    public static Scanner scanner = new Scanner(System.in);

    public static void login() {
        while (true) {
            System.out.println("Tên đăng nhập:");
            String username = scanner.nextLine();
            System.out.println("Mật khẩu:");
            String password = scanner.nextLine();
            boolean check = userService.checkLogin(username, password);
            if (check) {
                System.out.println("Đăng nhập thành công");
                System.out.println("Xin chào: " + UserService.user.getUserName());
                try {
                    choiceRoomService();
                    choiceManagement();
                    break;
                } catch (Exception e) {
                    choiceRoomService();
                    choiceManagement();
                }
            } else {
                System.out.println("Tên đăng nhập hoặc mật khẩu không đúng");
            }
        }
    }

    public static void choiceRoomService() {
        System.out.println("Mời chọn");
        System.out.println("1. Quản lý phòng");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Quay lại đăng nhập");
        System.out.println("4. Quay lại đăng kí");
    }

    public static void choiceManagement() {
        Scanner scanner1 = new Scanner(System.in);
        int choice = scanner1.nextInt();
        switch (choice) {
            case 1: {
                RoomMain.addNewRoom();
                break;
            }
            case 2: {

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
                System.out.println("Có lỗi xảy ra");
            }
        }
    }

    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tên đăng nhập:");
        String username = scanner.nextLine();
        System.out.println("Mật khẩu:");
        String password = scanner.nextLine();
        User user = new User(username, password);
        userService.add(user);
        userService.printList();
    }
}
