package d.b.a0.m;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f42042a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42043b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42044c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f42045d;

    /* renamed from: d.b.a0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0561a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f42046e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f42046e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f42043b = availableProcessors;
        f42044c = (availableProcessors * 2) + 1;
        f42045d = new ThreadFactoryC0561a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f42042a == null) {
                synchronized (a.class) {
                    if (f42042a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f42044c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f42045d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f42042a = threadPoolExecutor;
                    }
                }
            }
            executor = f42042a;
        }
        return executor;
    }
}
