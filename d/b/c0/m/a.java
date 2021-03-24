package d.b.c0.m;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f42671a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42672b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42673c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f42674d;

    /* renamed from: d.b.c0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0571a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f42675e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f42675e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f42672b = availableProcessors;
        f42673c = (availableProcessors * 2) + 1;
        f42674d = new ThreadFactoryC0571a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f42671a == null) {
                synchronized (a.class) {
                    if (f42671a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f42673c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f42674d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f42671a = threadPoolExecutor;
                    }
                }
            }
            executor = f42671a;
        }
        return executor;
    }
}
