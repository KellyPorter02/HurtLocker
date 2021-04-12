import Exceptions.KeyHasNoValueException;
import FileHandling.FoodFileWriter;
import FileHandling.FoodJSONReader;
import StringHandling.JerkSONParser;
import StringHandling.OutputBuilder;

import java.io.IOException;

public class AppRunner implements Runnable {

    public AppRunner() {
    }

    public void run() {
        FoodJSONReader fileReader = new FoodJSONReader();
        JerkSONParser parser = new JerkSONParser();
        parser.cleanString();
        OutputBuilder opb = new OutputBuilder();
        String textToWriteOut = opb.buildString();
        FoodFileWriter writeOut = new FoodFileWriter();
        try {
            writeOut.writeOutputStringToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
