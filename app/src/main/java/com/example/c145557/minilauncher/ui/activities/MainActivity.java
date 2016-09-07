package com.example.c145557.minilauncher.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.c145557.minilauncher.MiniLauncherApplication;
import com.example.c145557.minilauncher.R;
import com.example.c145557.minilauncher.data.DataManager;
import com.example.c145557.minilauncher.ui.fragments.MainFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();


    }
}
