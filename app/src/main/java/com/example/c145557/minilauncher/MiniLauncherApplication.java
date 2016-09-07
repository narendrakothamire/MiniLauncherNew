package com.example.c145557.minilauncher;

import android.app.Application;

import com.example.c145557.minilauncher.injection.component.ApplicationComponent;
import com.example.c145557.minilauncher.injection.component.DaggerApplicationComponent;
import com.example.c145557.minilauncher.injection.module.ApplicationModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by C145557 on 9/6/2016.
 */
public class MiniLauncherApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealmConfiguration();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getmApplicationComponent() {
        return mApplicationComponent;
    }

    private void initRealmConfiguration() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
