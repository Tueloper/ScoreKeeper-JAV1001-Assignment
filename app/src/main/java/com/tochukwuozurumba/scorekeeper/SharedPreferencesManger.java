package com.tochukwuozurumba.scorekeeper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManger {
    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;
    private static boolean initialized = false;
    public final static String PREF_NAME = "Save_Data";


    public static void init(Context context) {
        if (initialized) return;
        else {
            prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            editor = prefs.edit();
            initialized = true;
        }
    }

    public static void setInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(String key, int defValue) {
        return prefs.getInt(key, defValue);
    }

    public static void removeInt(String key) {
        editor.remove(key);
    }

    public static void RemoveAllData() {
        editor.clear().commit();
    }
}
