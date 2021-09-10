package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f74766a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f74767b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f74766a == null) {
                f74766a = Executors.newScheduledThreadPool(f74767b);
            }
        }
        return f74766a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f74767b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
