package services;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Management<User> {

    static List<User> userList = new ArrayList<>();

    static {
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("Hieu Bui");
        user1.setPassword("123456");
        user1.setRole("Admin");
        userList.add(user1);
    }

    public static User user;

    @Override
    public User findById(long id) {
        for (User value : userList) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }

    @Override
    public void printList() {
        System.out.printf("%-16s%-26s%-26s%n", "Id:", "Username:", "Role:");
        for (User value : userList) {
            System.out.println(value);
        }
    }

    @Override
    public void updateById(long id, User user) {
        for (User value : userList) {
            if (value.getId() == id) {
                value.setPassword(user.getPassword());
                break;
            }
        }
    }

    @Override
    public void add(User user) {
        user.setId(userList.size() + 1);
        user.setRole("User");
        userList.add(user);
    }

    @Override
    public void delete(long id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.remove(i);
                break;
            }
        }
    }

    public boolean checkLogin(String username, String password) {
        for (User value : userList) {
            if (value.getUserName().equals(username) && value.getPassword().equals(password)) {
                user = value;
                return true;
            }
        }
        return false;
    }
}
