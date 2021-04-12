package StringHandling;

import Exceptions.KeyHasNoValueException;
import Exceptions.StringValidation;
import FileHandling.FoodJSONReader;

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
        this.finalCleanedString = finalCleanedString;
    }

    public String cleanString() {
        jerkSONData = convertLowerCase(this.jerkSONData);
        jerkSONData = removeWhiteSpace(this.jerkSONData);
        jerkSONData = replaceSpecChars(this.jerkSONData);
        this.finalCleanedString = jerkSONData;
        return finalCleanedString;
    }

    public String convertLowerCase(String input) {
        this.jerkSONData = input.toLowerCase();
        return input.toLowerCase();

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

    public int getCount(String input, String subStringToCount) {
        int count = 0;
        pattern = Pattern.compile(subStringToCount);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public int countErrors(String input) throws KeyHasNoValueException {
        int numErrors = 0;
        try {
            StringValidation.validateKeyHasValue(input);
            pattern = Pattern.compile(":;");
            matcher = pattern.matcher(input);
            while (matcher.find()) {
                numErrors++;
            }
        } catch (KeyHasNoValueException e) {
            e.getMessage();
            e.printStackTrace();
            // logging and handling the situation
        }
        return numErrors;
    }


}

/*
    try{
            Pattern pattern = Pattern.compile(REGEX);

            // get a matcher object
            Matcher matcher = pattern.matcher(INPUT);
            INPUT = matcher.replaceAll(REPLACE);
        } catch(PatternSyntaxException e){
            System.out.println("PatternSyntaxException: ");
            System.out.println("Description: "+ e.getDescription());
            System.out.println("Index: "+ e.getIndex());
            System.out.println("Message: "+ e.getMessage());
            System.out.println("Pattern: "+ e.getPattern());
        }
    }
 */
