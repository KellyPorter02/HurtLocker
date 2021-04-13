package StringHandling;

import FileHandling.FoodJSONReader;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONParser {

    private String jerkSONData;
    private FoodJSONReader jerkSONReader;
    private String finalCleanedString;
    public Pattern pattern;
    public Matcher matcher;


    public JerkSONParser() {
        jerkSONReader = new FoodJSONReader();
        this.jerkSONData = jerkSONReader.getFoodJSONData();
    }

    public String cleanString() {
        jerkSONData = convertLowerCase(this.jerkSONData);
        jerkSONData = removeWhiteSpace(this.jerkSONData);
        jerkSONData = replaceSpecChars(this.jerkSONData);
        jerkSONData = replaceZeros(this.jerkSONData);
        this.finalCleanedString = jerkSONData;
        return finalCleanedString;
    }

    public String convertLowerCase(String input) {
        Matcher m = Pattern.compile("\\b\\w{1,}\\b").matcher(input);
        StringBuilder sb = new StringBuilder();
        int last = 0;
        while (m.find()) {
            sb.append(input.substring(last, m.start()));
            sb.append(m.group(0).toLowerCase());
            last = m.end();
        }
        sb.append(input.substring(last));
        return sb.toString();
    }

    public String removeWhiteSpace(String input) {
        pattern = Pattern.compile("[\\s]");
        matcher = pattern.matcher(input);
        String noWhiteSpace = matcher.replaceAll("");
        this.jerkSONData = noWhiteSpace;
        return noWhiteSpace;
    }

    public String replaceSpecChars(String input) {
        pattern = Pattern.compile("[@^*!%]");
        matcher = pattern.matcher(input);
        return matcher.replaceAll(";");
    }

    public String replaceZeros(String input) {
        pattern = Pattern.compile("[o0][o0]k");
        matcher = pattern.matcher(input);
        return matcher.replaceAll("ook");
    }


    public int getCount(String input, String subStringToCount) {
        int count = 0;
        pattern = Pattern.compile(subStringToCount);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public String getJerkSONData() {
        return jerkSONData;
    }

    public void setJerkSONData(String input) {
        jerkSONData = input;
    }

    public String getFinalCleanedString() {
        return finalCleanedString;
    }

    public void setFinalCleanedString(String input) {
        this.finalCleanedString = input;
    }

}


