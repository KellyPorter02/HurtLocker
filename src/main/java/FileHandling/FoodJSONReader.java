package FileHandling;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class FoodJSONReader {

    public String foodJSONData;

    public FoodJSONReader(){
        this.foodJSONData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("RawData.txt")).getFile());
        StringBuilder result = new StringBuilder();

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getFoodJSONData(){
        return foodJSONData;
    }
}
