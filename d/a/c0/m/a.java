package d.a.c0.m;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f39488a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39489b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39490c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f39491d;

    /* renamed from: d.a.c0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0513a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f39492e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f39492e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f39489b = availableProcessors;
        f39490c = (availableProcessors * 2) + 1;
        f39491d = new ThreadFactoryC0513a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f39488a == null) {
                synchronized (a.class) {
                    if (f39488a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f39490c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f39491d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f39488a = threadPoolExecutor;
                    }
                }
            }
            executor = f39488a;
        }
        return executor;
    }
}
