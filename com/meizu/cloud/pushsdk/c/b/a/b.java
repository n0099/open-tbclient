package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f40341a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f40342b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f40341a == null) {
                f40341a = Executors.newScheduledThreadPool(f40342b);
            }
        }
        return f40341a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i2) {
        f40342b = i2;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
