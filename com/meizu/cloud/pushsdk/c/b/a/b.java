package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes8.dex */
public class b {
    public static ExecutorService a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f57234b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (a == null) {
                a = Executors.newScheduledThreadPool(f57234b);
            }
        }
        return a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f57234b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
