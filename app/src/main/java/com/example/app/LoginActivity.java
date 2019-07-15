package com.example.app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText username,pass;
    TextView not_yet;
    CircleImageView imageView;
    int REQUEST_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        validateinput();
        initializer();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    dologin();

            }
        });

    not_yet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    });
    imageView.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_DENIED){

                requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
            }else{
                pickImage();
            }

        }
    });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void pickImage() {
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
        }
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED){
                pickImage();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
        Uri uri= data.getData();
        Glide.with(LoginActivity.this)
                .load(uri)
                .fitCenter()
                .into(imageView);



    }
    }

    private void dologin() {
        Intent intent= new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initializer(){
         login=findViewById(R.id.login_button);
         username=findViewById(R.id.login_username);
         pass=findViewById(R.id.login_password);
         not_yet=findViewById(R.id.not_yet);
         imageView=findViewById(R.id.login_logo);


    }
//    private boolean validateinput() {
//         boolean validateinput=false;
//        String name=username.getText().toString().trim();
//        String password=pass.getText().toString().trim();
//         if(!name.isEmpty()){
//             if(!password.isEmpty()){
//                 validateinput=true;
//             }
//             else{
//                 pass.setError("Password Cannot be Empty!");
//                 pass.requestFocus();
//             }
//         }
//         else{
//             username.setError("username cannot be empty");
//             username.requestFocus();
//         }
//
//        return validateinput;
//    }

}
