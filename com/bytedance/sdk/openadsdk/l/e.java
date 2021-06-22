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
/* loaded from: classes6.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static c f29725b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29727d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29728e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29729f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29730g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29724a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29726c = true;

    public static ExecutorService a() {
        if (f29727d == null) {
            synchronized (e.class) {
                if (f29727d == null) {
                    f29727d = new a.C0317a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29727d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29727d;
    }

    public static ExecutorService b() {
        if (f29728e == null) {
            synchronized (e.class) {
                if (f29728e == null) {
                    f29728e = new a.C0317a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29728e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29728e;
    }

    public static ExecutorService c() {
        if (f29729f == null) {
            synchronized (e.class) {
                if (f29729f == null) {
                    f29729f = new a.C0317a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29729f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29729f;
    }

    public static ScheduledExecutorService d() {
        if (f29730g == null) {
            synchronized (e.class) {
                if (f29730g == null) {
                    f29730g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29730g;
    }

    public static boolean e() {
        return f29726c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29725b;
    }

    public static void a(g gVar) {
        if (f29727d == null) {
            a();
        }
        if (f29727d != null) {
            f29727d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29728e == null) {
            b();
        }
        if (f29728e != null) {
            f29728e.execute(gVar);
        }
    }

    public static void a(g gVar, int i2) {
        if (f29727d == null) {
            a();
        }
        if (f29727d != null) {
            f29727d.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        if (f29729f == null) {
            c();
        }
        if (f29729f != null) {
            f29729f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29726c = z;
    }

    public static void a(c cVar) {
        f29725b = cVar;
    }
}
