package ro.mta.se.lab;

public class stringParser {
    public static String parse(String temp) {
        switch (temp)
        {
            case "RO":
                return "Romania";
            case "DK":
                return "Denmark";
            case "BG":
                return "Bulgaria";
            case "DE":
                return "Germany";
            case "CN":
                return "China";
            case "RU":
                return "Russia";
            case "UK":
                return "England";
            case "IT":
                return "Italy";
            case "AU":
                return "Australia";
            case "HU":
                return "Hungary";
            default: return "Not found";
        }
    }
    public static String revert(String temp){
        switch (temp)
        {

            case "Romania":
                return "RO";
            case "Denmark":
                return "DK";
            case "Bulgaria":
                return "BG";
            case "Germany":
                return "DE";
            case "China":
                return "CN";
            case "Russia":
                return "RU";
            case "England":
                return "UK";
            case "Italy":
                return "IT";
            case "Australia":
                return "AU";
            case "Hungary":
                return "HU";
            default: return "Not found";
        }
    }
    public static String regleaza(String temp)
    {
        switch (temp)
        {

            case "Sofia":
                return "      Sofia";
            case "Rastnik":
                return "        Rastnik";
            case "Bulgaria":
                return "BG";
            case "Germany":
                return "DE";
            case "China":
                return "CN";
            case "Russia":
                return "RU";
            case "England":
                return "UK";
            case "Italy":
                return "IT";
            case "Australia":
                return "AU";
            case "Hungary":
                return "HU";
            default: return "Not found";
        }
    }

}
