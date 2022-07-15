package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class ax {
    public static long a(@Nullable Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong("key_time_diff_s2c", 0L);
            if (j != 0) {
                return currentTimeMillis + j;
            }
        }
        return Math.abs(currentTimeMillis);
    }

    public static void a(long j, int i, @Nullable Context context) {
        if (j == 0 || context == null) {
            return;
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        (Math.abs(currentTimeMillis) / 3600000 > ((long) i) ? context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong("key_time_diff_s2c", currentTimeMillis) : context.getSharedPreferences("ksadsdk_pref", 0).edit().remove("key_time_diff_s2c")).apply();
    }
}
