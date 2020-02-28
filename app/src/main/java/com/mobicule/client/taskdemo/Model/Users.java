package com.mobicule.client.taskdemo.Model;

import com.google.gson.annotations.SerializedName;

public class Users
{
    @SerializedName("login")
    public String user;

    @SerializedName("id")
    public String id;

    @SerializedName("avatar_url")
    public String avatar_url;

}
