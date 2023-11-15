package com.kitri.myfirstservlet.practice;

public class User {
    String id;
    String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }
}

