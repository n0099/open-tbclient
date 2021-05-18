package d.a.a0.m;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f38468a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f38469b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f38470c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f38471d;

    /* renamed from: d.a.a0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0487a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f38472e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f38472e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f38469b = availableProcessors;
        f38470c = (availableProcessors * 2) + 1;
        f38471d = new ThreadFactoryC0487a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f38468a == null) {
                synchronized (a.class) {
                    if (f38468a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f38470c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f38471d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f38468a = threadPoolExecutor;
                    }
                }
            }
            executor = f38468a;
        }
        return executor;
    }
}
