package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class b {
    public static ExecutorService a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f42072b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (a == null) {
                a = Executors.newScheduledThreadPool(f42072b);
            }
        }
        return a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        f42072b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
