package StringHandling;

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
        String output =
                ""
        return "";
    }

}
