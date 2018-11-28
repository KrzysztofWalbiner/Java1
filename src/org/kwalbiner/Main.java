package org.kwalbiner;

public class Main {

    public static void main(String[] args) {

     //3 4 5 8 8 2 8 6 5
        check("3 4 5 8 8 2 8 6 5");
        check("1 1 1 1 1 1 1 1 1");


    }

    public static boolean check(String s) {
        String[] strings = s.split(" ");
        if(strings.length!=9)return false;

        int[] n = new int[9];
        for (int i = 0; i < 9; i++) {
            try{
                n[i] = Integer.parseInt(strings[i]);
            }catch(Exception e){
                return false;
            }
        }

        int sum = (n[8]+2*n[7]+3*n[6]+4*n[5]+5*n[4]+6*n[3]+7*n[2]+8*n[1]+9*n[0])%11;
        System.out.println(s+" SUM: "+sum);
        return sum==0;

    }
}
