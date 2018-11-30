package com.sadeny.style;


//this class will handle most of the networking functions
//like
//1.. check if the phone is connected to the network
//sending request to server
//getting response to server
//updating UI in case of response


import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import android.content.Intent;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiManager {
    private Context context;



    //default constructor
    public ApiManager(Context context){this.context = context;}

    //function to send POST request
    public boolean sendPost(Map<String,String> params, String url)
    {
       //async fx
        JSONObject object = new JSONObject(params);
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("Loading...");
        pd.setCancelable(true);
        pd.show();
       JsonObjectRequest customRequest = new JsonObjectRequest(Request.Method.POST, url,object, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                //TODO
                //handle messages
                //response is json consist of SERVER_MESSAGE,
                //save the response to SharedPreference and open new Activity
                pd.dismiss();
                saveData();
                Static_Var.RET_BOOL= true;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
                //TODO
                //notify the user about the error and try again if needed
                Static_Var.RET_BOOL=false;

            }
        });
       call_network(customRequest);
       return Static_Var.RET_BOOL;
    }

    //function to send GET request

    //this function will start our Volley singleton and send request
    //to the server
    public void call_network(JsonObjectRequest objectRequest)
    {
        NetworkHandler.getInstance(context).addToRequestQueue(objectRequest);
    }
    public void saveData()
    {
        UserData userData = new UserData(context);
        UserModel user = new UserModel();
        userData.setUserDetails(user);
    }
}
