package d.a.d0.a.l;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f39876a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f39877b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f39878c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final RejectedExecutionHandler f39879d = new b();

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f39880e = new AtomicInteger(1);

        /* renamed from: d.a.d0.a.l.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0532a implements Thread.UncaughtExceptionHandler {
            public C0532a(a aVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Log.i("ThreadPoolFactory", "线程名字=" + thread.getName() + "线程crash信息", th);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "TaskScheduler #" + this.f39880e.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C0532a(this));
            return thread;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
            synchronized (this) {
                if (d.f39876a == null) {
                    LinkedBlockingQueue unused = d.f39877b = new LinkedBlockingQueue();
                    ThreadPoolExecutor unused2 = d.f39876a = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, d.f39877b, d.f39878c);
                }
            }
            d.f39876a.execute(runnable);
        }
    }

    public static ScheduledThreadPoolExecutor f(int i2) {
        return new ScheduledThreadPoolExecutor(i2, f39878c);
    }

    public static ThreadPoolExecutor g(int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f39878c);
        threadPoolExecutor.setRejectedExecutionHandler(f39879d);
        return threadPoolExecutor;
    }
}
