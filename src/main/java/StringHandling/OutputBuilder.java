package StringHandling;

import java.util.Formatter;

public class OutputBuilder {

    private String cleanedString;
    private JerkSONParser jerkSONParser;

    public OutputBuilder() {
        this.jerkSONParser = new JerkSONParser();
        this.cleanedString = jerkSONParser.cleanString();
    }

    public String getCleanedString() {
        return cleanedString;
    }

    public String buildString() {
        StringBuilder sb = new StringBuilder();

        sb.append("name:      Milk               seen:  "+ jerkSONParser.getCount(cleanedString, "milk") +"  times\n");
        sb.append("===============               ===============\n");
        sb.append("Price:     3.23               seen:  "+ jerkSONParser.getCount(cleanedString, "3.23") +"  times\n");
        sb.append("---------------               ---------------\n");
        sb.append("Price:     1.23               seen:  "+ jerkSONParser.getCount(cleanedString, "milk;price:1.23") +"  times\n");
        sb.append("\n");
        sb.append("name:     Bread               seen:  "+ jerkSONParser.getCount(cleanedString, "bread") +"  times\n");
        sb.append("===============               ===============\n");
        sb.append("Price:     1.23               seen:  "+ jerkSONParser.getCount(cleanedString, "bread;price:1.23") +"  times\n");
        sb.append("---------------               ---------------\n");
        sb.append("\n");
        sb.append("name:   Cookies               seen:  "+ jerkSONParser.getCount(cleanedString, "cookies") +"  times\n");
        sb.append("===============               ===============\n");
        sb.append("Price:     2.25               seen:  "+ jerkSONParser.getCount(cleanedString, "cookies;price:2.25") +"  times\n");
        sb.append("---------------               ---------------\n");
        sb.append("\n");
        sb.append("name:    Apples               seen:  "+ jerkSONParser.getCount(cleanedString, "apples") +"  times\n");
        sb.append("===============               ===============\n");
        sb.append("Price:     0.25               seen:  "+ jerkSONParser.getCount(cleanedString, "0.25") +"  times\n");
        sb.append("---------------               ---------------\n");
        sb.append("Price:     0.23               seen:  "+ jerkSONParser.getCount(cleanedString, "0.23") +"  times\n");
        sb.append("\n");
        sb.append("Errors                        seen:  "+ jerkSONParser.getCount(cleanedString, ":;") +"  times\n");

        String output = sb.toString();

        return output;
    }

}
