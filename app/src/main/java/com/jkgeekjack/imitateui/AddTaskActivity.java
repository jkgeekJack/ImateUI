package com.jkgeekjack.imitateui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AddTaskActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_task);
        toolbar= (Toolbar) findViewById(R.id.tl_custom);
        toolbar.setTitle("Add Task");
        setSupportActionBar(toolbar);
    }
}
