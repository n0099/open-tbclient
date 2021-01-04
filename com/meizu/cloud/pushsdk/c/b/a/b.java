package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f11557a;

    /* renamed from: b  reason: collision with root package name */
    private static int f11558b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f11557a == null) {
                f11557a = Executors.newScheduledThreadPool(f11558b);
            }
        }
        return f11557a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        f11558b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
