package com.example.uicomponent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView;
        textView = (TextView)findViewById(R.id.testtext);
        switch (item.getItemId()) {
            case R.id.mune_enter:
                Toast.makeText(this, "点击了字体颜色", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mune_setting:
                Toast.makeText(this, "点击了普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mune_out:
                Toast.makeText(this, "点击了字体大小", Toast.LENGTH_SHORT).show();
                break;
            case R.id.size_12:
                textView.setTextSize(12);
                Toast.makeText(this, "点击了12dp字体", Toast.LENGTH_SHORT).show();
                break;
            case R.id.size_16:
                textView.setTextSize(16);
                Toast.makeText(this, "点击了16dp字体", Toast.LENGTH_SHORT).show();
                break;
            case R.id.size_20:
                textView.setTextSize(20);
                Toast.makeText(this, "点击了20dp字体", Toast.LENGTH_SHORT).show();
                break;
            case R.id.color_black:
                textView.setTextColor(Color.BLACK);
                Toast.makeText(this, "点击了黑色字体", Toast.LENGTH_SHORT).show();
                break;
            case R.id.color_red:
                textView.setTextColor(Color.RED);
                Toast.makeText(this, "点击了红色大小", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
