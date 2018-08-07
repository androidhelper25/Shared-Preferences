package com.example.medell.afgclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity7 extends AppCompatActivity
    {
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Button signup = (Button)findViewById(R.id.signup);
        Button login = (Button)findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                Intent intent = new Intent(MainActivity7.this, signup.class);
                startActivity(intent);
                }
            });
        login.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                Intent intent = new Intent(MainActivity7.this, login.class);
                startActivity(intent);
                }
            });
        }
    }
