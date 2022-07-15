package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class s {
    public static String a = f();
    public static long b = 0;
    public static Context c;

    public static String a() {
        com.kwad.sdk.core.d.b.a("ReportIdManager", ">> updateSessionId");
        String f = f();
        a = f;
        return f;
    }

    public static void a(Context context) {
        c = context;
    }

    @WorkerThread
    public static boolean a(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong("seq", j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    public static long b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    public static String b() {
        return a;
    }

    @WorkerThread
    public static boolean b(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_mplogseq", 0).edit();
            edit.putLong("seq", j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    public static long c() {
        long b2 = b(c);
        a(c, 1 + b2);
        return b2;
    }

    @WorkerThread
    public static long c(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_mplogseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    @WorkerThread
    public static synchronized long d() {
        long c2;
        synchronized (s.class) {
            c2 = c(c);
            b(c, 1 + c2);
        }
        return c2;
    }

    public static long e() {
        return b;
    }

    public static String f() {
        return UUID.randomUUID().toString();
    }
}
