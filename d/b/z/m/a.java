package d.b.z.m;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f65740a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f65741b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f65742c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f65743d;

    /* renamed from: d.b.z.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC1809a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f65744e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.f65744e.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f65741b = availableProcessors;
        f65742c = (availableProcessors * 2) + 1;
        f65743d = new ThreadFactoryC1809a();
    }

    public static void a(Runnable runnable) {
        b().execute(runnable);
    }

    public static synchronized Executor b() {
        Executor executor;
        synchronized (a.class) {
            if (f65740a == null) {
                synchronized (a.class) {
                    if (f65740a == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, f65742c, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f65743d);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f65740a = threadPoolExecutor;
                    }
                }
            }
            executor = f65740a;
        }
        return executor;
    }
}
