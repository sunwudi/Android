## 实验三

### 1.利用SimpleAdapter实现如下界面效果 

关键代码：

animals.java

```java
package com.example.uicomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class animals extends AppCompatActivity {
    //用于显示布局里的动物名称
    private String[] names = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat","Elephant"};
    private int[] image = new int[]{R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //此处引用布局文件
        setContentView(R.layout.activity_animals);
        Button btn1=(Button)findViewById(R.id.btn1);
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
            listItem.put("header", names[i]);
            listItem.put("images", image[i]);
            //加入list集合
            ListItems.add(listItem);
        }
        //创建一个SimpleAdapter，此处严格按照定义数组names与image顺序,否则会出现程序build成功却运行失败且难以解决错误
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout.simple_items, new String[]{"header", "images"}, new int[]{R.id.header, R.id.images});
        final ListView list = (ListView) findViewById(R.id.lv);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        //对应点击事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int flag = 0;
                switch (flag) {
                    case 0:
                        CharSequence text = names[position];
                        //定义一个Toast表示哪一个图片所在item被点击
                        int duration = Toast.LENGTH_SHORT;  //LENGTH_SHORT是2秒，LONG是3.5秒
                        Toast toast = Toast.makeText(animals.this, text, duration);
                        toast.show();
                        flag = 1;
                        break;
                    case 1:
                        CharSequence text1 = names[position];
                        int duration1 = Toast.LENGTH_SHORT;
                        Toast toast1 = Toast.makeText(animals.this, text1, duration1);
                        toast1.show();
                        flag = 0;
                        break;
                }
            }
        });
        //选中函数
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "选中");
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
```

simple_items.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">
    <TextView
        android:id="@+id/header"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#000000"
        android:textSize="20dp"
        android:paddingLeft="10dp"
        />
    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
        <ImageView
            android:id="@+id/images"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_margin="0dp"
            android:layout_alignParentRight="true"
            />
    </RelativeLayout>
</LinearLayout>

```

实验截图:

![](http://a4.qpic.cn/psb?/V11yBUmB1rpVYD/khGAUTOZ.kmiD0v7qwim8IskkKpS085ZWjyz8nNe2RM!/b/dL8AAAAAAAAA&ek=1&kp=1&pt=0&bo=0wE0AwAAAAARF8U!&tl=3&vuin=1435258158&tm=1556996400&sce=60-4-3&rf=viewer_4)

## 2.创建如图所示的自定义对话框 

关键代码:

index.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <ImageView
        android:id="@+id/logo"
        android:layout_width="wrap_content"
        android:layout_height="150dp"
        android:background="@drawable/index"
        android:layout_margin="5dp"/>
    <EditText
        android:id="@+id/username"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/logo"
        android:layout_margin="5dp"
        android:hint="Username"
        android:inputType="text"/>

    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="5dp"
        app:layout_constraintTop_toBottomOf="@+id/username"
        android:hint="Password"
        android:inputType="textPassword"
        android:fontFamily="sans-serif"/>

</android.support.constraint.ConstraintLayout>
```

login.java:

```java
package com.example.uicomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.content.DialogInterface;
import android.widget.Button;

public class login extends AppCompatActivity {
    private android.view.LayoutInflater LayoutInflater;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //此处引用布局文件
        setContentView(R.layout.activity_login);
        LayoutInflater=LayoutInflater.from(login.this);
        view=LayoutInflater.inflate(R.layout.index, null);
        Button btn1=(Button)findViewById(R.id.lg);
        Button btn2=(Button)findViewById(R.id.bk);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater=LayoutInflater.from(login.this);
                view=LayoutInflater.inflate(R.layout.index, null);

                AlertDialog.Builder builder=new AlertDialog.Builder(login.this);
                builder.setView(view);
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", null);
                AlertDialog d=builder.create();
                d.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

```

实验截图:

![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/b2pbX*KSTWW1HFBhBWjwrH5.2g1xhvFhSeuxW66cZAE!/b/dMEAAAAAAAAA&bo=0wE0AwAAAAADF9c!&rf=viewer_4)

![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/Q*alMbIBC5ui2jmDf4c2sQxniSBx3xN6DsjVqidUYUo!/b/dDUBAAAAAAAA&bo=0wE0AwAAAAARF8U!&rf=viewer_4)



## 3.使用XML定义菜单  



关键代码：

menu.java：

```java
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

```

munu1.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        tools:context="com.jiapeng.munedemo.MainActivity" >

    <item
        android:id="@+id/mune_enter"
        android:title="字体大小"
        app:showAsAction="never">
        <menu>
            <item
                android:id="@+id/size_12"
                app:showAsAction="never"
                android:title="12dp">
            </item>
            <item
                android:id="@+id/size_16"
                app:showAsAction="never"
                android:title="16dp">
            </item>
            <item
                android:id="@+id/size_20"
                app:showAsAction="never"
                android:title="20dp">
            </item>
        </menu>
    </item>
    <item
        android:id="@+id/mune_setting"
        android:title="普通菜单项"
        app:showAsAction="never"/>
    <item
        android:id="@+id/mune_out"
        android:title="字体颜色"
        app:showAsAction="never">
        <menu>
            <item
                android:id="@+id/color_black"
                app:showAsAction="never"
                android:title="black">
            </item>
            <item
                android:id="@+id/color_red"
                app:showAsAction="never"
                android:title="red">
            </item>
        </menu>
    </item>
</menu>
```

实验截图:

![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/bfa4OMqj4O4UYbttEVxICTuA*rzKVbnFJFI9zCZUtVU!/b/dL8AAAAAAAAA&bo=0wE0AwAAAAARF8U!&rf=viewer_4)

![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/eK.Jz0*dL.qnCVct9m8qEBlny.v.7xWCI.yFEnPO*Ss!/b/dAQBAAAAAAAA&bo=0wE0AwAAAAADF9c!&rf=viewer_4)

![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/apbKe6GM7GeIWVKRaKTnzpNDb5Dh.y8PctCi9eEP5nQ!/b/dFQBAAAAAAAA&bo=0wE0AwAAAAARF8U!&rf=viewer_4)

##4.创建上下文操作模式(ActionMode)的上下文菜单 

关键代码：

ContextMenu.java:

```java
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



```

activity_context_menu.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ContextMenu">
    <ListView
        android:id="@+id/lv2"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="5dp"
        android:divider="#d9d9d9"
        android:dividerHeight="1dp">
    </ListView>
    <Button
        android:id="@+id/btn1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Back"
        app:layout_constraintBottom_toBottomOf="parent" />
</android.support.constraint.ConstraintLayout>
```

实验截图:

![](http://a4.qpic.cn/psb?/V11yBUmB1rpVYD/LAjhtHExpPcYIWfLzZfjMEWm*oQbCCohEpyvq.SA364!/b/dL8AAAAAAAAA&ek=1&kp=1&pt=0&bo=0wE0AwAAAAADF9c!&tl=1&vuin=1435258158&tm=1556996400&sce=60-4-3&rf=viewer_4)

![](http://a4.qpic.cn/psb?/V11yBUmB1rpVYD/o42YRC2zigMaV*UAeQ4ZmnvGxr9rKbNL3bXPxOm1twk!/b/dL8AAAAAAAAA&ek=1&kp=1&pt=0&bo=0wE0AwAAAAADF9c!&tl=1&vuin=1435258158&tm=1556996400&sce=60-4-3&rf=viewer_4)