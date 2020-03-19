# RecyclerView 添加及使用



## 1. Add the androidx library

```
implementation 'androidx.recyclerview:recyclerview:1.0.0'
```



## 2. Add RecyclerView to your layout

```xml
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/rv_main_content"
    android:layout_width="0dp"
    android:layout_height="0dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```



## 3. Add a list adapter

```java
mMainRecyclerView = findViewById(R.id.rv_main_content);
// use this setting to improve performance if you know that changes
// in content do not change the layout size of the RecyclerView
mMainRecyclerView.setHasFixedSize(true);

mLayoutManager = new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL);
mMainRecyclerView.setLayoutManager(mLayoutManager);

mMainAdapter = new MainAdapter(mDataSet);
mMainRecyclerView.setAdapter(mMainAdapter);
```



```java
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private String[] mDataSet;

    public MainAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        return new MyViewHolder(v);
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
```

