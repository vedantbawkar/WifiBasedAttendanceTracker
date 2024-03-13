package com.example.wifibasedattendancetracker;

public class HelperClass {
    String username;
    String password;
    String changePassword="1";

    public String getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(String changePassword) {
        this.changePassword = changePassword;
    }

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

    public HelperClass(String username, String password, String changePassword) {
        this.username = username;
        this.password = password;
        this.changePassword = changePassword;
    }

    public HelperClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public HelperClass() {
    }
}
