package com.example.td1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class td1_2 extends AppCompatActivity {

    private TextView text;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_td1_2);
        text = (TextView) findViewById(R.id.activity_game_question_text);
        image = (ImageView) findViewById(R.id.activity_imageView);

        Intent i = getIntent();
        String tel = i.getStringExtra("TEL");

        text.setText(text.getText().toString()+"\n Call :"+tel);

        image.setImageResource(R.drawable.telephone);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tel, null));
                startActivity(call);
            }
        });
    }
}