package com.solution.sessionmanagementpro.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private final Context context;
    SharedPreferences.Editor prefsEditor;
    SharedPreferences sharedpreferences;


    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedpreferences.getString(key, "");
    }

    public void clearPreferences() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
    }




    public SharedPref(Context context) {
        this.context = context;
        sharedpreferences = context.getSharedPreferences("Unipay", Context.MODE_PRIVATE);
        prefsEditor = sharedpreferences.edit();
    }



    public void login(Context context, boolean connected) {
        sharedpreferences = context.getSharedPreferences("Unipay", 0);
        prefsEditor = sharedpreferences.edit();
        prefsEditor.putBoolean("connected", connected);
        prefsEditor.commit();
    }

    public boolean isLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Unipay", 0);
        return sharedPreferences.getBoolean("connected", false);
    }
}