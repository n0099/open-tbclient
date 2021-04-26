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
    public static c f30366b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f30368d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f30369e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f30370f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile ScheduledExecutorService f30371g;

    /* renamed from: a  reason: collision with root package name */
    public static final int f30365a = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f30367c = true;

    public static ExecutorService a() {
        if (f30368d == null) {
            synchronized (e.class) {
                if (f30368d == null) {
                    f30368d = new a.C0324a().a("io").a(0).b(Integer.MAX_VALUE).a(20L).a(TimeUnit.SECONDS).a(new SynchronousQueue()).a(f()).a();
                    f30368d.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f30368d;
    }

    public static ExecutorService b() {
        if (f30369e == null) {
            synchronized (e.class) {
                if (f30369e == null) {
                    f30369e = new a.C0324a().a(TbConfig.TMP_LOG_DIR_NAME).a(2).b(4).a(20L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f30369e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f30369e;
    }

    public static ExecutorService c() {
        if (f30370f == null) {
            synchronized (e.class) {
                if (f30370f == null) {
                    f30370f = new a.C0324a().a("aidl").a(0).b(4).a(5L).a(TimeUnit.SECONDS).a(new PriorityBlockingQueue()).a(f()).a();
                    f30370f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f30370f;
    }

    public static ScheduledExecutorService d() {
        if (f30371g == null) {
            synchronized (e.class) {
                if (f30371g == null) {
                    f30371g = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return f30371g;
    }

    public static boolean e() {
        return f30367c;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.l.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return f30366b;
    }

    public static void a(g gVar) {
        if (f30368d == null) {
            a();
        }
        if (f30368d != null) {
            f30368d.execute(gVar);
        }
    }

    public static void b(g gVar) {
        if (f30369e == null) {
            b();
        }
        if (f30369e != null) {
            f30369e.execute(gVar);
        }
    }

    public static void a(g gVar, int i2) {
        if (f30368d == null) {
            a();
        }
        if (f30368d != null) {
            f30368d.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        if (f30370f == null) {
            c();
        }
        if (f30370f != null) {
            f30370f.execute(gVar);
        }
    }

    public static void a(boolean z) {
        f30367c = z;
    }

    public static void a(c cVar) {
        f30366b = cVar;
    }
}
