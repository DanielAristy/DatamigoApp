package com.example.datamigoprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private CheckBox checkBox;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initComponents();
    }

    private void initComponents() {
        checkBox = findViewById(R.id.checkBox);
    }

    public void goToActivityLogin(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void loguearCheckBox(View view) {
        s = "Estado: " + (checkBox.isChecked() ? "Marcado" : "No marcado");
        Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
    }
}
