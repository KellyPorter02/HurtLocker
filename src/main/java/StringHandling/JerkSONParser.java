package StringHandling;

import FileHandling.FoodJSONReader;

public class JerkSONParser {

    private String jerkSONData;
    private FoodJSONReader jerkSONReader;

    public JerkSONParser() {
        jerkSONReader = new FoodJSONReader();
        this.jerkSONData = jerkSONReader.getFoodJSONData();
    }

    public String getJerkSONData() {
        return jerkSONData;
    }


}
