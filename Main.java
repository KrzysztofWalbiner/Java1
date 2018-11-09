import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character> chars = new ArrayList<>();

        try {
        List<String> lines = Files.readAllLines(Paths.get("C:/Users/walbiner/Desktop/bank_ocr_dojo_us1"));

            int numberOfLines = lines.size();
            int numberOfCharacters = lines.get(0).length();


            for (int i = 0; i <= numberOfLines-4;) {
                for (int j = 0; j <= numberOfCharacters-3;) {
                    char[][] c = new char[3][3];
                    c[0][0]= lines.get(i).charAt(j);
                    c[0][1]= lines.get(i).charAt(j+1);
                    c[0][2]= lines.get(i).charAt(j+2);

                    c[1][0]= lines.get(i+1).charAt(j);
                    c[1][1]= lines.get(i+1).charAt(j+1);
                    c[1][2]= lines.get(i+1).charAt(j+2);

                    c[2][0]= lines.get(i+2).charAt(j);
                    c[2][1]= lines.get(i+2).charAt(j+1);
                    c[2][2]= lines.get(i+2).charAt(j+2);

                    chars.add(new Character(c));
                    j=j+3;


                }
                i=i+4;
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(chars.size());
        chars.get(0).print();
    }
}
