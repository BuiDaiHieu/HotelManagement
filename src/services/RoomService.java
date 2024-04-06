package services;

import models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomService implements Management<Room> {

    static List<Room> roomList = new ArrayList<>();

    @Override
    public Room findById(long id) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == id) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void printList() {
        System.out.println("-----------------------------------------");
        System.out.printf("%-16s%-26s%-26s%-26s%-26s%n", "Room Number", "Status", "Number Of Bedrooms", "Number Of Bathrooms", "Price");
        for (Room room : roomList) {
            System.out.println(room);
        }
        System.out.println("-----------------------------------------");
    }

    @Override
    public void updateById(long id, Room room) {
        for (Room value : roomList) {
            if (value.getRoomNumber() == id) {
                value.setStatus(room.getStatus());
                break;
            }
        }
    }

    @Override
    public void add(Room room) {
        room.setRoomNumber(roomList.size() + 1);
        roomList.add(room);
    }

    @Override
    public void delete(long id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomNumber() == id) {
                roomList.remove(i);
                System.out.println("Room deleted");
                return;
            }
        }
        System.out.println("Cannot find the room with the given ID");
    }
}
