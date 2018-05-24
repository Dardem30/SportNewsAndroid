package com.example.roman.sportnews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.roman.sportnews.R;

/**
 * Created by Roman on 24.05.2018.
 */

public class GalleryActivity extends AppCompatActivity {
    TextView title,time,place,article,coefficient,preview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        Intent intent=getIntent();
        title=(TextView) findViewById(R.id.title);
        time=(TextView) findViewById(R.id.time);
        place=(TextView) findViewById(R.id.place);
        article=(TextView) findViewById(R.id.article);
        coefficient=(TextView) findViewById(R.id.coefficient);
        preview=(TextView) findViewById(R.id.preview);

        title.setText(intent.getStringExtra("title"));
        time.setText(intent.getStringExtra("time"));
        place.setText(intent.getStringExtra("place"));
        article.setText(intent.getStringExtra("article"));
        coefficient.setText(intent.getStringExtra("coefficient"));
        preview.setText(intent.getStringExtra("preview"));
    }
}
