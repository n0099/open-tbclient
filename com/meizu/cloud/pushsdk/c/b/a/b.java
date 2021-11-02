package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f67484a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f67485b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f67484a == null) {
                f67484a = Executors.newScheduledThreadPool(f67485b);
            }
        }
        return f67484a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f67485b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
