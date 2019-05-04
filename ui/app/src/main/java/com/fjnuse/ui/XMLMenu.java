package com.fjnuse.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class XMLMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlmenu);
        Button btn1=(Button)findViewById(R.id.bk);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 利用菜单填充器将菜单资源文件映射成菜单
        getMenuInflater().inflate(R.menu.fontmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.font_size:
                Toast.makeText(this, "你单击了[字体大小]菜单项！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item:
                Toast.makeText(this, "你单击了[普通菜单选项]菜单项！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.font_color:
                Toast.makeText(this, "你单击了[字体颜色]菜单项！", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
