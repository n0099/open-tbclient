package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f34801a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f34802b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f34801a == null) {
                f34801a = Executors.newScheduledThreadPool(f34802b);
            }
        }
        return f34801a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f34802b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
