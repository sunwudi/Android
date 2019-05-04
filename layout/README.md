## Android（2）——布局

###一. 布局的类型

1. #### **线性布局**

* 简介：线性布局（LinearLayout）在实际开发中比较常见，他主要是以水平和垂直方式来显示界面中的控件。当控件水平排列时，显示顺序依次为从左到右；当控件垂直排列时，显示顺序依次为从上到下
* 属性
  * orientation——用于控制控件的排列方向，该属性有两个值vertical和horizontal(默认)，其中vertical表示布局垂直显示，horital表示布局水平显示。
  * gravity——制定布局内部视图与本线性布局的对其方式。取值同layout_gravity。
  * layout_gravity——指定该视图与上级视图的对其方式，取值：left(靠左对齐),right(靠右对齐),top(向上对齐),bottom(向下对齐),center(居中对齐),center_horizontal(水平方向居中),center_vertical(垂直方向居中)。
  * layout_weight——指定当前视图的高和宽占上级线性视图的权重。

2. #### 相对布局

* 简介
  * 在Android程序创建时，默认采用的就是相对布局(RelativeLatout)。相对布局是通过相对定位的方式指定控件位置，即以其他控件或父容器为参照物，摆件控件位置。在设计相对布局时要遵循控件之间的依赖关系，后放入控件的位置依赖于放入的控件。
* 属性
  *  **相对于父元素给控件布局**
    - android:layout_centerHrizontal  水平居中 
    - android:layout_centerVertical 垂直居中 
    - android:layout_centerInparent    相对于父元素完全居中 
    - android:layout_alignParentBottom 位于父元素的下边缘 
    - android:layout_alignParentLeft   位于父元素的左边缘 
    - android:layout_alignParentRight  位于父元素的右边缘
  *  **属性值必须为id的引用名“@id/id-name”**  
    *  android:layout_below      位于元素的下方 
    *  android:layout_above      位于元素的的上方
    * android:layout_toLeftOf   位于元素的左边 
    *  android:layout_toRightOf  位于元素的右边 
    * android:layout_alignTop   该元素的上边缘和某元素的的上边缘对齐 
    * android:layout_alignLeft  该元素的左边缘和某元素的的左边缘对齐 
    * android:layout_alignBottom 该元素的下边缘和某元素的的下边缘对齐 
    *  android:layout_alignRight  该元素的右边缘和某元素的的右边缘对齐   
  * **给属性赋予像素值** 
    * android:layout_marginBottom     底边缘的距离 
    * android:layout_marginLeft           左边缘的距离 
    * android:layout_marginRight         右边缘的距离 
    * android:layout_marginTop           上边缘的距离

3. #### 表格布局

* 简介：表格布局(TableLayout)是以表格的形式排列控件的，通过行和列将界面划分为多个单元格，每个单元格都可以添加控件。表格布局需要个TableRow配合使用，每一行都由TableRow对象组成，因此tablerow决定表格的行数。
* 属性
  * 布局属性
    * android:stretchColumns——设置该列被拉伸，列号从0开始。例如android：stretchColumns=“0”表示第1列被拉伸
    * android:shrinkColumns——设置该列被收缩，列号从0开始。例如android：shrinkColumns=“0”表示第1列被拉伸
    * android:collapseColumns——设置该列被隐藏，列号从0开始。例如android：collapseColumns=“0”表示第1列被拉伸
  * 控件属性
    * android:layout_column——设置该单元格显示位置，如android:layout_column=“1” 表示在第2个位置显示
    * android:layout_span——表示该单元格占据几行，默认为一行

### 二.布局实现

