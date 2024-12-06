import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListDistance {
    public static void main(String[] args){
        
        try {
            File data = new File("data.txt");
            Scanner reader = new Scanner(data);
            ArrayList<Integer> column_1 = new ArrayList<>();
            ArrayList<Integer> column_2 = new ArrayList<>();
            Map<Integer, Integer> repetitions = new HashMap<>();
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                int space = line.indexOf(" ");
                column_1.add(Integer.valueOf(line.substring(0, space)));
                column_2.add(Integer.valueOf(line.substring(space + 3)));
                if(repetitions.get(column_2.getLast()) == null){
                    repetitions.put(column_2.getLast(), 1);
                } else {
                    repetitions.replace(column_2.getLast(), repetitions.get(column_2.getLast()) + 1);
                }
            }
            
            column_1.sort((a, b) -> {return Integer.compare(a, b);});
            column_2.sort((a, b) -> {return Integer.compare(a, b);});

            Integer total = 0;
            Integer total_similarity = 0;
            for(int i = 0; i < column_1.size(); i++){
                total += Math.abs(column_2.get(i) - column_1.get(i));
                if(repetitions.get(column_1.get(i)) != null) {
                    total_similarity += column_1.get(i) * repetitions.get(column_1.get(i));
                }
            }
            System.out.println("The distance between the two lists is: " + total);
            System.out.println("The similarity between the two lists is: " + total_similarity);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File data.txt does not exist");
            return;
        }
    }
}