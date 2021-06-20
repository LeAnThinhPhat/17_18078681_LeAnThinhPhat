package com.example.a17_18078681_leanthinhphat;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {
    TextView edEmail, edPassword;
    Button btnDangNhap;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangNhap = findViewById(R.id.btnLogin);
        edEmail = findViewById(R.id.txtEmail);
        edPassword = findViewById(R.id.txtPass);

        mAuth = FirebaseAuth.getInstance();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });
    }

    private void DangNhap() {
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            String mail = edEmail.getText().toString();
                            String date = LocalDateTime.now().toString();
                            UserDatabase.getInstance(MainActivity.this).userDao().addUser(new TaiKhoan(mail,date));

                            Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                            Intent intent2 = new Intent(MainActivity.this,Screen1.class);
                            startActivity(intent2);

                        } else {
                            Toast.makeText(MainActivity.this,"Fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }





}