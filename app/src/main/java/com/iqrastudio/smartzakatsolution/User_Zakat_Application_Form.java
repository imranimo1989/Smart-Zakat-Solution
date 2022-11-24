package com.iqrastudio.smartzakatsolution;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class User_Zakat_Application_Form extends AppCompatActivity {

    EditText editTextName, editTextNameEnglish, editTextFaterName, editTextMotherName,
            editTextIdCardNo,editTextMobile,editTextPresentAddress, editTextCountry,
    editTextDistrict, editTextDivision,editTextThana,editTextVillage,editTextWard,
    editTextEducation, editTextOccupation,editTextAge, editTextland,editTextSelfDes;






    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;


    ImageView imgZakatReceiver;

    RadioGroup radioGroupMaritalStatus,radioGroupMaritalSta,radioGroupOwnProperty,radioGroupZakatHistory;
    RadioButton radioButtonMarried, radioButtonUnMarried,radioButtonMar,radioButtonUnMar
            ,radioButtonOwnPropertyYes,radioButtonOwnPropertyNo, radioButtonZakatHistoryYes,radioButtonZakatHistoryNo;
    LinearLayout layMaritalStatus;
    Button btPicUpload, buttonRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_zakat_application_form);




        //editText
        editTextName = findViewById(R.id.etName);
        editTextNameEnglish= findViewById(R.id.etNameEng);
        editTextFaterName=findViewById(R.id.etNameFather);
        editTextMotherName = findViewById(R.id.etNameMother);
        editTextMobile=findViewById(R.id.etUserMobile);
        editTextIdCardNo = findViewById(R.id.etIdNo);







buttonRegistration=findViewById(R.id.buttonRegistration);
        btPicUpload = findViewById(R.id.btPicUpload);




        radioGroupMaritalStatus = findViewById(R.id.radioGroupMaritalStatus);
        radioButtonMarried = findViewById(R.id.rbMarried);
        radioButtonUnMarried = findViewById(R.id.rbUnmarried);
        imgZakatReceiver = findViewById(R.id.imgZakatReceiver);
        layMaritalStatus = findViewById(R.id.layMaritalStatus);





        //Marital status interactivity..............
        radioButtonMarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layMaritalStatus.setVisibility(View.VISIBLE);
            }
        });

        radioButtonUnMarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layMaritalStatus.setVisibility(View.GONE);
            }
        });
        //=======================================



//Picture upload

        btPicUpload.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                else
                {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }


            }
        });
        //end button upload=======================================













        //Registration Process
        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Check empty editText input
                if (editTextName.getText().toString().isEmpty()||editTextNameEnglish.getText().toString().isEmpty()||
                        editTextFaterName.getText().toString().isEmpty()||editTextMotherName.getText().toString().isEmpty()||
                        editTextMobile.getText().toString().isEmpty()||editTextIdCardNo.getText().toString().isEmpty())
                {
                    new AlertDialog.Builder(User_Zakat_Application_Form.this)
                            .setTitle("Registration Error!")
                            .setMessage("Sorry! You missed something!")
                            .setIcon(R.drawable.ic_error)
                            .show();
                }

                else {

                    new AlertDialog.Builder(User_Zakat_Application_Form.this)
                            .setTitle("Registration Success!")
                            .setMessage("Congratulations!, Your application has been summited")
                            .setIcon(R.drawable.ic_check_circle)
                            .show();
                }//end if statement===================================



            }
        });
        //end button reg=======================================

    }
    //============================================end OnCreate Bundle================================



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
    //=======================================
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgZakatReceiver.setImageBitmap(photo);
            imgZakatReceiver.setVisibility(View.VISIBLE);
        }
    }
//=======================================





    }



