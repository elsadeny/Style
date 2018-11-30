package com.sadeny.style;


//this class will act as template class to the user so that
//the information will be kept in oder
//the details needed for the user are
//name,phone,profile_picture(if applicable),address
//we don't need to store password locally

import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.Map;

//to log in or register the required info is phone and password
//the rest info will be updated in application setting
public class UserModel {
    //I made this variables static to be accessed outside of this class
    private static  String phone,password;
    private Bitmap prof_picture;
    private String address;

    //default constructor without params

    public UserModel(){}
    //default constructor with parameters password, phone
    public UserModel(String phone,String password)
    {
        this.phone = phone;
        this.password = password;
    }

    //public getter functions
    public String getPhone(){return phone;}
    public Bitmap getProf_picture() { return prof_picture; }
    public String getPassword(){return password;}
    public String getAddress(){return address;}

    //this function will return a map to be used in time of need
    public Map<String,String> getUserMap()
    {
        Map<String,String> map = new HashMap<String, String>();
        map.put(Static_Var.PHONE_KEY,phone);
        map.put(Static_Var.PASS_KEY,password);
        return map;
    }

    //public setter functions
    public void setPhone(String phone){this.phone= phone;}
    public void setPassword(String password){this.password = password;}
    public void setProf_picture(Bitmap prof_picture){this.prof_picture = prof_picture;}
    public void setAddress(String address){this.address=getAddress();}
}
