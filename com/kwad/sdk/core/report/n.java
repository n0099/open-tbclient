package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;
/* loaded from: classes3.dex */
public class n {
    public static String a = f();

    /* renamed from: b  reason: collision with root package name */
    public static long f56055b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static Context f56056c;

    public static String a() {
        com.kwad.sdk.core.d.a.a("ReportIdManager", ">> updateSessionId");
        String f2 = f();
        a = f2;
        return f2;
    }

    public static void a(Context context) {
        f56056c = context;
    }

    @WorkerThread
    public static boolean a(Context context, long j2) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong("seq", j2);
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
    public static boolean b(Context context, long j2) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_mplogseq", 0).edit();
            edit.putLong("seq", j2);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    public static long c() {
        long b2 = b(f56056c);
        a(f56056c, 1 + b2);
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
        synchronized (n.class) {
            c2 = c(f56056c);
            b(f56056c, 1 + c2);
        }
        return c2;
    }

    public static long e() {
        return f56055b;
    }

    public static String f() {
        return UUID.randomUUID().toString();
    }
}
