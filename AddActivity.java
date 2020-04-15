package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText nameBox;
    private EditText dateBox;
    private EditText resultBox;
    private Button personButton;
    private boolean addPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameBox = findViewById(R.id.nameBox);
        resultBox = findViewById(R.id.resultBox);
        dateBox = findViewById(R.id.dateBox);
        personButton = findViewById(R.id.personButton);
        Intent i = getIntent();
        addPerson = i.getBooleanExtra("ADD", true);
        if(addPerson) {
            personButton.setText("ADD PATIENT");
        } else {
            personButton.setText("EDIT");
            nameBox.setText(i.getStringExtra("NAME"));
            dateBox.setText(i.getStringExtra("DATE"));
            resultBox.setText(i.getStringExtra("RESULT"));
        }
    }

    public void addPressed(View v) {
        String name = nameBox.getText().toString();
        String date = dateBox.getText().toString();
        String result = resultBox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        if(addPerson)
            dbm.insert(name, date, result);
        else
            dbm.updateByTitle(name, result, date);
        finish();
    }
}
