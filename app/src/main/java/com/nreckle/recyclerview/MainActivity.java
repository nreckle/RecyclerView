package com.nreckle.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.nreckle.recyclerview.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainAdapter mMainAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<DataModel> mDataModels = Arrays.asList(
            new DataModel("adfafda", "afafdafefa"),
            new DataModel("geafdafae", "eteareafadsfafa"),
            new DataModel("meiwnofenaofe", "zeafeljo"),
            new DataModel("afdafae", "tereafadsfafa"),
            new DataModel("wnofenaofe", "zeafeljo"),
            new DataModel("geafdafae", "etearfadsfafa"),
            new DataModel("meiofenaofe", "eljo"),
            new DataModel("geaffae", "etearefadsfafa"),
            new DataModel("meiwfenaofe", "zeaeljo"),
            new DataModel("geafae", "eareafadsfafa"),
            new DataModel("meiofenaofe", "zefeljo")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        activityMainBinding.rvMainContent.setHasFixedSize(true);

//        mLayoutManager = new LinearLayoutManager(this);
//        mLayoutManager = new GridLayoutManager(this, 2);
        mLayoutManager = new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL);
        activityMainBinding.rvMainContent.setLayoutManager(mLayoutManager);

        mMainAdapter = new MainAdapter(mDataModels);
        activityMainBinding.rvMainContent.setAdapter(mMainAdapter);
    }
}
