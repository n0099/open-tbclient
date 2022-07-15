package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* loaded from: classes5.dex */
public final class d {
    public static Context a;

    @WorkerThread
    public static long a() {
        long b = b(a);
        a(a, 1 + b);
        return b;
    }

    public static void a(Context context) {
        a = context;
    }

    @WorkerThread
    public static boolean a(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
            edit.putLong("crashseq", j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    public static long b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }
}
