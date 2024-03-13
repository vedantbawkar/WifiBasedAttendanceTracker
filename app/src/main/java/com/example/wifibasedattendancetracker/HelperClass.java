package com.example.wifibasedattendancetracker;

public class HelperClass {
    String username;
    String password;

    public String getChangePassword() {
        return changePassword;
    }

    String changePassword="1";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HelperClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public HelperClass() {
    }
}
