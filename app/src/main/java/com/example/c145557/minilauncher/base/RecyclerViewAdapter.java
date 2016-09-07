package com.example.c145557.minilauncher.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;

import com.example.c145557.minilauncher.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C145557 on 9/2/2016.
 */
public abstract class RecyclerViewAdapter<M, VM extends ItemViewModel<M>, VH extends RecyclerViewAdapter.ItemViewHolder> extends RecyclerView.Adapter<VH> {

    ArrayList<M> items;
    protected ItemViewModel.OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(ArrayList<M> items) {
        this.items = items;
    }

    public ArrayList<M> getItems() {
        return items;
    }

    public void setItems(ArrayList<M> items) {
        this.items = items;
    }

    public void setOnItemClickListener(ItemViewModel.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        int count = items != null ? items.size() : 0;
        return count;
    }

    @CallSuper
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.setPosition(position);
        holder.setItem(items.get(position));
    }

    @Override
    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        holder.setPosition(position);
        holder.setItem(items.get(position));
    }

    public abstract static class ItemViewHolder<M, VM extends ItemViewModel<M>> extends RecyclerView.ViewHolder{

        protected ViewDataBinding dataBinding;
        protected VM viewModel;
        protected final int variable;

        public ItemViewHolder(ViewDataBinding dataBinding, VM viewModel, int variable) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
            this.viewModel = viewModel;
            this.variable = variable;
        }

        public void setItem(M model){
            dataBinding.setVariable(variable, viewModel);
            viewModel.setItem(model);
            dataBinding.executePendingBindings();
        }

        public void setPosition(int position){
            viewModel.setPosition(position);
        }

    }

}
