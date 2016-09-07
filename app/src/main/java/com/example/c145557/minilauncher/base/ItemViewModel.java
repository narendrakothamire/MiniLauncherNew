package com.example.c145557.minilauncher.base;

/**
 * Created by C145557 on 9/2/2016.
 */
public abstract class ItemViewModel<M> extends ViewModel{

    public abstract void setPosition(int position);

    public abstract void setItem(M model);

    public abstract void setOnItemClickListener(OnItemClickListener onItemClickListener);

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
