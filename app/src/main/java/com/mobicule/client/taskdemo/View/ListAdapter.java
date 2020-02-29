package com.mobicule.client.taskdemo.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mobicule.client.taskdemo.Model.Users;
import com.mobicule.client.taskdemo.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    Context context;
    List<Users> userListData;
    public ListAdapter(Context context, List<Users> userListData)
    {
        this.context = context;
        this.userListData = userListData;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.adapter_ldata_ist, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position)
    {
        holder.txtLogin.setText(userListData.get(position).user);
        holder.txtId.setText(userListData.get(position).id+"");
        Glide.with(context).load(userListData.get(position).avatar_url).into(holder.imgUser);


    }

    @Override
    public int getItemCount() {
        return userListData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgUser;
        TextView txtId,txtLogin;

        public ViewHolder(View itemView) {
            super(itemView);

            this.imgUser=(ImageView) itemView.findViewById(R.id.img_view);
            this.txtId = (TextView) itemView.findViewById(R.id.tvId);
            this.txtLogin = (TextView) itemView.findViewById(R.id.tvLogin);

        }
    }
}
