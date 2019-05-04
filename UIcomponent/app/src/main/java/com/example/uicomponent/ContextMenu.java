package com.example.uicomponent;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextMenu extends Activity {
    private ListView lv2;
    private String[] names = new String[]{"One", "Two", "Three", "Four", "Five", "Six"};
    private int[] image = new int[]{R.drawable.index, R.drawable.index, R.drawable.index, R.drawable.index, R.drawable.index, R.drawable.index};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //此处引用布局文件
        setContentView(R.layout.activity_context_menu);
        lv2 = findViewById(R.id.lv2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final int color1 = 0xFFC5B5FF;
        final int color2 = 0xFFFFFFFF;
        //创建一个list集合，list集合的元素是Map
        List<Map<String, Object>> ListItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("images", image[i]);
            listItem.put("header", names[i]);
            //加入list集合
            ListItems.add(listItem);
        }
        //创建一个SimpleAdapter，此处严格按照定义数组names与image顺序,否则会出现程序build成功却运行失败且难以解决错误
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout.contextmenu_items, new String[]{"images", "header"}, new int[]{R.id.contextmenu_images, R.id.contextmenu_text});
        final ListView list = (ListView) findViewById(R.id.lv2);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        //
    }

    protected void onResume() {
        // 给文本视图tv_context注册上下文菜单。
        // 注册之后，只要长按该控件，App就会自动打开上下文菜单
        registerForContextMenu(lv2);
        super.onResume();
    }

    @Override
    protected void onPause() {
        // 给文本视图tv_context注销上下文菜单
        unregisterForContextMenu(lv2);
        super.onPause();
    }

    // 在上下文菜单的菜单界面创建时调用
    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        // 从menu_option.xml中构建菜单界面布局
        getMenuInflater().inflate(R.menu.menu2, menu);
    }

    // 在上下文菜单的菜单项选中时调用
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId(); // 获取菜单项的编号
        if (id == R.id.delete) { // 点击了菜单项“改变时间”
        }
            return true;
        }

    }


