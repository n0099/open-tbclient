package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f75120a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f75121b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f75120a == null) {
                f75120a = Executors.newScheduledThreadPool(f75121b);
            }
        }
        return f75120a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f75121b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
