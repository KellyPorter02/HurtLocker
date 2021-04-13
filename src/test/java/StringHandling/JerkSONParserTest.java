package StringHandling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JerkSONParserTest {

    private String jerkSONText;
    private JerkSONParser testJerkSONParser;

    @Before
    public void setUp() {
        testJerkSONParser = new JerkSONParser();
        jerkSONText = testJerkSONParser.getJerkSONData();
    }

    @Test
    public void constructorNoArgTest () {
        // arrange
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##\n";
        // act
        String returned = testJerkSONParser.getJerkSONData();
        System.out.println(returned);
        // assert
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void setJerkSONData() {
        String expected = "not the JSON stuff anymore";
        testJerkSONParser.setJerkSONData(expected);
        String returned = testJerkSONParser.getJerkSONData();
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void getJerkSONData() {
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##\n";
        String returned = testJerkSONParser.getJerkSONData();
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void convertLowerCase() {
        String expected = "name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:3.23;type:food^expiration:1/11/2016##name:cookies;price:2.25;type:food%expiration:1/25/2016##name:cookies;price:2.25;type:food*expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:1.23;type:food!expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food@expiration:1/02/2016##name:bread;price:1.23;type:food@expiration:2/25/2016##name:milk;price:;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:co0kies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food^expiration:1/04/2016##\n";
        String returned = testJerkSONParser.convertLowerCase(jerkSONText);
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void removeWhiteSpace() {
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##\n";
        String returned = testJerkSONParser.removeWhiteSpace(jerkSONText);
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void replaceSpecChars() {
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food;expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##\n";
        String returned = testJerkSONParser.replaceSpecChars(jerkSONText);
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void getCount() {
        String input = "milk:milk:cookies:food";
        int expected = 2;
        int returned = testJerkSONParser.getCount(input, "milk");
        System.out.println(returned);
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void cleanString() {
        String expected = "name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:3.23;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:1.23;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:co0kies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##";
        String returned = testJerkSONParser.cleanString();
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void getFinalCleanedString() {
        String expected = "name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:3.23;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:1.23;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##name:milk;price:3.23;type:food;expiration:1/25/2016##name:bread;price:1.23;type:food;expiration:1/02/2016##name:bread;price:1.23;type:food;expiration:2/25/2016##name:milk;price:;type:food;expiration:1/11/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:co0kies;price:2.25;type:food;expiration:1/25/2016##name:cookies;price:2.25;type:food;expiration:3/22/2016##name:cookies;price:2.25;type:food;expiration:1/25/2016##name:milk;price:3.23;type:food;expiration:1/17/2016##name:milk;price:;type:food;expiration:4/25/2016##name:apples;price:0.25;type:food;expiration:1/23/2016##name:apples;price:0.23;type:food;expiration:5/02/2016##name:bread;price:1.23;type:food;expiration:1/25/2016##name:;price:3.23;type:food;expiration:1/04/2016##";
        String returned = testJerkSONParser.cleanString();
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void setFinalCleanedString() {
        String expected = "not the JerkSON text";
        testJerkSONParser.setFinalCleanedString(expected);
        String returned = testJerkSONParser.getFinalCleanedString();
        Assert.assertEquals(expected,returned);
    }


    @Test
    public void replaceZeros() {
        String given = "co0kiec0okie";
        String returned = testJerkSONParser.replaceZeros(given);
        System.out.println(returned);
    }
}