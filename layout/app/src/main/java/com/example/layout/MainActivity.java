package com.example.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.linearlayout).setOnClickListener(this);
        findViewById(R.id.relativelayout).setOnClickListener(this);
        findViewById(R.id.tablelayout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.linearlayout) {
            Intent intent = new Intent(this, linearlayout.class);
            startActivity(intent);
        } else if (v.getId() == R.id.relativelayout) {
            Intent intent = new Intent(this, relativelayout.class);
            startActivity(intent);
        } else  if (v.getId() == R.id.tablelayout) {
            Intent intent = new Intent(this, tablelayout.class);
            startActivity(intent);
        }
    }
}
