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
    public static c f29767b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29769d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29770e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29771f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29772g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29766a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29768c = true;

    public static ExecutorService a() {
        if (f29769d == null) {
            synchronized (e.class) {
                if (f29769d == null) {
                    f29769d = new a.C0326a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29769d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29769d;
    }

    public static ExecutorService b() {
        if (f29770e == null) {
            synchronized (e.class) {
                if (f29770e == null) {
                    f29770e = new a.C0326a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29770e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29770e;
    }

    public static ExecutorService c() {
        if (f29771f == null) {
            synchronized (e.class) {
                if (f29771f == null) {
                    f29771f = new a.C0326a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29771f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29771f;
    }

    public static ScheduledExecutorService d() {
        if (f29772g == null) {
            synchronized (e.class) {
                if (f29772g == null) {
                    f29772g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29772g;
    }

    public static boolean e() {
        return f29768c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29767b;
    }

    public static void a(g gVar) {
        if (f29769d == null) {
            a();
        }
        if (f29769d != null) {
            f29769d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29770e == null) {
            b();
        }
        if (f29770e != null) {
            f29770e.execute(gVar);
        }
    }

    public static void a(g gVar, int i) {
        if (f29769d == null) {
            a();
        }
        if (f29769d != null) {
            f29769d.execute(gVar);
        }
    }

    public static void b(g gVar, int i) {
        if (f29771f == null) {
            c();
        }
        if (f29771f != null) {
            f29771f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29768c = z;
    }

    public static void a(c cVar) {
        f29767b = cVar;
    }
}
