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
    public static volatile Executor f43272a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f43273b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f43274c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f43275d;

    /* renamed from: d.a.c0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0572a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f43276e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f43276e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f43273b = availableProcessors;
        f43274c = (availableProcessors * 2) + 1;
        f43275d = new ThreadFactoryC0572a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f43272a == null) {
                synchronized (a.class) {
                    if (f43272a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f43274c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f43275d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f43272a = threadPoolExecutor;
                    }
                }
            }
            executor = f43272a;
        }
        return executor;
    }
}
