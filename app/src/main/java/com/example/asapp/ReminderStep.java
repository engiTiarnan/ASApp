package com.example.asapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReminderStep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_step);

        Button button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_FinalPage_page();
            }
        });
    }

    public void openActivity_FinalPage_page() {
        Intent intent = new Intent(this, FinalPage.class);
        startActivity(intent);
    }
}