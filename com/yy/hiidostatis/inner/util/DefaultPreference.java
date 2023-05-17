package com.yy.hiidostatis.inner.util;
/* loaded from: classes10.dex */
public class DefaultPreference {
    public static final Object KEY = new Object();
    public static DefaultPreference instance = null;
    public static String mPrefName = "hdcommon_default_pref";
    public Preference preference = new Preference(mPrefName, false);

    public static DefaultPreference getInstance() {
        if (instance == null) {
            synchronized (KEY) {
                if (instance == null) {
                    instance = new DefaultPreference();
                }
            }
        }
        return instance;
    }

    public static Preference getPreference() {
        return getInstance().preference;
    }

    public static void setPrefName(String str) {
        mPrefName = str;
    }
}
