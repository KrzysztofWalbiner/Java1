package org.kwalbiner;

import java.util.HashMap;

/**
 * Created by Krzysiek on 14.10.2018.
 */
public class User {

    static String domain = "example.com";
    static HashMap<String, User> userList = new HashMap<>();
    String name;
    String surname;
    String email;
    String userName;
    int id = 0;

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

    private String generateNewEmail(String mailName) {
        if (id == 0) {
            if (!userList.containsKey(mailName))
                return mailName;
            else {
                ++id;
                return generateNewEmail(mailName);
            }
        } else {
            if (!userList.containsKey(mailName+id))
                return mailName+id;
            else{
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
        if(userList.isEmpty()){
            return "Lista jest pusta!";
        }
        StringBuilder sb = new StringBuilder("----\n");
        for(User u : userList.values()){
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
}
