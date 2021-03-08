package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static String f6253a = g();
    private static long b = 0;
    private static Context c;

    public static String a() {
        com.kwad.sdk.core.d.a.a("ReportIdManager", ">> updateSessionId");
        f6253a = g();
        return f6253a;
    }

    public static void a(Context context) {
        c = context;
    }

    @WorkerThread
    private static boolean a(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong("seq", j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    private static long b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    public static String b() {
        return f6253a;
    }

    @WorkerThread
    private static boolean b(Context context, long j) {
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
    private static long c(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_mplogseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    @WorkerThread
    public static synchronized long d() {
        long c2;
        synchronized (m.class) {
            c2 = c(c);
            b(c, 1 + c2);
        }
        return c2;
    }

    public static long e() {
        com.kwad.sdk.core.d.a.a("ReportIdManager", ">> updateListId");
        b = System.currentTimeMillis();
        return b;
    }

    public static long f() {
        return b;
    }

    private static String g() {
        return UUID.randomUUID().toString();
    }
}
