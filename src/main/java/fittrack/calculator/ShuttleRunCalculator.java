package fittrack.calculator;

import fittrack.enums.Gender;
import fittrack.lookupkey.LookUpKey;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShuttleRunCalculator extends Calculator {
    private static final Map<LookUpKey, TreeMap<Integer, Integer>> pullUpTable = new HashMap<>();

    static {
        initialiseMaleData();
        initialiseFemaleData();
    }

    public static int calculatePoints(Gender gender, int age, int reps) {
        reps *= 10;
        return getPointsFromTable(pullUpTable, gender, age, reps);
    }

    // Shuttle Run time (in hundredths of seconds)
    private static void initialiseMaleData() {
        // Age data arrays
        int[][][] ageTables = {
                {{104, 5}, {109, 4}, {113, 3}, {117, 2}, {122, 1}}, // Age 12
                {{103, 5}, {107, 4}, {111, 3}, {115, 2}, {119, 1}}, // Age 13
                {{102, 5}, {104, 4}, {108, 3}, {112, 2}, {116, 1}}, // Age 14
                {{102, 5}, {103, 4}, {105, 3}, {109, 2}, {113, 1}}, // Age 15
                {{102, 5}, {103, 4}, {105, 3}, {107, 2}, {111, 1}}, // Age 16
                {{102, 5}, {103, 4}, {105, 3}, {107, 2}, {109, 1}}, // Age 17-19
                {{104, 5}, {105, 4}, {107, 3}, {109, 2}, {111, 1}}  // Age 20-24
        };

        // Specific ages corresponding to each table
        int[] ages = {12, 13, 14, 15, 16};

        // Add data for specific ages 12 to 16
        for (int i = 0; i < ages.length; i++) {
            addAgeSubTable(pullUpTable, Gender.MALE, ages[i], ageTables[i]);
        }

        // Add data for ages 17 to 19 using the same table for all
        for (int age = 17; age <= 19; age++) {
            addAgeSubTable(pullUpTable, Gender.MALE, age, ageTables[5]); // Age 17-19 table
        }

        // Add data for ages 18 to 24 using the same table for all
        for (int age = 18; age <= 24; age++) {
            addAgeSubTable(pullUpTable, Gender.MALE, age, ageTables[6]); // Age 20-24 table
        }
    }

    private static void initialiseFemaleData() {
        // Age data arrays
        int[][][] ageTables = {
                {{115, 5}, {119, 4}, {123, 3}, {127, 2}, {132, 1}}, // Age 12
                {{113, 5}, {117, 4}, {122, 3}, {127, 2}, {132, 1}}, // Age 13
                {{115, 5}, {118, 4}, {122, 3}, {126, 2}, {130, 1}}, // Age 14
                {{113, 5}, {116, 4}, {120, 3}, {124, 2}, {128, 1}}, // Age 15
                {{113, 5}, {115, 4}, {118, 3}, {122, 2}, {126, 1}}, // Age 16
                {{113, 5}, {115, 4}, {118, 3}, {121, 2}, {125, 1}}, // Age 17
                {{113, 5}, {115, 4}, {118, 3}, {121, 2}, {124, 1}}, // Age 18
                {{113, 5}, {115, 4}, {118, 3}, {121, 2}, {124, 1}}, // Age 19
                {{116, 5}, {118, 4}, {121, 3}, {124, 2}, {127, 1}} // Age 20-24
        };

        // Specific ages corresponding to each table
        int[] ages = {12, 13, 14, 15, 16, 17, 18, 19};

        // Add data for specific ages 12 to 19
        for (int i = 0; i < ages.length; i++) {
            addAgeSubTable(pullUpTable, Gender.FEMALE, ages[i], ageTables[i]);
        }

        // Add data for ages 18 to 24 using the same table for all
        for (int age = 18; age <= 24; age++) {
            addAgeSubTable(pullUpTable, Gender.FEMALE, age, ageTables[8]); // Age 20-24 table
        }
    }
}