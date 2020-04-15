package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    private EditText nameBox;
    private EditText nameView;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        nameBox = findViewById(R.id.nameBox);
        nameView = findViewById(R.id.nameView);
        deleteButton = findViewById(R.id.deleteButton);
    }

    public void deletePressed(View v) {
        String name = nameBox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.delete(name);
        finish();
    }
}