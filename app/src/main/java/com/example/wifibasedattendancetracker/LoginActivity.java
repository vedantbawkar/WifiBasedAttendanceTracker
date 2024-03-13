package com.example.wifibasedattendancetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    Intent home;
    EditText username, password;
    Button login;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        home = new Intent(LoginActivity.this, MainActivity.class);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_button);
        

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(username.getText().toString().equals("vedant") && password.getText().toString().equals("vedant")){
//                    startActivity(home);
//                    finish();
//                }
//                else{
//                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
//                }
                
//                Uncomment an use for signing up/logging in a user...
                signup();
//                login();

            }
        });
    }

    public void login(){
        String user_name = username.getText().toString();
        String pass_word = password.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(user_name);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    username.setError(null);
                    String passwordDB = snapshot.child(user_name).child("password").getValue(String.class);
                    if(passwordDB.equals(pass_word)){
                        username.setError(null);
                        home = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(home);
                    }else {
                        username.setError("Invalid credentials");
                        username.requestFocus();
                    }
                }else {
                    username.setError("User does not exist");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void signup(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        String uname = username.getText().toString();
        String pwd = password.getText().toString();

        HelperClass helperClass = new HelperClass(uname, pwd);
        reference.child(uname).setValue(helperClass);

        Toast.makeText(LoginActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();
        Toast.makeText(LoginActivity.this, "Proceed to login...", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this, LoginActivity.class);
        startActivity(i);
    }

}