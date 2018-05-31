package com.example.nimet.bestday;

import android.os.Bundle;
import android.service.autofill.Validator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityKaydol extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users/");

    EditText NameEdit = (EditText) findViewById(R.id.IsımEdit);
    EditText UsernameEdit = (EditText) findViewById(R.id.KullanıcıAdıEdit);
    EditText EmailEdit = (EditText) findViewById(R.id.EmailEdit);
    EditText PasswordEdit = (EditText) findViewById(R.id.PasswordEdit);
    EditText ConfirmPasswordEdit = (EditText) findViewById(R.id.ConfirmPasswordEdit);
    CheckBox UILA = (CheckBox) findViewById(R.id.UILA);
    Button KayıtOl = (Button) findViewById(R.id.KayıtOl);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);

        KayıtOl.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
            SignIn();

        }
    });

    }


    private void SignIn(){
        if(NameEdit!=null && UsernameEdit!=null && EmailEdit!=null && PasswordEdit!=null && ConfirmPasswordEdit!=null && UILA.isChecked()){
            //KULLANICI VAR OLUP OLMADIĞI SORGULANACAK



            myRef.child("UsernameEdit").child("UserName").setValue(UsernameEdit);
            myRef.child("UsernameEdit").child("Email").setValue(EmailEdit);
            myRef.child("UsernameEdit").child("Name").setValue(NameEdit);
            myRef.child("UsernameEdit").child("Password").setValue(PasswordEdit);

        }else{
            Toast.makeText(getApplicationContext(),
                    "Bütün kısımlarını doldurunuz ve kullanım şartlarını onaylayınız...", Toast.LENGTH_LONG).show();

        }

    }

}



