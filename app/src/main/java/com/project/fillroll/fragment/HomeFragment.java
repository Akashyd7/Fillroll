package com.project.fillroll.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.project.fillroll.R;
import com.project.fillroll.adapter.PostAdapter;
import com.project.fillroll.adapter.ProfileAdpter;
import com.project.fillroll.adapter.RollAdapter;
import com.project.fillroll.adapter.StoryAdapter;
import com.project.fillroll.api.ApiUtilities;
import com.project.fillroll.api.LunchAPI;
import com.project.fillroll.api.RetrofitClient;
import com.project.fillroll.constants.ConstantVariables;
import com.project.fillroll.model.ImageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView recycler_view_story,recycler_view_post;
    Context context;
    int[] story_images = {R.drawable.story1, R.drawable.story2, R.drawable.story3, R.drawable.story4, R.drawable.story5};
    int[] profile_images = {R.drawable.post1, R.drawable.post1, R.drawable.post1, R.drawable.post1};
    int[] roll = {R.drawable.roll, R.drawable.roll1, R.drawable.roll2, R.drawable.roll1};
    String[] nameList = {"joshua_I", "joshua_I", "joshua_I", "joshua_I"};
    String[] storyNameList = {"Your story", "karennne", "zackjohn", "kieron_d", "craig_love"};
    String[] locationList = {"Tokyo,japan", "Tokyo,japan", "Tokyo,japan", "Tokyo,japan"};

    ArrayList<ImageModel> list;
    GridLayoutManager manager;
    PostAdapter adapter;

    @SuppressLint("SetTextI18n")

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        recycler_view_story = view.findViewById(R.id.recycler_view_story);
        recycler_view_post = view.findViewById(R.id.recycler_view_post);
        list =new ArrayList<>();
        
        getData();
        setAdapter();

        return view;
    }


    private void getData() {
        LunchAPI infinity = RetrofitClient.getInstance(ConstantVariables.BASE_URL).create(LunchAPI.class);
        Call<ArrayList<ImageModel>> call =infinity.getImages("zLGb7ZPqbDd9GA8VJc11sUULxKsa4UCdvM3PeHXrw1M");
        call.enqueue(serverRequestCallForPhotosData);
    }

    public Callback<ArrayList<ImageModel>> serverRequestCallForPhotosData =new Callback<ArrayList<ImageModel>>() {
        @Override
        public void onResponse(Call<ArrayList<ImageModel>> call, Response<ArrayList<ImageModel>> response) {
            Log.d("msg","############# url: "+response.raw().request().url());
            if(!response.isSuccessful()){
                int responseCode =response.code();
                if(responseCode == 504){
                    Toast.makeText(context,"Server error",Toast.LENGTH_SHORT).show();
                }
                return;
            }
            if (response.code()==200){
                ArrayList<ImageModel> model=response.body();
//                Toast.makeText(context, ""+model.size(), Toast.LENGTH_SHORT).show();
                adapter =new PostAdapter(context,model);
                GridLayoutManager gridLayoutRecyclerview = new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false);
                recycler_view_post.setLayoutManager(gridLayoutRecyclerview);
                recycler_view_post.setItemAnimator(new DefaultItemAnimator());
                recycler_view_post.setAdapter(adapter);
            }
        }

        @Override
        public void onFailure(Call<ArrayList<ImageModel>> call, Throwable t) {
            Log.d("msg","############# error: "+t.toString());
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

        }
    };

//    private void setAdapter2() {
//        RollAdapter adapter = new RollAdapter(context,roll);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
//        recycler.setLayoutManager(linearLayoutManager);
//        recycler.setItemAnimator(new DefaultItemAnimator());
//        recycler.setAdapter(adapter);
//    }

//    private void setAdapter1() {
//        ProfileAdpter adapter = new ProfileAdpter(context,post);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
//        recyclerview.setLayoutManager(linearLayoutManager);
//        recyclerview.setItemAnimator(new DefaultItemAnimator());
//        recyclerview.setAdapter(adapter);
//    }
    private void setAdapter() {
        StoryAdapter adapter = new StoryAdapter(context,story_images,storyNameList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        recycler_view_story.setLayoutManager(linearLayoutManager);
        recycler_view_story.setItemAnimator(new DefaultItemAnimator());
        recycler_view_story.setAdapter(adapter);
    }


}