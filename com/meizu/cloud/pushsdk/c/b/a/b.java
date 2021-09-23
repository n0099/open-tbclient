package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f75085a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f75086b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f75085a == null) {
                f75085a = Executors.newScheduledThreadPool(f75086b);
            }
        }
        return f75085a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f75086b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
