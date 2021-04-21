package com.bytedance.sdk.openadsdk.l;

import com.baidu.tbadk.TbConfig;
import com.bytedance.sdk.openadsdk.l.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static c f29461b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29463d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29464e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29465f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29466g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29460a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29462c = true;

    public static ExecutorService a() {
        if (f29463d == null) {
            synchronized (e.class) {
                if (f29463d == null) {
                    f29463d = new a.C0331a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29463d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29463d;
    }

    public static ExecutorService b() {
        if (f29464e == null) {
            synchronized (e.class) {
                if (f29464e == null) {
                    f29464e = new a.C0331a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29464e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29464e;
    }

    public static ExecutorService c() {
        if (f29465f == null) {
            synchronized (e.class) {
                if (f29465f == null) {
                    f29465f = new a.C0331a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29465f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29465f;
    }

    public static ScheduledExecutorService d() {
        if (f29466g == null) {
            synchronized (e.class) {
                if (f29466g == null) {
                    f29466g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29466g;
    }

    public static boolean e() {
        return f29462c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29461b;
    }

    public static void a(g gVar) {
        if (f29463d == null) {
            a();
        }
        if (f29463d != null) {
            f29463d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29464e == null) {
            b();
        }
        if (f29464e != null) {
            f29464e.execute(gVar);
        }
    }

    public static void a(g gVar, int i) {
        if (f29463d == null) {
            a();
        }
        if (f29463d != null) {
            f29463d.execute(gVar);
        }
    }

    public static void b(g gVar, int i) {
        if (f29465f == null) {
            c();
        }
        if (f29465f != null) {
            f29465f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29462c = z;
    }

    public static void a(c cVar) {
        f29461b = cVar;
    }
}
