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

public class login extends AppCompatActivity
    {
        SharedPreferences sharedPreferences;
        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            /*
            * to use shared preferences, you have to call a method getSharedPreferences()
            * this returns a SharedPreference instance pointing to the file that contains the values of preferences.
            * The first parameter is the key and the second parameter is the MODE.
            */
            sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
            final EditText mail = (EditText) findViewById(R.id.email);
            final EditText pwd = (EditText) findViewById(R.id.password);
            Button login = (Button) findViewById(R.id.loginb);
            login.setOnClickListener(new View.OnClickListener()
                {
                @Override
                public void onClick(View view)
                    {
                    String str1 = mail.getText().toString();
                    String str2 = pwd.getText().toString();
                    if ((!str1.isEmpty()) && ((!str2.isEmpty())))
                        {
                        /*
                        * sharedPreferences.getString used to get saved values from editor
                        * ffirst parameter is the key and ecod is the default value
                        */
                        String s1=sharedPreferences.getString("email","abc");
                        String p1=sharedPreferences.getString("password","abc");
                        if(s1.equals(str1) && p1.equals(str2))
                            {
                            Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFUL", Toast.LENGTH_LONG).show();
                            /*
                            * saving something in the sharedpreferences by using SharedPreferences.Editor class
                            */
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putBoolean("login",true);
                            editor.commit();
                            Intent intent = new Intent(login.this, profile.class);
                            startActivity(intent);
                            mail.setText("");
                            pwd.setText("");
                            }
                        else
                            {
                            Toast.makeText(getApplicationContext(), "LOGIN NOT SUCCESSFUL", Toast.LENGTH_LONG).show();
                            }
                        }
                    else
                        {
                        Toast.makeText(getApplicationContext(), "Please enter correct credentials", Toast.LENGTH_LONG).show();
                        }
                   }
                });
            }


    @Override
    protected void onResume()
        {
        super.onResume();
        boolean b=sharedPreferences.getBoolean("login",false);
        if(b)
            {
            startActivity(new Intent(login.this,profile.class));
            finish();
            }
        }
    }