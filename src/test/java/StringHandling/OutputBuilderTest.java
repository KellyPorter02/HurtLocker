package StringHandling;

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
    public void getInput() {
        System.out.println(testOutputBuilder.getCleanedString());

    }

    @Test
    public void buildString() {
    }
}