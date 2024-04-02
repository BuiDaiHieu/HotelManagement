package mainmenu;

import models.Room;
import services.RoomService;

import java.util.Scanner;

public class RoomMain {

    public static RoomService service = new RoomService();
    public static Scanner scanner = new Scanner(System.in);

    public static int inputRoomNumbersToiletAndBed() {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Nhập số phòng ngủ:");
        while (true) {
            number = scanner.nextInt();
            if (number > 0 && number < 10) {
                return number;
            }
        }
    }

    public static void addNewRoom() {
        Scanner scanner = new Scanner(System.in);
        int numberOfBedrooms;
        while (true) {
            try {
                numberOfBedrooms = inputRoomNumbersToiletAndBed();
                break;
            } catch (Exception e) {
                System.out.println("bạn phải nhập số");
                UserMain.choiceRoomService();
                UserMain.choiceManagement();
            }
        }
        int numberOfBathrooms = inputRoomNumbersToiletAndBed();
        int price = 0;
        Room room = new Room(1, "Phòng trống", numberOfBedrooms, numberOfBathrooms, price);
        service.add(room);
        service.printList();
        UserMain.choiceRoomService();
        UserMain.choiceManagement();
    }

}
