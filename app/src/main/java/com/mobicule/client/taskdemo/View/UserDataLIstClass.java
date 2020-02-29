package com.mobicule.client.taskdemo.View;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobicule.client.taskdemo.Model.Users;
import com.mobicule.client.taskdemo.R;

import java.io.IOException;
import java.util.List;

import networkhit.APIClass;
import networkhit.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataLIstClass extends AppCompatActivity
{
    RecyclerView userList;
    APIInterface apiInterface=null;
    Call<List<Users>> call = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_list);
        userList = (RecyclerView) findViewById(R.id.list_data);

        apiInterface = APIClass.getClient().create(APIInterface.class);
        call = apiInterface.doGetUserList();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        userList.hasFixedSize();
        userList.setLayoutManager(mLayoutManager);

        final ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please wait ...");
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.show();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                progressBar.dismiss();
                List<Users> data =  response.body();
                setAdapter(data);

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                call.cancel();
            }
        });

    }

    public void setAdapter(List<Users> userListData)
    {
        userList.setAdapter(new ListAdapter(UserDataLIstClass.this,userListData));
        userList.invalidate();
    }
}
