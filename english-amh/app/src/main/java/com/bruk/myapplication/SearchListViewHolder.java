package com.bruk.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchListViewHolder extends RecyclerView.ViewHolder {
    private TextView englishWordView;
    private TextView amharicWordView;

    public SearchListViewHolder(@NonNull View itemView) {
        super(itemView);
        englishWordView = itemView.findViewById(R.id.englishWord);
        amharicWordView = itemView.findViewById(R.id.amharicWord);
    }

    public TextView getAmharicWordView() {
        return amharicWordView;
    }

    public TextView getEnglishWordView() {
        return englishWordView;
    }
}
