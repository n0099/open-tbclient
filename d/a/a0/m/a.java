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
    public static volatile Executor f39223a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39224b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39225c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f39226d;

    /* renamed from: d.a.a0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0500a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f39227e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f39227e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f39224b = availableProcessors;
        f39225c = (availableProcessors * 2) + 1;
        f39226d = new ThreadFactoryC0500a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f39223a == null) {
                synchronized (a.class) {
                    if (f39223a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f39225c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f39226d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f39223a = threadPoolExecutor;
                    }
                }
            }
            executor = f39223a;
        }
        return executor;
    }
}
