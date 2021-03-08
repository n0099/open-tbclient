package com.bytedance.sdk.openadsdk.j;

import com.bytedance.sdk.openadsdk.j.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class e {
    public static c b;
    private static volatile ThreadPoolExecutor d;
    private static volatile ThreadPoolExecutor e;
    private static volatile ScheduledExecutorService f;

    /* renamed from: a  reason: collision with root package name */
    public static final int f4866a = Runtime.getRuntime().availableProcessors();
    public static boolean c = true;

    public static ExecutorService a() {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new a.C1038a().a("io").a(2).b(8).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(e()).a();
                    d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return d;
    }

    public static void a(g gVar) {
        if (d == null) {
            a();
        }
        if (d != null) {
            d.execute(gVar);
        }
    }

    public static void a(final Runnable runnable, int i) {
        if (d == null) {
            a();
        }
        if (d != null) {
            d.execute(new g(i) { // from class: com.bytedance.sdk.openadsdk.j.e.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public static void b(final Runnable runnable, int i) {
        if (e == null) {
            b();
        }
        if (e != null) {
            e.execute(new g(i) { // from class: com.bytedance.sdk.openadsdk.j.e.2
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public static ExecutorService b() {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new a.C1038a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(e()).a();
                    e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return e;
    }

    public static ScheduledExecutorService c() {
        if (f == null) {
            synchronized (e.class) {
                if (f == null) {
                    f = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f;
    }

    public static boolean d() {
        return c;
    }

    public static void a(boolean z) {
        c = z;
    }

    public static RejectedExecutionHandler e() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.j.e.3
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c f() {
        return b;
    }

    public static void a(c cVar) {
        b = cVar;
    }
}
