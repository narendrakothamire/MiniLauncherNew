package com.example.c145557.minilauncher.ui.fragments;


import android.databinding.DataBindingUtil;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c145557.minilauncher.MiniLauncherApplication;
import com.example.c145557.minilauncher.R;
import com.example.c145557.minilauncher.adapters.MainRecyclerAdapter;
import com.example.c145557.minilauncher.base.ItemViewModel;
import com.example.c145557.minilauncher.data.DataManager;
import com.example.c145557.minilauncher.databinding.FragmentMainBinding;
import com.example.c145557.minilauncher.models.AppInfo;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @Inject
    DataManager dataManager;
    private ArrayList<AppInfo> appInfos = new ArrayList<>();
    private MainRecyclerAdapter adapter;
    private ItemViewModel.OnItemClickListener onItemClickListener = new ItemViewModel.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            Toast.makeText(getActivity(), "Clicked at" + position, Toast.LENGTH_LONG).show();
        }
    };
    private FragmentMainBinding binding;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        adapter = new MainRecyclerAdapter();
        binding.fragmentMainRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.fragmentMainRv.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
        ((MiniLauncherApplication) getActivity().getApplication()).getmApplicationComponent().inject(this);

        dataManager.getApplicationsInfo()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppInfo>() {
                    @Override
                    public void onCompleted() {
                        adapter.setItems(appInfos);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AppInfo appInfo) {
                        Log.d("Narendra", appInfo.getAppname());
                        appInfos.add(appInfo);

                    }
                });
        return binding.getRoot();
    }

}
