package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Context f9658a;

    @WorkerThread
    public static long a() {
        long b2 = b(f9658a);
        a(f9658a, 1 + b2);
        return b2;
    }

    public static void a(Context context) {
        f9658a = context;
    }

    @WorkerThread
    private static boolean a(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
            edit.putLong("crashseq", j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    private static long b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }
}
