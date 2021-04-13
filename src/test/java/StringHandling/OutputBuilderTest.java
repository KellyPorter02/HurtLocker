package StringHandling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutputBuilderTest {

    private String jerkSONText;
    private JerkSONParser testJerkSONParser;
    private OutputBuilder testOutputBuilder;


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
        String expected =
                "name:      Milk               seen:  8  times\n" +
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
                "Price:     2.25               seen:  7  times\n" +
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
        System.out.println(returned);
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void getCleanedString() {
        String expected = "name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:3.23;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:1.23;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:co0kies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##";
        String returned = testOutputBuilder.getCleanedString();
        Assert.assertEquals(expected, returned);
    }


}