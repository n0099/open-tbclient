package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.UUID;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static String f34783a = g();

    /* renamed from: b  reason: collision with root package name */
    public static long f34784b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static Context f34785c;

    public static String a() {
        com.kwad.sdk.core.d.a.a("ReportIdManager", ">> updateSessionId");
        String g2 = g();
        f34783a = g2;
        return g2;
    }

    public static void a(Context context) {
        f34785c = context;
    }

    @WorkerThread
    public static boolean a(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong(IAdRequestParam.SEQ, j);
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
        return sharedPreferences.getLong(IAdRequestParam.SEQ, 1L);
    }

    public static String b() {
        return f34783a;
    }

    @WorkerThread
    public static boolean b(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_mplogseq", 0).edit();
            edit.putLong(IAdRequestParam.SEQ, j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    public static long c() {
        long b2 = b(f34785c);
        a(f34785c, 1 + b2);
        return b2;
    }

    @WorkerThread
    public static long c(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_mplogseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(IAdRequestParam.SEQ, 1L);
    }

    @WorkerThread
    public static synchronized long d() {
        long c2;
        synchronized (m.class) {
            c2 = c(f34785c);
            b(f34785c, 1 + c2);
        }
        return c2;
    }

    public static long e() {
        com.kwad.sdk.core.d.a.a("ReportIdManager", ">> updateListId");
        long currentTimeMillis = System.currentTimeMillis();
        f34784b = currentTimeMillis;
        return currentTimeMillis;
    }

    public static long f() {
        return f34784b;
    }

    public static String g() {
        return UUID.randomUUID().toString();
    }
}
