package com.example.c145557.minilauncher.models;

import android.graphics.drawable.Drawable;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by C145557 on 9/6/2016.
 */
public class AppInfo extends RealmObject{

    @PrimaryKey
    private String appname;
    private String pname;
    private String versionName;
    private int versionCode;

    @Ignore
    private Drawable icon;

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return appname + "\t" + pname + "\t" + versionName + "\t" + versionCode;
    }
}
