package com.example.nimet.bestday;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ActivityGirisYap extends AppCompatActivity {

    TextView kayıt;

    public static class ul
    {

        public String Username;
        public String Password;

        public ul(String Username, String Password)
        {
            this.Username = Username;
            this.Password = Password;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String Username) {
            this.Username = Username;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public ul()
        {

        }
    }




    EditText GirisUsername ;
    EditText GirisPassword ;
    Button GirisYap ;

    DatabaseReference usernameRef;
    ArrayList<ul> UserList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        kayıt = (TextView) findViewById(R.id.kaydol);
        GirisUsername = (EditText) findViewById(R.id.KullaniciAdiGiris);
        GirisPassword = (EditText) findViewById(R.id.PasswordGiris);
        GirisYap = (Button) findViewById(R.id.giris);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        usernameRef = database.getReference("users/");

        UserList = new ArrayList<>();

        kayıt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                Intent goKayıt = new Intent(ActivityGirisYap.this , ActivityKaydol.class);
                startActivity(goKayıt);


                // FirebaseDatabase.getInstance().getReference("users").child(username).child("Username");

            }
        });




    }
/*

    private void getUsers(){

        for (DataSnapshot ds : ) {
            ul it =ds.getValue(ul.class);
                UserList.add(it);
        }
    }*/
}
