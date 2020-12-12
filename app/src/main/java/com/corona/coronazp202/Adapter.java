package com.corona.coronazp202;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<Cocktails> data;

    // create constructor to initialize context and data sent from SearchActivity
    public Adapter(Context context, List<Cocktails> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_cocktails, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        Cocktails current = data.get(position);
        myHolder.textName.setText(current.getName());
        myHolder.textCategory.setText("Category: " + current.getCategory());
        myHolder.textTags.setText("Tags: " + current.getTags());
        myHolder.textIngredient1.setText("Ingredient 1: " + current.getIngredient1());
        myHolder.textIngredient2.setText("Ingredient 2: " + current.getIngredient2());
        myHolder.textIngredient3.setText("Ingredient 3: " + current.getIngredient3());
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textName;
        TextView textCategory;
        TextView textTags;
        TextView textIngredient1;
        TextView textIngredient2;
        TextView textIngredient3;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textKeyId);
            textCategory = (TextView) itemView.findViewById(R.id.textCategory);
            textTags = (TextView) itemView.findViewById(R.id.textTags);
            textIngredient1 = (TextView) itemView.findViewById(R.id.textIngredient1);
            textIngredient2 = (TextView) itemView.findViewById(R.id.textIngredient2);
            textIngredient3 = (TextView) itemView.findViewById(R.id.textIngredient3);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();
        }
    }
}
