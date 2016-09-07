package com.example.c145557.minilauncher.data.remote;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;


import com.example.c145557.minilauncher.models.AppInfo;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by C145557 on 9/6/2016.
 */
public class RemoteHelper {

    private final Context context;

    @Inject
    public RemoteHelper(Context context) {
        this.context = context;
    }

    public Observable<AppInfo> getAppInfo(){
        return Observable.create(new Observable.OnSubscribe<AppInfo>() {
            @Override
            public void call(Subscriber<? super AppInfo> subscriber) {
                List<PackageInfo> packs = context.getPackageManager().getInstalledPackages(0);
                for(int i=0; i<packs.size(); i++) {
                    PackageInfo p = packs.get(i);
                    if (p.versionName == null && (p.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                        continue ;
                    }
                    AppInfo newInfo = new AppInfo();
                    newInfo.setAppname(p.applicationInfo.loadLabel(context.getPackageManager()).toString());
                    newInfo.setPname(p.packageName);
                    newInfo.setVersionName(p.versionName);
                    newInfo.setVersionCode(p.versionCode);
                    newInfo.setIcon(p.applicationInfo.loadIcon(context.getPackageManager()));
                    subscriber.onNext(newInfo);
                }

                subscriber.onCompleted();
        };
    });
}

}
