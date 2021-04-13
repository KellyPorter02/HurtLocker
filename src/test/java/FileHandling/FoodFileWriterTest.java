package FileHandling;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;

public class FoodFileWriterTest {

    @Test
    public void writeOutputStringToFile() throws IOException {
        FoodFileWriter testFFW = new FoodFileWriter();
        boolean result = testFFW.writeOutputStringToFile();
        Assert.assertTrue(result);
    }




}