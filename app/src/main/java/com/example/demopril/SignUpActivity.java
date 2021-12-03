package com.example.demopril;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demopril.R;

public class SignUpActivity extends AppCompatActivity {
    Button btnSignUp, btnAccount;
    EditText edEmail, edPassword, edFirstName, edSecondName, edRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edEmail = findViewById(R.id.etEmail);
        edFirstName = findViewById(R.id.etFirstName);
        edSecondName = findViewById(R.id.etSecondName);
        edPassword = findViewById(R.id.etPassword);
        edRePassword = findViewById(R.id.etRePassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnAccount = findViewById(R.id.btnAccount);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edEmail.getText().toString())||
                        TextUtils.isEmpty(edPassword.getText().toString())||
                        TextUtils.isEmpty(edSecondName.getText().toString())||
                        TextUtils.isEmpty(edFirstName.getText().toString())||
                        TextUtils.isEmpty(edRePassword.getText().toString()))
                {
                    ShowAlertDialogWindow("Есть пустые поля!");
                }
                else if (!edPassword.getText().toString().equals(edRePassword.getText().toString()))
                {
                    ShowAlertDialogWindow("Пароли не совпадают");
                }
                
                
                else {

                }

            }
            public void ShowAlertDialogWindow(String s){
                AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).setMessage(s).setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { dialog.cancel();}
                }).create();
                alertDialog.show();
            }
        });


    }
}