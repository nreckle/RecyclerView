package com.nreckle.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nreckle.recyclerview.databinding.ItemViewBinding;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private List<DataModel> dataModelList;

    public MainAdapter(List<DataModel> dataModels) {
        dataModelList = dataModels;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding = ItemViewBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        DataModel dataModel = dataModelList.get(position);
        holder.itemViewBinding.setDataModel(dataModel);
        holder.bind(dataModel);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final ItemViewBinding itemViewBinding;

        public MyViewHolder(ItemViewBinding itemViewBinding) {
            super(itemViewBinding.getRoot());
            this.itemViewBinding = itemViewBinding;
        }

        public void bind(Object obj) {
            itemViewBinding.setVariable(BR.dataModel, obj);
            itemViewBinding.executePendingBindings();
        }
    }
}
