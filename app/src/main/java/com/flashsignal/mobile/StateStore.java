package com.flashsignal.mobile;

import android.content.Context;
import android.content.SharedPreferences;

final class StateStore {
    private static final String PREF = "flash_signal_mobile";
    private static final String KEY_STATE = "state_json";
    private static final String KEY_ALL = "all_matches_mode";
    private static final String KEY_ENABLED = "enabled";

    private StateStore() {}

    static SharedPreferences prefs(Context c) {
        return c.getSharedPreferences(PREF, Context.MODE_PRIVATE);
    }

    static String getState(Context c) {
        return prefs(c).getString(KEY_STATE,
                "{\"enabled\":true,\"allMatchesMode\":false,\"monitorStatus\":\"Başlatılıyor\",\"matches\":[],\"stats\":[],\"signals\":[]}");
    }

    static void setState(Context c, String json) {
        prefs(c).edit().putString(KEY_STATE, json).apply();
    }

    static boolean isAllMatchesMode(Context c) {
        return prefs(c).getBoolean(KEY_ALL, false);
    }

    static void setAllMatchesMode(Context c, boolean value) {
        prefs(c).edit().putBoolean(KEY_ALL, value).apply();
    }

    static boolean isEnabled(Context c) {
        return prefs(c).getBoolean(KEY_ENABLED, true);
    }

    static void setEnabled(Context c, boolean value) {
        prefs(c).edit().putBoolean(KEY_ENABLED, value).apply();
    }
}
