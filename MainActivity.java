package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPressed(View v) {
        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("ADD", true);
        startActivity(i);
    }

    public void viewPressed(View v) {
        Intent i = new Intent(this, NameViewActivity.class);
        startActivity(i);
    }

    public void resultPressed(View v) {
        Intent i = new Intent(this, PostivieView.class);
        startActivity(i);
    }

    public void deletePressed(View v){
        Intent i = new Intent(this, DeleteActivity.class);
        startActivity(i);
    }
}
