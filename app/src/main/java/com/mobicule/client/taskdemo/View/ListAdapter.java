package com.mobicule.client.taskdemo.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobicule.client.taskdemo.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    Context context;
    public ListAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.adapter_ldata_ist, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
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
