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
    public static c f29643b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29645d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29646e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29647f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29648g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29642a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29644c = true;

    public static ExecutorService a() {
        if (f29645d == null) {
            synchronized (e.class) {
                if (f29645d == null) {
                    f29645d = new a.C0314a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29645d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29645d;
    }

    public static ExecutorService b() {
        if (f29646e == null) {
            synchronized (e.class) {
                if (f29646e == null) {
                    f29646e = new a.C0314a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29646e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29646e;
    }

    public static ExecutorService c() {
        if (f29647f == null) {
            synchronized (e.class) {
                if (f29647f == null) {
                    f29647f = new a.C0314a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29647f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29647f;
    }

    public static ScheduledExecutorService d() {
        if (f29648g == null) {
            synchronized (e.class) {
                if (f29648g == null) {
                    f29648g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29648g;
    }

    public static boolean e() {
        return f29644c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29643b;
    }

    public static void a(g gVar) {
        if (f29645d == null) {
            a();
        }
        if (f29645d != null) {
            f29645d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29646e == null) {
            b();
        }
        if (f29646e != null) {
            f29646e.execute(gVar);
        }
    }

    public static void a(g gVar, int i2) {
        if (f29645d == null) {
            a();
        }
        if (f29645d != null) {
            f29645d.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        if (f29647f == null) {
            c();
        }
        if (f29647f != null) {
            f29647f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29644c = z;
    }

    public static void a(c cVar) {
        f29643b = cVar;
    }
}
