package com.nreckle.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mMainRecyclerView;
    private MainAdapter mMainAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataSet = {"adfafda", "afafdafefa", "geafdafae",
            "eteareafadsfafa", "meiwnofenaofe", "zeafeljo",
            "afdafae", "tereafadsfafa", "wnofenaofe", "zeafeljo",
            "geafdafae", "etearfadsfafa", "meiofenaofe", "eljo",
            "geaffae", "etearefadsfafa", "meiwfenaofe", "zeaeljo",
            "geafae", "eareafadsfafa", "meiofenaofe", "zefeljo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainRecyclerView = findViewById(R.id.rv_main_content);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mMainRecyclerView.setHasFixedSize(true);

//        mLayoutManager = new LinearLayoutManager(this);
//        mLayoutManager = new GridLayoutManager(this, 2);
        mLayoutManager = new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL);
        mMainRecyclerView.setLayoutManager(mLayoutManager);

        mMainAdapter = new MainAdapter(mDataSet);
        mMainRecyclerView.setAdapter(mMainAdapter);
    }
}
