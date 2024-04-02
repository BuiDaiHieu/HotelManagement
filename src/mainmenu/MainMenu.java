package mainmenu;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.println("0. Thoát chương trình");
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
                    System.out.println("không có lựa chọn này mời nhập lại");
                }
            }
        }
    }
}
