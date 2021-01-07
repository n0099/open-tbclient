package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f11558a;

    /* renamed from: b  reason: collision with root package name */
    private static int f11559b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f11558a == null) {
                f11558a = Executors.newScheduledThreadPool(f11559b);
            }
        }
        return f11558a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        f11559b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
