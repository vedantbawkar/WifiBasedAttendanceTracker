package com.example.wifibasedattendancetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetPasswordActivity extends AppCompatActivity {

    Intent home;
    EditText password1, password2;
    Button confirm;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        home = new Intent(SetPasswordActivity.this, MainActivity.class);
        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);
        confirm = findViewById(R.id.confirm_button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewPassword();
            }
        });
    }

    public void setNewPassword(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        String p1 = password1.getText().toString();
        String p2 = password2.getText().toString();

        if(p1.equals(p2)){
            HelperClass helperClass = new HelperClass(getIntent().getStringExtra("user"), p1, "0");
            Toast.makeText(this, getIntent().getStringExtra("user")+"pwdch", Toast.LENGTH_SHORT).show();
            reference.child(getIntent().getStringExtra("user")).setValue(helperClass);

            Toast.makeText(SetPasswordActivity.this, "Changed successfully!", Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(SetPasswordActivity.this, MainActivity.class);
            startActivity(home);
            finish();
        }else {
            password2.setError("The re-typed password does not match");
        }
    }

}