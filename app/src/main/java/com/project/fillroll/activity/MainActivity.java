//package com.project.fillroll.activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Context;
//import android.os.Bundle;
//
//import com.project.fillroll.R;
//import com.project.fillroll.adapter.PostAdapter;
//import com.project.fillroll.adapter.StoryAdapter;
//
//public class MainActivity extends AppCompatActivity {
//    RecyclerView recyclerView,recycler_view;
//    Context context;
//    int [] story_images={R.drawable.story1,R.drawable.story2,R.drawable.story3,R.drawable.story4,R.drawable.story5};
//    int [] profile_images={R.drawable.post1,R.drawable.post1,R.drawable.post1,R.drawable.post1};
//    int [] post_images={R.drawable.post1,R.drawable.post2,R.drawable.post3,R.drawable.post4};
//    String[] nameList ={"joshua_I","joshua_I","joshua_I","joshua_I"};
//    String[] storyNameList ={"Your story","karennne","zackjohn","kieron_d","craig_love"};
//    String[] locationList ={"Tokyo,japan","Tokyo,japan","Tokyo,japan","Tokyo,japan"};
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        recyclerView = findViewById(R.id.recycler_view);
////        recycler_view = findViewById(R.id.recycler_view1);
//
//
//
//        setAdapter();
//        setAdapter1();
//    }
//    private void setAdapter1() {
//        PostAdapter adapter = new PostAdapter(context,post_images,profile_images,nameList,locationList);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
//        recycler_view.setLayoutManager(linearLayoutManager);
//        recycler_view.setItemAnimator(new DefaultItemAnimator());
//        recycler_view.setAdapter(adapter);
//    }
//
//    private void setAdapter() {
//        StoryAdapter adapter = new StoryAdapter(context,story_images,storyNameList);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(adapter);
//    }
//
//}