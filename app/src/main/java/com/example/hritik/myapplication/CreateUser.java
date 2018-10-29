package com.example.hritik.myapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CreateUser{
    public String name;
    public String email;
    public String password;
    public String code;
    public String issharing;
    public String lng;
    public String lat;
    public String userid;
    String dbreference;


    public CreateUser() {
    }

    public CreateUser(String name, String email, String password, String code, String issharing, String lng, String lat) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.code = code;
        this.issharing = issharing;
        this.lng = lng;
        this.lat = lat;
        this.userid = userid;

    }

    public CreateUser(String lng, String lat, String userid) {
        this.lng = lng;
        this.lat = lat;
        this.userid = userid;
    }

    public String getName() {


        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCode() {
        return code;
    }

    public String getIssharing() {
        return issharing;
    }

    public String getLng() {
        return lng;
    }

    public String getLat() {
        return lat;
    }

    public String getUserid() {
        return userid;
    }
}
