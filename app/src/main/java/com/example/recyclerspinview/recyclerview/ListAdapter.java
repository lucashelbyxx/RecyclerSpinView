package com.example.recyclerspinview.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerspinview.Adapter;
import com.example.recyclerspinview.R;
import com.example.spinview.SpinViewLayoutManger;
import com.example.spinview.RecyclerSpinView;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final int TYPE_COVER_FLOW = 1;
    private final int TYPE_TEXT = 2;

    private int mCoverFlowPosition = 0;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == TYPE_COVER_FLOW) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinflow, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPE_COVER_FLOW:
                intiCoverFlow(holder);
                break;
            case TYPE_TEXT:
                holder.text.setText(position+"");
                break;
        }
    }

    private void intiCoverFlow(final ViewHolder holder) {
        holder.coverFlow.setAdapter(new Adapter(holder.itemView.getContext(), false));
        holder.coverFlow.setOnItemSelectedListener(new SpinViewLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                mCoverFlowPosition = position;
                holder.text.setText((position+1)+"/"+holder.coverFlow.getLayoutManager().getItemCount());
            }
        });
        holder.coverFlow.scrollToPosition(mCoverFlowPosition);
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_COVER_FLOW;
        } else {
            return TYPE_TEXT;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        RecyclerSpinView coverFlow;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            coverFlow = (RecyclerSpinView) itemView.findViewById(R.id.cover_flow);
        }
    }
}
