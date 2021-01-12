package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f11258a;

    /* renamed from: b  reason: collision with root package name */
    private static int f11259b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f11258a == null) {
                f11258a = Executors.newScheduledThreadPool(f11259b);
            }
        }
        return f11258a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        f11259b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
