package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Context f34874a;

    @WorkerThread
    public static long a() {
        long b2 = b(f34874a);
        a(f34874a, 1 + b2);
        return b2;
    }

    public static void a(Context context) {
        f34874a = context;
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
