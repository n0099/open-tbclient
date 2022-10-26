package com.kwad.sdk.utils;

import android.content.Context;
/* loaded from: classes8.dex */
public final class bb {
    public static void a(long j, int i, Context context) {
        if (j == 0 || context == null) {
            return;
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        (Math.abs(currentTimeMillis) / 3600000 > ((long) i) ? context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong("key_time_diff_s2c", currentTimeMillis) : context.getSharedPreferences("ksadsdk_pref", 0).edit().remove("key_time_diff_s2c")).apply();
    }

    public static long dz(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong("key_time_diff_s2c", 0L);
            if (j != 0) {
                return currentTimeMillis + j;
            }
        }
        return Math.abs(currentTimeMillis);
    }
}
