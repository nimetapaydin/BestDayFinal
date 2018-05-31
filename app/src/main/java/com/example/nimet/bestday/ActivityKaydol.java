package com.example.nimet.bestday;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityKaydol extends AppCompatActivity {



    EditText nameEdit,usernameEdit,passwordEdit,confirmPasswordEdit,emailEdit;
    CheckBox uila;
    Button KayitOl;
    DatabaseReference myRef;
    Boolean Control=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        nameEdit=(EditText)findViewById(R.id.nameEdit);
        usernameEdit=(EditText)findViewById(R.id.usernameEdit);
        emailEdit=(EditText)findViewById(R.id.emailEdit);
        passwordEdit=(EditText)findViewById(R.id.passwordEdit);
        confirmPasswordEdit=(EditText)findViewById(R.id.confirmPasswordEdit);

        uila=(CheckBox)findViewById(R.id.UILA);
        KayitOl=(Button)findViewById(R.id.KayıtOl);


        KayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  CheckEverythingIsFine();

               // if (Control){

                KayitOlFunc();

                goMain();

               // }

            }
        });

    }
/*
    private void CheckEverythingIsFine(){

        if (nameEdit==null){
            Toast.makeText(ActivityKaydol.this,"Lütfen Adınızı giriniz...",Toast.LENGTH_SHORT);
            Control=false;
        }else if (usernameEdit==null){
            Toast.makeText(ActivityKaydol.this,"Lütfen Kullanıcı adınızı giriniz...",Toast.LENGTH_SHORT);
            Control=false;
        }else if (emailEdit==null){
            Toast.makeText(ActivityKaydol.this,"Lütfen Mail adresinizi giriniz...",Toast.LENGTH_SHORT);
            Control=false;
        }else if (passwordEdit==null){
            Toast.makeText(ActivityKaydol.this,"Lütfen Şifrenizi giriniz...",Toast.LENGTH_SHORT);
            Control=false;
        }else if (confirmPasswordEdit==null){
            Toast.makeText(ActivityKaydol.this,"Lütfen Şifrenizi doğrulayınız...",Toast.LENGTH_SHORT);
            Control=false;
        }else if (passwordEdit.getText().toString()!=confirmPasswordEdit.getText().toString()){
            Toast.makeText(ActivityKaydol.this,"Şifreler uyuşmamaktadır...",Toast.LENGTH_SHORT);
            Control=false;
        }else {
            Control=true;
        }
    }*/




    private void KayitOlFunc(){
        String username=usernameEdit.getText().toString();
        myRef.child("users").child(username).child("Username").setValue(usernameEdit.getText().toString());
        myRef.child("users").child(username).child("Name").setValue(nameEdit.getText().toString());
        myRef.child("users").child(username).child("Email").setValue(emailEdit.getText().toString());
        myRef.child("users").child(username).child("Password").setValue(passwordEdit.getText().toString());

    }


    private void goMain(){
        Intent GoLogin = new Intent(ActivityKaydol.this , MainActivity.class);
        startActivity(GoLogin);
    }



   // FirebaseDatabase.getInstance().getReference("users").child(username).child("Username");
}



