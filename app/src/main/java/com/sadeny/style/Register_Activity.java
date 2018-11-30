package com.sadeny.style;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Register_Activity extends AppCompatActivity implements View.OnClickListener {


    //declare the view variables
    EditText txPhone,txPassword,txRePassword;
    Button btnRegister;
    TextView tvLogin;
    UserModel userModel;
    //
    SharedFx sharedFx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_register);
        //initialize the views variables
        txPhone = (EditText)findViewById(R.id.username);
        txPassword=(EditText)findViewById(R.id.password);
        txRePassword=(EditText)findViewById(R.id.repassword);
        btnRegister = (Button)findViewById(R.id.registerButton);
        tvLogin = (TextView)findViewById(R.id.tvRegister);

        //implement onClick interface
        tvLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        //init user model
        userModel = new UserModel();
    }

    @Override
    public void onClick(View view)
    {
        sharedFx = new SharedFx();
        if(view == btnRegister)
        {
            if(sharedFx.validate(txPhone) && sharedFx.validate(txPassword))
            {
                //implement register function here
               // Toast.makeText(this,"You can safely login",Toast.LENGTH_LONG).show();
                if(sharedFx.validate(txPhone,txPassword,txRePassword)){
                 //Toast.makeText(this.getApplicationContext(),userModel.getPhone()+" Welcome " +userModel.getPassword(),Toast.LENGTH_LONG).show();
                    ApiManager apiManager = new ApiManager(this);
                    //this will call/instruct the api class to make a network call
                    boolean send =apiManager.sendPost(userModel.getUserMap(),Static_Var.REGISTER_URL);
                    if(send)
                    {
                        finish();
                        startActivity(new Intent(this,MainFlow.class));
                    }
                }

                //ApiManager apiManager = new ApiManager(this.getApplicationContext());

            }
        }
        if(view == tvLogin)
        {
            //start the register Activity
            //
            finish();
            startActivity(new Intent(this,Login_Activity.class));
        }
    }
}
