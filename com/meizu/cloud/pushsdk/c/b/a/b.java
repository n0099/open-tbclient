package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f38075a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f38076b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f38075a == null) {
                f38075a = Executors.newScheduledThreadPool(f38076b);
            }
        }
        return f38075a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        f38076b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
