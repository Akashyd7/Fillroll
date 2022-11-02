package com.project.fillroll.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.project.fillroll.R;

import java.util.Locale;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {


    Context context;
    int[] images;
    String[] storyNameList;


    public StoryAdapter(Context context, int[] images,String[] storyNameList ) {
        this.context = context;
        this.images = images;
        this.storyNameList = storyNameList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.story_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.story_image_view.setImageResource(images[position]);
        holder.name.setText(storyNameList[position]);
        holder.linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!storyNameList[position].toLowerCase().equals("your story")) {
                    holder.linear_layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar = Snackbar.make(view, storyNameList[position], Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });
                }
            }
        });
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView story_image_view;
        TextView name;
        LinearLayout linear_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            story_image_view = itemView.findViewById(R.id.story_image_view);
            name = itemView.findViewById(R.id.name);
            linear_layout = itemView.findViewById(R.id.linear_layout);
        }
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
