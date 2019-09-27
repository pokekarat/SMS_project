package com.example.ekaratrattagan.mysms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv_text);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        if(message != null && !message.isEmpty())
            tv.setText(message);
    }
}
