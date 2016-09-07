package com.example.c145557.minilauncher.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.example.c145557.minilauncher.data.local.DBHelper;
import com.example.c145557.minilauncher.data.remote.RemoteHelper;
import com.example.c145557.minilauncher.injection.ApplicationContext;
import com.example.c145557.minilauncher.models.AppInfo;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by C145557 on 9/6/2016.
 */
public class DataManager {

    private final Context context;
    private final DBHelper dbHelper;
    private final RemoteHelper remoteHelper;
    private final Realm realm;

    @Inject
    public DataManager(@ApplicationContext Context context, DBHelper dbHelper, RemoteHelper remoteHelper, Realm realm) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.remoteHelper = remoteHelper;
        this.realm = realm;


    }

    public Observable<AppInfo> getApplicationsInfo() {
  //      return Observable.concat(getFromLocal(), getFromRemote()).last();
        return getFromRemote();
    }

    public Observable<AppInfo> getFromRemote(){
        return remoteHelper
                .getAppInfo()
                .doOnNext(new Action1<AppInfo>() {
                    @Override
                    public void call(AppInfo appInfo) {
//                        realm.beginTransaction();
//                        realm.copyToRealm(appInfo);
//                        realm.commitTransaction();
                    }
                });
    }

    public Observable<AppInfo> getFromLocal(){
        return dbHelper.getAppsInfo();
    }
}
