package com.sadeny.style;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkHandler {

    //init the global variables for network management class\
    public static NetworkHandler netInstance;
    public RequestQueue netRequestQueue;
    public static Context context;

    public NetworkHandler (Context context)
    {
        this.context = context;
        netRequestQueue = getRequestQueue();
    }


    //this function is used to create new instance in case it was not
    //to avoid data loss or ovarlap in case the class is called twice
    //before finish the first request
    public static synchronized NetworkHandler getInstance(Context context)
    {
        if(netInstance==null) {
            netInstance = new NetworkHandler(context);
        }
        return netInstance;
    }

    public RequestQueue getRequestQueue() {
        if(netRequestQueue==null)
        {
            netRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return netRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }
}
