package com.softbd.postrequestproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RowDataAdapter extends RecyclerView.Adapter<RowDataAdapter.RowDataViewHolder> {

    private List<ServerData.Result> listData;
    private Context context;

    public RowDataAdapter(List<ServerData.Result> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public RowDataAdapter.RowDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_content, parent, false);
        return new RowDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RowDataAdapter.RowDataViewHolder rowDataViewHolder, final int position) {
        rowDataViewHolder.titleTV.setText(listData.get(position).getTitle());
        rowDataViewHolder.cluesTV.setText(Html.fromHtml(listData.get(position).getClues()));

        rowDataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, individual_post.class);
                intent.putExtra("Title", listData.get(position).getTitle());
                intent.putExtra("Clues", listData.get(position).getClues());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class RowDataViewHolder extends RecyclerView.ViewHolder {

        TextView titleTV, cluesTV;

        public RowDataViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            cluesTV = itemView.findViewById(R.id.cluesTV);
        }
    }

}


