package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f11260a;

    /* renamed from: b  reason: collision with root package name */
    private static int f11261b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f11260a == null) {
                f11260a = Executors.newScheduledThreadPool(f11261b);
            }
        }
        return f11260a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        f11261b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
