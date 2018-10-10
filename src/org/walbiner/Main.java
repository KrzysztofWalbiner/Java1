package org.walbiner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Zad 1:");
        int a = 1;
        int b = 13;
        if ((a >= 13 && a <= 19) || (b >= 13 && b <= 19)) {
            System.out.println("teen");
        }

        System.out.println("Zad 2:");
        int sum = 0;
        int[] array = {1, 13, 2};
        for (int val : array) {
            if (val == 13) {
                break;
            }
            sum += val;
        }
        System.out.println("Suma " + sum);

        System.out.println("Zad 3:");
        int[] tablica = {3, 2, 14, 1, 2, 3, 6};
        int warunek = 1;
        boolean combo = false;
        for (int i : tablica) {
            if (warunek == 3 && i == 3) {
                combo = true;
            }
            if (i == warunek&&!combo) {
                ++warunek;
            }

        }
        System.out.println("Combo: "+combo);
        
        System.out.println("Zad 3alt:");
        System.out.println(Arrays.toString(tablica).matches(".*, 1, 2, 3,.*"));


    }
}
