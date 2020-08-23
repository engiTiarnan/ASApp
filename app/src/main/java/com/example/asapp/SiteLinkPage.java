package com.example.asapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SiteLinkPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_link_page);


        Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_ReturnToStart_page();
            }
        });

        Button button2 = (Button) findViewById(R.id.button12);
                button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openActivity_link_to_website();
            }
        });
    }

    public void openActivity_ReturnToStart_page() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    public void openActivity_link_to_website() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.alfascript.com"));
        startActivity(intent);
    }
}