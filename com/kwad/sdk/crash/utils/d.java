package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* loaded from: classes8.dex */
public final class d {
    public static Context ab;

    @WorkerThread
    public static long by(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    @WorkerThread
    public static boolean d(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
            edit.putLong("crashseq", j);
            return edit.commit();
        }
        return false;
    }

    public static void init(Context context) {
        ab = context;
    }

    @WorkerThread
    public static long uH() {
        long by = by(ab);
        d(ab, 1 + by);
        return by;
    }
}
