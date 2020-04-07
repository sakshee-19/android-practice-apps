package com.example.sakshee.vogellaapplication;

public class User {
    public static String USER_NAME = "username";
    public static String USER_GENDER = "gender";

    public static String USER_SKILL_POINTS = "skillpoints";
    public String name;
    public boolean gender;
    public int skillPoints;

    public User(String name, boolean gender){
        this.name = name;
        this.gender = gender;
        this.skillPoints = 0;
    }

}
