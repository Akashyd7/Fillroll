package com.project.fillroll.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.project.fillroll.R;
import com.project.fillroll.adapter.PostAdapter;
import com.project.fillroll.adapter.SearchAdapter;
import com.project.fillroll.api.LunchAPI;
import com.project.fillroll.api.RetrofitClient;
import com.project.fillroll.constants.ConstantVariables;
import com.project.fillroll.model.ImageModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HelpFragment extends Fragment {

    Context context;
    RecyclerView recycler_view_search;
    ArrayList<ImageModel> list;
    SearchAdapter adapter;


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getContext();

        View view = inflater.inflate(R.layout.help_fragment, container, false);
//        recycler_view_search = view.findViewById(R.id.recycler_view_search);
        list =new ArrayList<>();
        getData();


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
                adapter =new SearchAdapter(context,model);
//                recycler_view_search.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
//                recycler_view_search.setAdapter(adapter);
            }
        }

        @Override
        public void onFailure(Call<ArrayList<ImageModel>> call, Throwable t) {
            Log.d("msg","############# error: "+t.toString());

            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

        }
    };

}



