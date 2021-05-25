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
    public static c f29540b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29542d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29543e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29544f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29545g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29539a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29541c = true;

    public static ExecutorService a() {
        if (f29542d == null) {
            synchronized (e.class) {
                if (f29542d == null) {
                    f29542d = new a.C0312a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29542d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29542d;
    }

    public static ExecutorService b() {
        if (f29543e == null) {
            synchronized (e.class) {
                if (f29543e == null) {
                    f29543e = new a.C0312a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29543e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29543e;
    }

    public static ExecutorService c() {
        if (f29544f == null) {
            synchronized (e.class) {
                if (f29544f == null) {
                    f29544f = new a.C0312a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29544f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29544f;
    }

    public static ScheduledExecutorService d() {
        if (f29545g == null) {
            synchronized (e.class) {
                if (f29545g == null) {
                    f29545g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29545g;
    }

    public static boolean e() {
        return f29541c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29540b;
    }

    public static void a(g gVar) {
        if (f29542d == null) {
            a();
        }
        if (f29542d != null) {
            f29542d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29543e == null) {
            b();
        }
        if (f29543e != null) {
            f29543e.execute(gVar);
        }
    }

    public static void a(g gVar, int i2) {
        if (f29542d == null) {
            a();
        }
        if (f29542d != null) {
            f29542d.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        if (f29544f == null) {
            c();
        }
        if (f29544f != null) {
            f29544f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29541c = z;
    }

    public static void a(c cVar) {
        f29540b = cVar;
    }
}
