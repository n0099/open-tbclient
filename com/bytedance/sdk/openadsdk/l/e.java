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
    public static c f29611b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29613d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29614e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29615f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29616g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29610a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29612c = true;

    public static ExecutorService a() {
        if (f29613d == null) {
            synchronized (e.class) {
                if (f29613d == null) {
                    f29613d = new a.C0311a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29613d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29613d;
    }

    public static ExecutorService b() {
        if (f29614e == null) {
            synchronized (e.class) {
                if (f29614e == null) {
                    f29614e = new a.C0311a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29614e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29614e;
    }

    public static ExecutorService c() {
        if (f29615f == null) {
            synchronized (e.class) {
                if (f29615f == null) {
                    f29615f = new a.C0311a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29615f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29615f;
    }

    public static ScheduledExecutorService d() {
        if (f29616g == null) {
            synchronized (e.class) {
                if (f29616g == null) {
                    f29616g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29616g;
    }

    public static boolean e() {
        return f29612c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29611b;
    }

    public static void a(g gVar) {
        if (f29613d == null) {
            a();
        }
        if (f29613d != null) {
            f29613d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29614e == null) {
            b();
        }
        if (f29614e != null) {
            f29614e.execute(gVar);
        }
    }

    public static void a(g gVar, int i2) {
        if (f29613d == null) {
            a();
        }
        if (f29613d != null) {
            f29613d.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        if (f29615f == null) {
            c();
        }
        if (f29615f != null) {
            f29615f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29612c = z;
    }

    public static void a(c cVar) {
        f29611b = cVar;
    }
}
