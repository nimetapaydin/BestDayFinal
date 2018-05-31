package com.example.nimet.bestday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityGirisYap extends AppCompatActivity {

    EditText GirisUsername = (EditText) findViewById(R.id.KullaniciAdiGiris);
    EditText GirisPassword = (EditText) findViewById(R.id.PasswordGiris);
    Button GirisYap = (Button) findViewById(R.id.giris);




    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference loginRef = database.getReference("users/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        GirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
