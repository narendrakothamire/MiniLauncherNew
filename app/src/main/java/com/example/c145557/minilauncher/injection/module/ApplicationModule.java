package com.example.c145557.minilauncher.injection.module;

import android.app.Application;
import android.content.Context;

import com.example.c145557.minilauncher.data.DataManager;
import com.example.c145557.minilauncher.data.local.DBHelper;
import com.example.c145557.minilauncher.data.remote.RemoteHelper;
import com.example.c145557.minilauncher.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by C145557 on 9/6/2016.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }


    @Singleton
    @Provides
    RemoteHelper providesRemoteHelper(){
        return new RemoteHelper(mApplication);
    }

    @Singleton
    @Provides
    DBHelper providesDBHelper(Realm realm){
        return new DBHelper(realm);
    }

    @Singleton
    @Provides
    DataManager proviesDataManager(@ApplicationContext  Context context, DBHelper dbHelper, RemoteHelper remoteHelper, Realm realm){
        return new DataManager(context, dbHelper, remoteHelper, realm);
    }

}