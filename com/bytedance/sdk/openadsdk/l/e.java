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
    public static c f29453b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29455d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29456e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f29457f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f29458g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f29452a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f29454c = true;

    public static ExecutorService a() {
        if (f29455d == null) {
            synchronized (e.class) {
                if (f29455d == null) {
                    f29455d = new a.C0329a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f29455d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29455d;
    }

    public static ExecutorService b() {
        if (f29456e == null) {
            synchronized (e.class) {
                if (f29456e == null) {
                    f29456e = new a.C0329a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29456e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29456e;
    }

    public static ExecutorService c() {
        if (f29457f == null) {
            synchronized (e.class) {
                if (f29457f == null) {
                    f29457f = new a.C0329a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f29457f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f29457f;
    }

    public static ScheduledExecutorService d() {
        if (f29458g == null) {
            synchronized (e.class) {
                if (f29458g == null) {
                    f29458g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f29458g;
    }

    public static boolean e() {
        return f29454c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f29453b;
    }

    public static void a(g gVar) {
        if (f29455d == null) {
            a();
        }
        if (f29455d != null) {
            f29455d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f29456e == null) {
            b();
        }
        if (f29456e != null) {
            f29456e.execute(gVar);
        }
    }

    public static void a(g gVar, int i) {
        if (f29455d == null) {
            a();
        }
        if (f29455d != null) {
            f29455d.execute(gVar);
        }
    }

    public static void b(g gVar, int i) {
        if (f29457f == null) {
            c();
        }
        if (f29457f != null) {
            f29457f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f29454c = z;
    }

    public static void a(c cVar) {
        f29453b = cVar;
    }
}
