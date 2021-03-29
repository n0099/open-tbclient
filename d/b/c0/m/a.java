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
    public static volatile Executor f42672a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42673b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42674c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f42675d;

    /* renamed from: d.b.c0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0572a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f42676e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f42676e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f42673b = availableProcessors;
        f42674c = (availableProcessors * 2) + 1;
        f42675d = new ThreadFactoryC0572a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f42672a == null) {
                synchronized (a.class) {
                    if (f42672a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f42674c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f42675d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f42672a = threadPoolExecutor;
                    }
                }
            }
            executor = f42672a;
        }
        return executor;
    }
}
