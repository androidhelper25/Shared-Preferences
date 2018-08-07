package com.example.medell.afgclass;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class profile extends AppCompatActivity
    {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
        {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
        {
        switch (item.getItemId())
            {
            case R.id.logout:
                {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("login",false);
                editor.commit();
                finish();
                Toast.makeText(getApplicationContext(), "LOGGED OUT", Toast.LENGTH_SHORT).show();
                }
            }
        return super.onOptionsItemSelected(item);
        }

}
