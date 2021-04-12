package StringHandling;

import Exceptions.KeyHasNoValueException;
import Exceptions.StringValidation;
import FileHandling.FoodJSONReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONParser {

    private String jerkSONData;
    private FoodJSONReader jerkSONReader;
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

    public String convertLowerCase(String input) {
        pattern = Pattern.compile("", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        String leonPoem = jerkSONData;
        if (matchFound) {
            leonPoem = matcher.replaceAll("Leon");
        }
        return leonPoem;
    }

    public String removeWhiteSpace(String input) {
        pattern = Pattern.compile("[\\s]");
        matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

    public String replaceSpecChars(String input) {
        pattern = Pattern.compile("[@^*!]");
        matcher = pattern.matcher(input);
        return matcher.replaceAll(";");
    }

    public

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
