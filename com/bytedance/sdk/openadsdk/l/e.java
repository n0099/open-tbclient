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
    public static c f29768b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29770d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29771e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29772f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29773g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29767a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29769c = true;

    public static ExecutorService a() {
        if (f29770d == null) {
            synchronized (e.class) {
                if (f29770d == null) {
                    f29770d = new a.C0327a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29770d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29770d;
    }

    public static ExecutorService b() {
        if (f29771e == null) {
            synchronized (e.class) {
                if (f29771e == null) {
                    f29771e = new a.C0327a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29771e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29771e;
    }

    public static ExecutorService c() {
        if (f29772f == null) {
            synchronized (e.class) {
                if (f29772f == null) {
                    f29772f = new a.C0327a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29772f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29772f;
    }

    public static ScheduledExecutorService d() {
        if (f29773g == null) {
            synchronized (e.class) {
                if (f29773g == null) {
                    f29773g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29773g;
    }

    public static boolean e() {
        return f29769c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29768b;
    }

    public static void a(g gVar) {
        if (f29770d == null) {
            a();
        }
        if (f29770d != null) {
            f29770d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29771e == null) {
            b();
        }
        if (f29771e != null) {
            f29771e.execute(gVar);
        }
    }

    public static void a(g gVar, int i) {
        if (f29770d == null) {
            a();
        }
        if (f29770d != null) {
            f29770d.execute(gVar);
        }
    }

    public static void b(g gVar, int i) {
        if (f29772f == null) {
            c();
        }
        if (f29772f != null) {
            f29772f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29769c = z;
    }

    public static void a(c cVar) {
        f29768b = cVar;
    }
}
