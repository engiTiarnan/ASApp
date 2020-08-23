package com.example.asapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Below calls the menu page
                openActivity_pharmacy_locator_page();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Below calls the menu page
                openActivity_VisitUs_page();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Below calls the menu page
                openActivity_ContactUs_page();
            }
        });
    }

    public void openActivity_pharmacy_locator_page() {
        Intent intent = new Intent(this, PharmacyLocator.class);
        startActivity(intent);
    }
    public void openActivity_VisitUs_page() {
        Intent intent = new Intent(this, SiteLinkPage.class);
        startActivity(intent);

    }
    public void openActivity_ContactUs_page() {
        Intent intent = new Intent(this, ContactPage.class);
        startActivity(intent);

    }
}