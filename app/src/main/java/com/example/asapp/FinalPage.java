package com.example.asapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        Button button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_ReturnToStart_page();
            }
        });
    }

    public void openActivity_ReturnToStart_page() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}