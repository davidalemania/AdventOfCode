import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class ListDistance {
    public static void main(String[] args){
        
        try {
            File data = new File("data.txt");
            Scanner reader = new Scanner(data);
            ArrayList<Integer> column_1 = new ArrayList<>();
            ArrayList<Integer> column_2 = new ArrayList<>();
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                int space = line.indexOf(" ");
                column_1.add(Integer.valueOf(line.substring(0, space)));
                column_2.add(Integer.valueOf(line.substring(space + 3)));
            }
            
            column_1.sort((a, b) -> {return Integer.compare(a, b);});
            column_2.sort((a, b) -> {return Integer.compare(a, b);});

            Integer total = 0;
            for(int i = 0; i < column_1.size(); i++){
                total += Math.abs(column_2.get(i) - column_1.get(i));
            }
            System.out.println("The distance between the two lists is: " + total);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File data.txt does not exist");
            return;
        }
    }
}