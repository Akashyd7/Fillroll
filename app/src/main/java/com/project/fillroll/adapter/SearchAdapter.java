package com.project.fillroll.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.project.fillroll.R;
import com.project.fillroll.model.ImageModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>  {

    Context context;
    ArrayList<ImageModel> list;

    public SearchAdapter(Context context, ArrayList<ImageModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.search_item_layout, parent, false);
        SearchAdapter.ViewHolder viewHolder = new SearchAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        ImageModel pojo = list.get(position);
//        holder.name.setText(pojo.getUser().getName());
//        holder.location.setText(pojo.getUser().getLocation());




        Picasso.with(context)
                .load(pojo.getUrls().getRegular())
                .into(holder.search_image);
//        Picasso.with(context)
//                .load(pojo.getUrls().getRegular())
//                .into(holder.profile_image);


    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView search_image;
        TextView name, location;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            search_image = itemView.findViewById(R.id.search_image);

        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

}
