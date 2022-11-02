package com.project.fillroll.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.fillroll.R;

public class RollAdapter  extends RecyclerView.Adapter<RollAdapter.ViewHolder> {


    Context context;
    int[] images;
    public RollAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }






    @NonNull
    @Override
    public RollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.roll_item_layout, parent, false);
        RollAdapter.ViewHolder viewHolder = new RollAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RollAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);





    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

        }
    }

}


