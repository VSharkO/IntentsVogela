package com.example.vsharko.intents;

/**
 * Created by vsharko on 29.10.17..
 */

public class User {
    public static String USER_NAME = "username";
    public static String USER_GENDER = "gender"; // true -> male // false -> female
    public static String USER_SKILL_POINTS= "skillPoints";
    public String name;
    public boolean gender;
    public int skillPoints;

    public User(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
        this.skillPoints = 0;
    }
}
