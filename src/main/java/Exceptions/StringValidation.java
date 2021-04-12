package Exceptions;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {

    public static void validateKeyHasValue(String input) throws KeyHasNoValueException {
        String regex = ":;";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new KeyHasNoValueException("Key has no associated value");
        }
    }
}
