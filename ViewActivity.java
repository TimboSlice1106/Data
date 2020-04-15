package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    private TextView nameView;
    private TextView dateView;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        nameView = findViewById(R.id.nameView);
        dateView = findViewById(R.id.dateView);
        resultView = findViewById(R.id.resultView);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String name = i.getStringExtra("NAME");
        String[] entry = dbm.get(name);
        nameView.setText(entry[0]);
        dateView.setText(entry[1]);
        resultView.setText(entry[2]);
    }

    public void editPressed(View v) {
        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("ADD", false);
        i.putExtra("NAME", nameView.getText().toString());
        i.putExtra("DATE", dateView.getText().toString());
        i.putExtra("RESULT", resultView.getText().toString());
        startActivity(i);
    }
}
