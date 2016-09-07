package com.example.c145557.minilauncher.viewmodels;

import android.databinding.Bindable;
import android.util.Log;

import com.example.c145557.minilauncher.base.ItemViewModel;
import com.example.c145557.minilauncher.models.AppInfo;

/**
 * Created by C145557 on 9/3/2016.
 */
public class MainItemViewModel extends ItemViewModel<AppInfo> {

    private AppInfo model;
    private int position;
    private OnItemClickListener onItemClickListener;

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void setItem(AppInfo model) {
        this.model = model;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Bindable
    public String getAppInfo() {
        Log.d("Narendra -getChar", model+"");
        if(model.getAppname() == null){
            return "";
        }else {
            return model.getAppname() + "  "+ position;
        }


    }

    public void clickHandler(){
        Log.d("Narendra", "clicked at "+ position);
        onItemClickListener.onItemClick(position);
    }
}
