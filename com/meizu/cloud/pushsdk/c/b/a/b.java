package com.meizu.cloud.pushsdk.c.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f37980a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f37981b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            if (f37980a == null) {
                f37980a = Executors.newScheduledThreadPool(f37981b);
            }
        }
        return f37980a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        f37981b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
