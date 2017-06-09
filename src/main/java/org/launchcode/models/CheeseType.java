package org.launchcode.models;

/**
 * Created by Christy on 6/6/2017.
 */
public enum CheeseType {

    HARD ("Hard"), // the enum value is "HARD" and it has a private final String = "Hard" this calls the constructor
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
