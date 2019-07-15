package com.example.app;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button mRegister;
    EditText username, email, password, confirmpassword;
    TextView already_have_an_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

initializeVaraibles();

mRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(validateInput()){
            doregister();
        }
    }
});

        already_have_an_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);


            }
        });
    }

    private void initializeVaraibles() {
        username = findViewById(R.id.reg_name);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        confirmpassword = findViewById(R.id.reg_confirm_password);
        mRegister = findViewById(R.id.btn_register);
        already_have_an_account = findViewById(R.id.txt_already_have_an_account);
    }


    private void doregister(){
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(RegisterActivity.this, "You have successfully registered", Toast.LENGTH_SHORT).show();
    }

    private boolean validateInput(){
        boolean isInputValid=false;
        String name = username.getText().toString().trim();
        String ema = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String cpass =confirmpassword.getText().toString().trim();
        if (!name.isEmpty()) {
            if(!ema.isEmpty()){
                if(Patterns.EMAIL_ADDRESS.matcher(ema).matches()){
                    if(!pass.isEmpty()){
                        if(!cpass.isEmpty()){
                            if(pass.equals(cpass)){
                                if(pass.length() >=6){
                                    isInputValid=true;
                                }
                                else{
                                    password.setError("Password is too Short. Must be at Least 6 Characters");
                                    password.requestFocus();
                                }
                            }
                            else{
                                Toast.makeText(this, "PassWord Mismatch", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            password.setError("Password Confirmation Required!");
                            password.requestFocus();
                        }
                    }
                    else{
                        password.setError("Password Cannot be Empty!");
                        password.requestFocus();
                    }
                }
                else{
                    email.setError("Invalid Email input!");
                    email.requestFocus();
                }
            }
            else{
                email.setError("Email Cannot be Empty!");
                email.requestFocus();
            }
        }
        else{

            username.setError("Username cannot be Empty!");
            username.requestFocus();
        }




        return isInputValid;
    }



}


