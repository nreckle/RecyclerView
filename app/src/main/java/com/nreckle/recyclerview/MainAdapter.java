package com.nreckle.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nreckle.recyclerview.databinding.MyTextViewBinding;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private String[] mDataSet;

    public MainAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyTextViewBinding binding = MyTextViewBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding.text);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }
}
