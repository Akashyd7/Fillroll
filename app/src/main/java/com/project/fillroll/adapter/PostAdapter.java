package com.project.fillroll.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.project.fillroll.R;
import com.project.fillroll.activity.HomeActivity;
import com.project.fillroll.fragment.HomeFragment;
import com.project.fillroll.model.ImageModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {


    Context context;
    ArrayList<ImageModel> list;

    public PostAdapter(Context context, ArrayList<ImageModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.post_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageModel pojo = list.get(position);
        holder.name.setText(pojo.getUser().getName());
        holder.location.setText(pojo.getUser().getLocation());
//        holder.no_of_likes.setText(String.valueOf(pojo.getTotal_likes()));





        Picasso.with(context)
                .load(pojo.getUrls().getRegular())
                .into(holder.post_image);
        Picasso.with(context)
                .load(pojo.getUrls().getRegular())
                .into(holder.profile_image);

//
        holder.comment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Dialog dialogMembers;
                dialogMembers = new BottomSheetDialog(context);
                dialogMembers.setContentView(R.layout.bottom_sheet_dialog_comment);
                dialogMembers.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialogMembers.setCancelable(true);


                dialogMembers.show();

            }
        });
        holder.option_icon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Dialog dialogMembers;
                dialogMembers = new BottomSheetDialog(context);
                dialogMembers.setContentView(R.layout.bottom_sheet_dialog_option);
                dialogMembers.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialogMembers.setCancelable(true);


                dialogMembers.show();

            }
        });
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView post_image, profile_image,like,liked,comment,option_icon;
        TextView name, location,no_of_likes;
        BottomSheetDialog dialog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            post_image = itemView.findViewById(R.id.post_image);
            profile_image = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            no_of_likes = itemView.findViewById(R.id.no_of_likes);
            location = itemView.findViewById(R.id.location);
            like = itemView.findViewById(R.id.like);
            liked = itemView.findViewById(R.id.liked);
            comment = itemView.findViewById(R.id.comment);
            option_icon = itemView.findViewById(R.id.option_icon);
            dialog = new BottomSheetDialog(comment.getContext());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

