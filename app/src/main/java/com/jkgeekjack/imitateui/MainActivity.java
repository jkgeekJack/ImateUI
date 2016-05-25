package com.jkgeekjack.imitateui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    //左上角的标志
    private ActionBarDrawerToggle mDrawerToggle;
    //菜单列表
    private ListView lvLeftMenu;
    //菜单选项标题
    private String[] lvs={"List item 01","List item 02","List item 03"};
    private ArrayAdapter arrayAdapter;
    //浮动按钮
    private ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        toolbar.setTitle("Toolbar");
        setSupportActionBar(toolbar);

        //后面的R.string.close,R.string.open好像没什么用，但一定要设
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.close,R.string.open);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
    }

    private void initView() {
        ib= (ImageButton) findViewById(R.id.fab);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddTaskActivity.class));
            }
        });
        toolbar= (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.dl_left);
        lvLeftMenu= (ListView) findViewById(R.id.lv_left_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tasks_fragment_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_clear:
                Toast.makeText(this,"clear",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_refresh:
                Toast.makeText(this,"refresh",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_filter:
                Toast.makeText(this,"refresh",Toast.LENGTH_SHORT).show();
                //点击时弹出PopupMenu
                showFilterPopupMenu();
                break;
        }
        return true;
    }

    private void showFilterPopupMenu() {
        //绑定点击的item
        PopupMenu popup=new PopupMenu(this,findViewById(R.id.menu_filter));
        //加载自定义的PopupMenu内容
        popup.getMenuInflater().inflate(R.menu.filter_tasks,popup.getMenu());
        //设置item点击监听
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.active:
                        Toast.makeText(MainActivity.this,"active",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.completed:
                        Toast.makeText(MainActivity.this,"completed",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"all",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
//        展示PopupMenu
        popup.show();
    }
}
