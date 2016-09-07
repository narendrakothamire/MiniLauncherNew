package com.example.c145557.minilauncher.adapters;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.c145557.minilauncher.BR;
import com.example.c145557.minilauncher.R;
import com.example.c145557.minilauncher.base.RecyclerViewAdapter;
import com.example.c145557.minilauncher.databinding.MainListItemBinding;
import com.example.c145557.minilauncher.models.AppInfo;
import com.example.c145557.minilauncher.viewmodels.MainItemViewModel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by C145557 on 9/3/2016.
 */
public class MainRecyclerAdapter extends RecyclerViewAdapter<AppInfo, MainItemViewModel, MainRecyclerAdapter.MainItemViewHolder> {

   // private static final ArrayList<Character> alphaitems = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    public MainRecyclerAdapter(ArrayList<AppInfo> items) {
        super(items);
    }

    public MainRecyclerAdapter() {
    }

    @Override
    public MainItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainListItemBinding mainListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.main_list_item, parent, false);
        MainItemViewModel mainItemViewModel = new MainItemViewModel();
        mainItemViewModel.setOnItemClickListener(onItemClickListener);
        MainItemViewHolder mainItemViewHolder = new MainItemViewHolder(mainListItemBinding, mainItemViewModel);

        return mainItemViewHolder;
    }


    static class MainItemViewHolder extends RecyclerViewAdapter.ItemViewHolder<AppInfo, MainItemViewModel>{

        public MainItemViewHolder(MainListItemBinding dataBinding, MainItemViewModel viewModel) {
            super(dataBinding, viewModel, BR.viewmodel);
        }


    }

}