1. 线性布局

   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       tools:context=".linearlayout">
       <LinearLayout
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           android:orientation="vertical">
           <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:orientation="horizontal">
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="one,one">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="one,two">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="one,three">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="one,four">
               </Button>
           </LinearLayout>
           <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:orientation="horizontal">
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="two,one">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="two,two">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="two,three">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="two,four">
               </Button>
           </LinearLayout>
           <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:orientation="horizontal">
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="three,one">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="three,two">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="three,three">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="three,four">
               </Button>
           </LinearLayout>
           <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:orientation="horizontal">
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="four,one">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="four,two">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="four,three">
               </Button>
               <Button
                   android:textSize="10dp"
                   android:layout_width="wrap_content"
                   android:layout_height="wrap_content"
                   android:text="four,four">
               </Button>
           </LinearLayout>
       </LinearLayout>
   </android.support.constraint.ConstraintLayout>
   ```

2. 相对布局

   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       tools:context=".relativelayout">
           <RelativeLayout
               android:layout_width="match_parent"
               android:layout_height="match_parent"
               android:background="#000000">
               <Button
                   android:id="@+id/red"
                   android:layout_width="80dp"
                   android:layout_height="80dp"
                   android:layout_alignParentLeft="true"
                   android:background="@android:color/holo_red_dark"
                   android:text="red"/>
               <Button
                   android:id="@+id/orange"
                   android:layout_width="80dp"
                   android:layout_height="80dp"
                   android:layout_centerHorizontal="true"
                   android:background="@android:color/holo_orange_dark"
                   android:text="orange"/>
               <Button
                   android:id="@+id/yellow"
                   android:layout_width="80dp"
                   android:layout_height="80dp"
                   android:layout_alignParentRight="true"
                   android:background="@android:color/holo_orange_light"
                   android:text="yellow"/>
               <Button
                   android:id="@+id/green"
                   android:layout_width="80dp"
                   android:layout_height="80dp"
                   android:layout_centerVertical="true"
                   android:layout_toLeftOf="@+id/blue"
                   android:background="@android:color/holo_green_dark"
                   android:layout_marginRight="10dp"
                   android:text="green"/>
               <Button
                   android:id="@+id/blue"
                   android:layout_width="80dp"
                   android:layout_height="80dp"
                   android:layout_centerVertical="true"
                   android:layout_centerHorizontal="true"
                   android:background="@android:color/holo_blue_dark"
                   android:text="blue"
                   android:textColor="@android:color/white"/>
               <Button
                   android:id="@+id/indigo"
                   android:layout_width="80dp"
                   android:layout_height="80dp"
                   android:layout_centerVertical="true"
                   android:layout_toRightOf="@+id/blue"
                   android:layout_marginLeft="10dp"
                   android:background="@android:color/holo_purple"
                   android:text="purple"
                   android:textColor="@android:color/white"/>
               <Button
                   android:id="@+id/violet"
                   android:layout_alignParentBottom="true"
                   android:layout_width="match_parent"
                   android:layout_height="80dp"
                   android:background="@android:color/holo_red_light"
                   android:text="violet"/>
           </RelativeLayout>
       </android.support.constraint.ConstraintLayout>
   ```

   

3. 表格布局

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".tablelayout">
<TableLayout
    android:background="@android:color/black"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:stretchColumns="1">
    <TableRow>
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="0"
            android:text="open..." />
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="2"
            android:text="ctrl-o"/>
    </TableRow>
    <TableRow>
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="0"
            android:text="save..." />
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="2"
            android:text="ctrl-s"/>
    </TableRow>
    <TableRow>
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="0"
            android:text="save as..." />
        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="2"
            android:text="ctrl-shift-s"/>

    </TableRow>
    <View
        android:layout_width="match_parent"
        android:layout_height="3dp"
        android:background="@android:color/darker_gray">
    </View>
    <TableRow
        android:layout_marginTop="3dp"
        android:outlineSpotShadowColor="@android:color/white">
        <Button
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="0"
            android:text="X   import..."/>
    </TableRow>
    <TableRow>
        <Button
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="0"
            android:text="X   export..."/>
        <Button
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_column="2"
            android:text="ctrl-e"/>
    </TableRow>
    <View
        android:layout_width="match_parent"
        android:layout_height="3dp"
        android:background="@android:color/darker_gray">
    </View>
    <TableRow>
        <Button
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        android:background="@android:color/black"
        android:textColor="@android:color/white"
        android:layout_column="0"
        android:text="quit"/>
    </TableRow>
</TableLayout>
</android.support.constraint.ConstraintLayout>
```

### 实验截图



![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/jYiEKEIUE6TcPyZDKTqR8xJw0sMHs8NpS5Kgg8MSC3c!/b/dL8AAAAAAAAA&bo=0wE0AwAAAAADB8c!&rf=viewer_4)



![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/aZdzGAUxcuOH6haS9QYP8Aw6WIOKhas*UiXDD*clw7Y!/b/dL8AAAAAAAAA&bo=0wE0AwAAAAADF9c!&rf=viewer_4)

![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/eEdpamRVSba10vYnhsiLrMgwFgJMylpOzW3nb1FXTA4!/b/dLYAAAAAAAAA&bo=0wE0AwAAAAADF9c!&rf=viewer_4)

![](http://m.qpic.cn/psb?/V11yBUmB1rpVYD/dL*ufYIm9ohR2i9V4diF3SSj3N1k24EkaeVgeOLSX6w!/b/dAgBAAAAAAAA&bo=0wE0AwAAAAADF9c!&rf=viewer_4)