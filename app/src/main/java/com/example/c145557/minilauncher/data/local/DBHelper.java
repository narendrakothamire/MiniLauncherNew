package com.example.c145557.minilauncher.data.local;


import com.example.c145557.minilauncher.models.AppInfo;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by C145557 on 9/6/2016.
 */
public class DBHelper {

    private final Realm realm;

    public DBHelper(Realm realm) {
        this.realm = realm;
    }

    public Observable<AppInfo> getAppsInfo() {
        return Observable.create(new Observable.OnSubscribe<AppInfo>() {
            @Override
            public void call(Subscriber<? super AppInfo> subscriber) {
                RealmResults<AppInfo> results = realm.where(AppInfo.class).findAll();
                for (int i = 0; i < results.size(); i++) {
                    subscriber.onNext(results.get(0));
                }
                subscriber.onCompleted();
            }
        });

    }
}
