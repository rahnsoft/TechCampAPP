package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.models.Books;

import java.util.Locale;

public class BookActivity extends AppCompatActivity {
   TextView category,description,title;
   ImageView coverImage;
   Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

 Bundle extras =getIntent().getExtras();
         category =findViewById(R.id.bookCategory);
        description = findViewById(R.id.bookDescription);
        title =findViewById(R.id.bookTitle);
        coverImage =findViewById(R.id.cover_img);
        home=findViewById(R.id.btn_home);


        if(extras != null){
            int coverimg=extras.getInt("Image");
            String mtitle= extras.getString("Title");
            String mcategory =extras.getString("Category");
            String mdescription= extras.getString("Description");


            category.setText(mcategory);
            description.setText(mdescription);
            title.setText(mtitle);
            coverImage.setImageResource(coverimg);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(BookActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }
}
