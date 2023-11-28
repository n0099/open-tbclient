package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* loaded from: classes10.dex */
public final class e {
    public static Context awX;

    @WorkerThread
    public static long DK() {
        long bg = bg(awX);
        b(awX, 1 + bg);
        return bg;
    }

    @WorkerThread
    public static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        edit.putLong("crashseq", j);
        return edit.commit();
    }

    @WorkerThread
    public static long bg(Context context) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) != null) {
            return sharedPreferences.getLong("crashseq", 1L);
        }
        return 0L;
    }

    public static void init(Context context) {
        awX = context;
    }
}
