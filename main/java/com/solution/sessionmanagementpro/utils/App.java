package com.solution.sessionmanagementpro.utils;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App instance;
    private static SharedPref sharedpref;
    private static Singleton singleton;
    Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        sharedpref = new SharedPref(context);
        singleton = new Singleton();
    }

    public static SharedPref getSharedpref()
    {
        return sharedpref;
    }

    public static Singleton getSingleton() {
        return singleton;

    }

    public static App getAppContext() {
        return instance;
    }

}

