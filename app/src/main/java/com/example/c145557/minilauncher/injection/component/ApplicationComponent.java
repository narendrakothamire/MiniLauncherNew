package com.example.c145557.minilauncher.injection.component;

import android.app.Application;
import android.content.Context;

import com.example.c145557.minilauncher.data.DataManager;
import com.example.c145557.minilauncher.data.local.DBHelper;
import com.example.c145557.minilauncher.data.remote.RemoteHelper;
import com.example.c145557.minilauncher.injection.ApplicationContext;
import com.example.c145557.minilauncher.injection.module.ApplicationModule;
import com.example.c145557.minilauncher.ui.activities.MainActivity;
import com.example.c145557.minilauncher.ui.fragments.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by C145557 on 9/6/2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)

public interface ApplicationComponent {

    void inject(MainFragment fragment);

    @ApplicationContext Context context();
    Application application();
    RemoteHelper remoteHelper();
    DBHelper dbHelper();
    DataManager dataManager();
}
