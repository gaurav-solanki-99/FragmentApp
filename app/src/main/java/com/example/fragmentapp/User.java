package com.example.fragmentapp;

public class User {

    private String userName;
    private String userImage;

    public User()
    {}

    public User(String userName, String userImage) {
        this.userName = userName;
        this.userImage = userImage;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
