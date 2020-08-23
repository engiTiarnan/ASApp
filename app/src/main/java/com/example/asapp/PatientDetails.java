package com.example.asapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientDetails extends AppCompatActivity {

    public EditText PatientName;
    public EditText PatientScheme;
    public EditText PatientAddress;
    public EditText PatientCollectionTime;
    public EditText PatientCollectionDate;
    private EditText PatientEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        PatientName = (EditText) findViewById(R.id.editTextTextPersonName);
        PatientEmail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        PatientScheme = (EditText) findViewById(R.id.editTextTextPersonName3);
        PatientAddress = (EditText) findViewById(R.id.editTextTextPostalAddress);
        PatientCollectionTime = (EditText) findViewById(R.id.editTextTime2);
        PatientCollectionDate = (EditText) findViewById(R.id.editTextDate2);

        Button button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code executes when the button is clicked
                Capture_PatientDetails();


            }
        });
    }

    public void Capture_PatientDetails() {


        //Below assigns the data entered in the patient details to strings
        //Probably could be done in a for loop
        String strPatientName = PatientName.getText().toString();
        String strPatientScheme = PatientScheme.getText().toString();
        String strPatientAddress = PatientAddress.getText().toString();
        String strPatientCollectionTime = PatientCollectionTime.getText().toString();
        String strPatientCollectionDate = PatientCollectionDate.getText().toString();
        String strPatientEmail = PatientCollectionDate.getText().toString();

        //Checks if data has been entered in the required fields, returns error if not
        //Could be done in separate boolean function
        if(strPatientName.isEmpty()){
            PatientName.setError("Required");}
            if (strPatientCollectionTime.isEmpty()){
                PatientCollectionTime.setError("Required");}
                if (strPatientCollectionDate.isEmpty()){
                    PatientCollectionDate.setError("Required");}
                    if(strPatientEmail.isEmpty()) {
                        PatientEmail.setError("Required");

        } else {
            //Conditions met, opens next activity
            openActivity_PictureCapture_page();
        }
    }

    public void openActivity_PictureCapture_page() {
        //Intent below goes to new page
        Intent intent = new Intent(this, PictureCapture.class);
        startActivity(intent);
    }
}