package org.kwalbiner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Witaj w generatorze adresow email!");
        System.out.println("Wybierz jedna z poniższych opcji wpisując daną literę i wciskając enter.");
        System.out.println("p - drukuj liste");
        System.out.println("q - wyjdz");
        System.out.println("lub wpisać imię i nazwisko(np. Jan Kowalski)");

        while (true) {
            String input;
            input = scn.nextLine();
            if (input.equalsIgnoreCase("q"))
                return;
            else if (input.equalsIgnoreCase("p")) {
                System.out.println(User.printUsers());
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
}
