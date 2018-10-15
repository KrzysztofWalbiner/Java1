package org.kwalbiner;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Witaj w generatorze adresow email!");
        System.out.println("Wybierz jedna z poniższych opcji wpisując daną literę i wciskając enter.");
        System.out.println("p - drukuj liste");
        System.out.println("q - wyjdz");
        System.out.println("s - zapisz");
        System.out.println("lub wpisać imię i nazwisko(np. Jan Kowalski)");

        while (true) {
            String input;
            input = scn.nextLine();
            if (input.equalsIgnoreCase("q"))
                return;
            else if (input.equalsIgnoreCase("p")) {
                System.out.println(User.printUsers());
                continue;
            } else if (input.equalsIgnoreCase("s")) {
                saveUsers();
                continue;
            }

            String[] in = input.split(" ");
            if (in.length != 2 || input.matches(".*[[0-9]!#$%&'*+/-=?^_`{|}~@.[/]].*")) {
                System.out.println("Dane wejściowe niepoprawne! Imie i nazwisko nie może zawierać znaków specjalnych lub cyfr!");
                continue;
            }
            System.out.println(User.createNewUser(in[0], in[1]));
        }
    }

    private static void saveUsers() {
        DateFormat frt = new SimpleDateFormat("yyyy_MM_dd hh-mm-ss");
        File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
        File csv = new File(jarDir.getAbsolutePath()+File.separator+"EmailGeneratorOutput "+frt.format(new Date())+".csv");

        try(PrintWriter pw = new PrintWriter(csv)){
            StringBuilder sb = new StringBuilder();
            sb.append("Username;Name;Surname;Mail\n");
            for(User u:User.getUserList().values()){
                sb.append(u.getUserName());
                sb.append(";");
                sb.append(u.getName());
                sb.append(";");
                sb.append(u.getSurname());
                sb.append(";");
                sb.append(u.getEMail());
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
            System.out.println("File saved: "+csv);
        } catch (Exception e ){
            System.out.println("File was not saved!");
            e.printStackTrace();

        }
    }
}
