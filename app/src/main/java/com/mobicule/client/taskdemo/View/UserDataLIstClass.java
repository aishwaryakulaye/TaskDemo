package com.mobicule.client.taskdemo.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mobicule.client.taskdemo.R;

public class UserDataLIstClass extends AppCompatActivity
{
    RecyclerView userList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_list);
        userList = (RecyclerView) findViewById(R.id.list_data);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        userList.hasFixedSize();
        userList.setLayoutManager(mLayoutManager);

        userList.setAdapter(new ListAdapter(UserDataLIstClass.this));
        userList.invalidate();
    }


}
