package com.example.novy.emailsender;

import android.app.Application;

import com.example.novy.emailsender.infrastructure.di.Dagger_MainComponent;
import com.example.novy.emailsender.infrastructure.di.MainComponent;

import dagger.Component;

/**
 * Created by novy on 26.02.15.
 */
public class EmailSenderApplication extends Application {

    private MainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = Dagger_MainComponent
                .create();

        component.inject(this);
    }

    public MainComponent component() {
        return component;
    }
}
