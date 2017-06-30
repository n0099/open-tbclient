package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class h {
    public static void a(Context context) {
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }

    public static boolean a(Context context, String str, boolean z) {
        a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static void b(Context context, String str, boolean z) {
        a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }
}
