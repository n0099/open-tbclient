package com.bytedance.sdk.openadsdk.k;

import com.bytedance.sdk.openadsdk.utils.u;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f7313a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f7314b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ThreadPoolExecutor d;
    private static volatile ThreadPoolExecutor e;
    private static volatile ScheduledExecutorService f;
    private static ConcurrentHashMap<String, c> g;
    private static final ConcurrentHashMap<String, c> h = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, c> i = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, c> j = new ConcurrentHashMap<>();
    private static final AtomicBoolean k = new AtomicBoolean();

    public static void a(boolean z) {
        if (!k.get()) {
            f7314b = e.a();
            c = e.b();
            f = e.c();
            e = e.e();
            if (z) {
                d = e.d();
                g = new ConcurrentHashMap<>();
            }
            k.set(true);
        }
    }

    public static a a() {
        if (f7313a == null) {
            synchronized (a.class) {
                if (f7313a == null) {
                    f7313a = new a();
                }
            }
        }
        return f7313a;
    }

    private a() {
        if (!k.get()) {
            a(false);
        }
    }

    public ExecutorService b() {
        if (e == null) {
            e = e.e();
        }
        return e;
    }

    public void a(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (u.c()) {
                u.f("", "executeAIDLTask -> runnable param is not be null");
                return;
            }
            return;
        }
        c();
        d.execute(new c(i2) { // from class: com.bytedance.sdk.openadsdk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    private void c() {
        if (d == null) {
            d = e.d();
            g = new ConcurrentHashMap<>();
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            if (u.c()) {
                u.f("", "executeApiTask->TTRunnable param is not be null");
            }
        } else if (f7314b != null) {
            f7314b.execute(cVar);
        }
    }

    public void b(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (u.c()) {
                u.f("", "executeApiTask->runnable param is not be null");
            }
        } else if (f7314b != null) {
            f7314b.execute(new c(i2) { // from class: com.bytedance.sdk.openadsdk.k.a.2
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public void b(c cVar) {
        if (cVar == null) {
            if (u.c()) {
                u.f("", "executeDefaultTask -> runnable param is not be null");
            }
        } else if (c != null) {
            c.execute(cVar);
        }
    }

    public void c(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (u.c()) {
                u.f("", "executeDefaultTask -> runnable param is not be null");
            }
        } else if (c != null) {
            c.execute(new c(i2) { // from class: com.bytedance.sdk.openadsdk.k.a.3
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public void d(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (u.c()) {
                u.f("", "executeLogUploadTask（Runnable） -> runnable param is not be null");
            }
        } else if (e != null) {
            e.execute(new c(i2) { // from class: com.bytedance.sdk.openadsdk.k.a.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public void a(c cVar, long j2) {
        if (cVar == null) {
            if (u.c()) {
                u.f("", "scheduleWithFixedDelayTask->TTRunnable param is not be null");
            }
        } else if (j2 <= 0) {
            f.execute(cVar);
        } else {
            f.scheduleWithFixedDelay(cVar, 0L, j2, TimeUnit.MILLISECONDS);
        }
    }

    public ScheduledFuture<?> a(Runnable runnable, long j2) {
        if (runnable == null) {
            if (u.c()) {
                u.f("", "delayExecuteTask->runnable param is not be null");
                return null;
            }
            return null;
        } else if (j2 <= 0) {
            f.execute(runnable);
            return null;
        } else {
            return f.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }
}
