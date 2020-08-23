package com.example.asapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PharmacyLocator extends AppCompatActivity {

    public String PharmacyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_locator);

        Button button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_PatientDetails_page();
            }
        });

        /*Button button1 = (Button) findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets the pharmacy name, hardcoded for now to be changed
                PharmacyName = "Pharmacy 1";
                SendMail();
            }
        });

        Button button2 = (Button) findViewById(R.id.button14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets the pharmacy name, hardcoded for now to be changed
                PharmacyName = "Pharmacy 2";
                SendMail();
            }
        });

        Button button3 = (Button) findViewById(R.id.button15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets the pharmacy name, hardcoded for now to be changed
                PharmacyName = "Pharmacy 3";
                SendMail();
            }
        });*/

    }

    public void openActivity_PatientDetails_page() {
        Intent intent = new Intent(this, PatientDetails.class);
        startActivity(intent);
    }

    private void SendMail() {
        //Takes string PharmacyName and sends it to a predetermined email, either mine or the pharmacies

        String mail = "tiarnanokelly@gmail.com";
        String message = PharmacyName;
        String subject = PharmacyName;

        //Call to the API to send the email Creates and passes through all of the data
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mail, message, subject);

        javaMailAPI.execute();
    }


}