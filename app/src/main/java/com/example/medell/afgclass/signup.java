package com.example.medell.afgclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity
    {
    EditText name;
    EditText email;
    EditText pwd;
    EditText cpwd;
    Button signup,login;
    SharedPreferences  sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        /*
        * to use shared preferences, you have to call a method getSharedPreferences()
        * this returns a SharedPreference instance pointing to the file that contains the values of preferences.
        * The first parameter is the key and the second parameter is the MODE.
        */
        sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        pwd = (EditText)findViewById(R.id.pwd);
        cpwd = (EditText)findViewById(R.id.cpwd);
        signup=(Button)findViewById(R.id.signupb);
        login=(Button)findViewById(R.id.loginb);
        signup.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                String str1 = name.getText().toString();
                String str2 = email.getText().toString();
                String str3 = pwd.getText().toString();
                String str4 = cpwd.getText().toString();
                if ((!str1.isEmpty()) && ((!str2.isEmpty())) && ((!str3.isEmpty())) && ((!str4.isEmpty())) && (str3.equals(str4)))
                    {
                    /*
                    * saving something in the sharedpreferences by using SharedPreferences.Editor class
                    */
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    /*
                    * using map interface to set values in the editor
                    */
                    editor.putString("name", str1);
                    editor.putString("email", str2);
                    editor.putString("password", str3);
                    /*
                    * editor.commit() is used to save the values set in the editor
                    */
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "SIGNUP SUCCESSFUL", Toast.LENGTH_LONG).show();
                    }
                else if (((!str1.isEmpty()) && ((!str2.isEmpty())) && ((!str3.isEmpty())) && ((!str4.isEmpty()))) && (!str3.equals(str4)))
                    {
                    Toast.makeText(getApplicationContext(), "PASSWORD DO NOT MATCH", Toast.LENGTH_LONG).show();
                    }
                else
                    {
                    Toast.makeText(getApplicationContext(), "Please enter correct credentials", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }


