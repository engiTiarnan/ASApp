package com.example.asapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PictureCapture extends AppCompatActivity {

    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;

    Uri image_uri;

    ImageView mImageView;
    Button mCaptureB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_capture);

        //Next button
        Button button = (Button) findViewById(R.id.button8);
        //Capture button
        mCaptureB = (Button) findViewById(R.id.button20);
        //Image
        mImageView = findViewById(R.id.image_view20);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_ReminderStep_page();
            }
        });

        mCaptureB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If OS is >= marshmallow, request runtime permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                    == PackageManager.PERMISSION_DENIED){
                        //Established permission not able, request it
                        String[] permission = {Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        //SHOW POP UP TO REQUEST PERMISSIONS
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else{
                        //PERMISSION HAS ALREADY BEEN GRANTED
                        openCamera();
                    }
                }
                else {
                    openCamera();
                }
            }
        });
    }

    public void openActivity_ReminderStep_page() {
        Intent intent = new Intent(this, ReminderStep.class);
        startActivity(intent);
    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values);
        //CAMERA INTENT
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);

    }

    //HANDLING PERMISSION RESULT
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        //THIS METHOD GETS CALLED WHEN THE USER PRESSES ALLOW OR DENY FROM PERMISSION REQUEST POPUP
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                //PERMISSION FROM USER WAS DENIED
                Toast.makeText(this, "Permission denied...",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //called when image was captured from camera
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //SETS THE IMAGE CAPTURE TO OUR IMAGEVIEW ON APP SCREEN
            mImageView.setImageURI(image_uri);
        }

    }
}