package d.a.f0.a.l;

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
    public static ThreadPoolExecutor f39862a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f39863b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f39864c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final RejectedExecutionHandler f39865d = new b();

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f39866e = new AtomicInteger(1);

        /* renamed from: d.a.f0.a.l.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0538a implements Thread.UncaughtExceptionHandler {
            public C0538a(a aVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Log.i("ThreadPoolFactory", "线程名字=" + thread.getName() + "线程crash信息", th);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "TaskScheduler #" + this.f39866e.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C0538a(this));
            return thread;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
            synchronized (this) {
                if (d.f39862a == null) {
                    LinkedBlockingQueue unused = d.f39863b = new LinkedBlockingQueue();
                    ThreadPoolExecutor unused2 = d.f39862a = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, d.f39863b, d.f39864c);
                }
            }
            d.f39862a.execute(runnable);
        }
    }

    public static ScheduledThreadPoolExecutor f(int i2) {
        return new ScheduledThreadPoolExecutor(i2, f39864c);
    }

    public static ThreadPoolExecutor g(int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f39864c);
        threadPoolExecutor.setRejectedExecutionHandler(f39865d);
        return threadPoolExecutor;
    }
}
