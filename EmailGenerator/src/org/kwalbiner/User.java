package org.kwalbiner;

import java.util.HashMap;

/**
 * Created by Krzysiek on 14.10.2018.
 */
public class User {

    private static String domain = "example.com";
    private static HashMap<String, User> userList = new HashMap<>();
    private String name;
    private String surname;
    private String email;
    private String userName;
    private int id = 0;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        userName = generateNewEmail(name + "." + surname).toLowerCase();
        email = userName + "@" + domain;
        saveUser(this);

    }

    private static void saveUser(User user) {
        userList.put(user.userName, user);
    }

    public static HashMap<String, User> getUserList() {
        return userList;
    }

    private String generateNewEmail(String mailName) {
        if (id == 0) {
            if (!userList.containsKey(mailName))
                return mailName;
            else {
                ++id;
                return generateNewEmail(mailName);
            }
        } else {
            if (!userList.containsKey(mailName + id))
                return mailName + id;
            else {
                ++id;
                return generateNewEmail(mailName);
            }

        }
    }


    public static String createNewUser(String name, String surname) {
        User user = new User(name, surname);
        return user.getEMail();
    }

    public String getEMail() {
        return email;
    }

    public static String printUsers() {
        if (userList.isEmpty()) {
            return "Lista jest pusta!";
        }
        StringBuilder sb = new StringBuilder("----\n");
        for (User u : userList.values()) {
            sb.append(u.userName);
            sb.append(" ; ");
            sb.append(u.name);
            sb.append(" ; ");
            sb.append(u.surname);
            sb.append(" ; ");
            sb.append(u.email);
            sb.append("\n");
        }
        sb.append("----");
        return sb.toString();
    }

    public String getUserName() {
        return userName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
