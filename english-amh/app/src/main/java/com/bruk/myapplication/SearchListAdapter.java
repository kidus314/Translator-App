package com.bruk.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListViewHolder> {

    private List<Definition> definitionList = new ArrayList<>();
    private Context context;

    public SearchListAdapter(List<Definition> definitionList, Context context) {
        this.definitionList = definitionList;
        this.context = context;
    }

    public void setDefinitionList(List<Definition> definitionList) {
        this.definitionList = definitionList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.definition_card, parent, false);
        return new SearchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListViewHolder holder, int position) {
        holder.getEnglishWordView().setText(definitionList.get(position).englishWord);
       // holder.getAmharicWordView().setText(definitionList.get(position).amharicWord);
        holder.getEnglishWordView().setOnClickListener(view -> {
            Intent intent = new Intent(context,DefinitionActivity.class);
            intent.putExtra("definition",definitionList.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return definitionList.size();
    }


}
