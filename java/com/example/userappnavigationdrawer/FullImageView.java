package com.example.userappnavigationdrawer;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FullImageView extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);
        imageView=findViewById(R.id.imageview);

        String image= getIntent().getStringExtra("image");
        Glide.with(this).load(image).into(imageView);
    }
}