package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f4384a;
    private static int b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f4384a == null) {
                f4384a = Executors.newScheduledThreadPool(b);
            }
        }
        return f4384a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
