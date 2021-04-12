package StringHandling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutputBuilderTest {

    private String jerkSONText;
    private JerkSONParser testJerkSONParser;
    private String finalCleanedString;
    private OutputBuilder testOutputBuilder;
    private String testClean;

    @Before
    public void setUp() {
        testJerkSONParser = new JerkSONParser();
        jerkSONText = testJerkSONParser.getJerkSONData();
        jerkSONText = testJerkSONParser.convertLowerCase(jerkSONText);
        jerkSONText = testJerkSONParser.removeWhiteSpace(jerkSONText);
        jerkSONText = testJerkSONParser.replaceSpecChars(jerkSONText);
        testOutputBuilder = new OutputBuilder();



    }

    @Test
    public void buildString() {
        String expected = "name:      Milk               seen:  8  times\n" +
                "===============               ===============\n" +
                "Price:     3.23               seen:  7  times\n" +
                "---------------               ---------------\n" +
                "Price:     1.23               seen:  1  times\n" +
                "\n" +
                "name:     Bread               seen:  6  times\n" +
                "===============               ===============\n" +
                "Price:     1.23               seen:  6  times\n" +
                "---------------               ---------------\n" +
                "\n" +
                "name:   Cookies               seen:  7  times\n" +
                "===============               ===============\n" +
                "Price:     2.25               seen:  10 times\n" +
                "---------------               ---------------\n" +
                "\n" +
                "name:    Apples               seen:  4  times\n" +
                "===============               ===============\n" +
                "Price:     0.25               seen:  2  times\n" +
                "---------------               ---------------\n" +
                "Price:     0.23               seen:  2  times\n" +
                "\n" +
                "Errors                        seen:  4  times\n";
        String returned = testOutputBuilder.buildString();
        Assert.assertEquals(expected, returned);
    }
}