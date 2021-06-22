package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f38578a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f38579b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f38578a == null) {
                f38578a = Executors.newScheduledThreadPool(f38579b);
            }
        }
        return f38578a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f38579b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
