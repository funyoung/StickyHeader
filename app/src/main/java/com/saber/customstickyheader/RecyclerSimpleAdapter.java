package com.saber.customstickyheader;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


public class RecyclerSimpleAdapter extends  RecyclerView.Adapter<RecyclerSimpleAdapter.ViewHolder> {
    private final Random random = new Random();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return random.nextInt(10) + random.nextInt(10);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRows;

        ViewHolder(View itemView) {
            super(itemView);
            tvRows = itemView.findViewById(R.id.tvRows);
        }

        void bindData(int position) {
            tvRows.setText(getDataInPosition(position));
            ((ViewGroup) tvRows.getParent()).setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    private String getDataInPosition(int position) {
        return String.valueOf(position + random.nextInt(6 + 1));
    }
}
