package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.UUID;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static String f32665a = f();

    /* renamed from: b  reason: collision with root package name */
    public static long f32666b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static Context f32667c;

    public static String a() {
        com.kwad.sdk.core.d.a.a("ReportIdManager", ">> updateSessionId");
        String f2 = f();
        f32665a = f2;
        return f2;
    }

    public static void a(Context context) {
        f32667c = context;
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
        return f32665a;
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
        long b2 = b(f32667c);
        a(f32667c, 1 + b2);
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
            c2 = c(f32667c);
            b(f32667c, 1 + c2);
        }
        return c2;
    }

    public static long e() {
        return f32666b;
    }

    public static String f() {
        return UUID.randomUUID().toString();
    }
}
