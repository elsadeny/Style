package com.sadeny.style;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private Context context;
    public final SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    private final String PREF_NAME="app_preference";

    public UserData(Context context)
    {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor =sharedPreferences.edit();
    }

   //this function is no longer needed will be deleted before production
    //this function will set the user details in sharedPreference
    /*
    public void setUserDetails(String name,String phone)
    {
        editor.putString(Static_Var.NAME_KEY,name);
        editor.putString(Static_Var.PHONE_KEY,phone);
     //   editor.putString(TOKEN_KEY,token);
        editor.commit();
    }*/
    public void setUserDetails(UserModel user)
    {
        editor.putString(Static_Var.PHONE_KEY,user.getPhone());
        editor.putString(Static_Var.PASS_KEY,user.getPassword());
        editor.commit();
    }

    // this function is used to get the user details in time of need
    public UserModel getUserDetails()
    {
        UserModel userDetail = new UserModel();
        String phone =sharedPreferences.getString(Static_Var.NAME_KEY,null);
        String pass=sharedPreferences.getString(Static_Var.PASS_KEY,null);
        //String token=sharedPreferences.getString(TOKEN_KEY,null);
        //userDetail.put(TOKEN_KEY,token);
        userDetail.setPhone(phone);
        userDetail.setPassword(pass);
        return userDetail;
    }

    //in case we will use token
    public String getToken ()
    {
        String token = sharedPreferences.getString(Static_Var.TOKEN_KEY,null);
        return token;
    }

    //function to check if the user have the details saved
    public boolean isLoggedIn()
    {
        return sharedPreferences.getString(Static_Var.NAME_KEY,null)!=null;
    }
    public void logout()
    {
        editor.clear();
        editor.apply();
        //context.startActivity(new Intent(context,Login.class));
    }

}
