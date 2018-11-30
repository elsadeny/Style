package com.sadeny.style;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener{

    //global variables declarations
    Button login;
    EditText txPhone,txPassword;
    TextView tvRegister;

    //Declare the class of shared functions
    SharedFx sharedFx;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_login);

        //initialize the view's variables
        login = (Button)findViewById(R.id.loginButton);
        txPhone= (EditText)findViewById(R.id.username);
        txPassword = (EditText)findViewById(R.id.password);
        tvRegister = (TextView)findViewById(R.id.register);

        //init the userModel class
        userModel = new UserModel();

        //adding event interface to view
        login.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    //overriding the click interface
    @Override
    public void onClick(View view)
    {
        sharedFx = new SharedFx();
        if(view == login)
        {
            if(sharedFx.validate(txPhone) && sharedFx.validate(txPassword))
            {
                //implement login function here
                //Toast.makeText(this,"You can safely login",Toast.LENGTH_LONG).show();
                ApiManager apiManager = new ApiManager(this);
                //this will call/instruct the api class to make a network call
                //AND start new Activity
                boolean send =apiManager.sendPost(userModel.getUserMap(),Static_Var.LOGIN_URL);
                if(send)
                {
                    finish();
                    startActivity(new Intent(this,MainFlow.class));
                }
            }
        }
        if(view == tvRegister)
        {
            //start the register Activity
            finish();
            startActivity(new Intent(this,Register_Activity.class));
        }
    }

    public void startUP()
    {

    }
}
