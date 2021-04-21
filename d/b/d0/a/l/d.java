package d.b.d0.a.l;

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
    public static ThreadPoolExecutor f43389a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f43390b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f43391c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final RejectedExecutionHandler f43392d = new b();

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f43393e = new AtomicInteger(1);

        /* renamed from: d.b.d0.a.l.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0606a implements Thread.UncaughtExceptionHandler {
            public C0606a(a aVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Log.i("ThreadPoolFactory", "线程名字=" + thread.getName() + "线程crash信息", th);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "TaskScheduler #" + this.f43393e.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C0606a(this));
            return thread;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
            synchronized (this) {
                if (d.f43389a == null) {
                    LinkedBlockingQueue unused = d.f43390b = new LinkedBlockingQueue();
                    ThreadPoolExecutor unused2 = d.f43389a = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, d.f43390b, d.f43391c);
                }
            }
            d.f43389a.execute(runnable);
        }
    }

    public static ScheduledThreadPoolExecutor f(int i) {
        return new ScheduledThreadPoolExecutor(i, f43391c);
    }

    public static ThreadPoolExecutor g(int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f43391c);
        threadPoolExecutor.setRejectedExecutionHandler(f43392d);
        return threadPoolExecutor;
    }
}
