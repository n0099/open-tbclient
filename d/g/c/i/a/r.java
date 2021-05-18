package d.g.c.i.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public String f66323a = null;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f66324b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f66325c = null;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f66326d = null;

    /* renamed from: e  reason: collision with root package name */
    public ThreadFactory f66327e = null;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f66328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f66330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Boolean f66331h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Integer f66332i;
        public final /* synthetic */ Thread.UncaughtExceptionHandler j;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f66328e = threadFactory;
            this.f66329f = str;
            this.f66330g = atomicLong;
            this.f66331h = bool;
            this.f66332i = num;
            this.j = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f66328e.newThread(runnable);
            String str = this.f66329f;
            if (str != null) {
                newThread.setName(r.d(str, Long.valueOf(this.f66330g.getAndIncrement())));
            }
            Boolean bool = this.f66331h;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f66332i;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.j;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    public static ThreadFactory c(r rVar) {
        String str = rVar.f66323a;
        Boolean bool = rVar.f66324b;
        Integer num = rVar.f66325c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = rVar.f66326d;
        ThreadFactory threadFactory = rVar.f66327e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public r e(String str) {
        d(str, 0);
        this.f66323a = str;
        return this;
    }

    public r f(int i2) {
        d.g.c.a.n.g(i2 >= 1, "Thread priority (%s) must be >= %s", i2, 1);
        d.g.c.a.n.g(i2 <= 10, "Thread priority (%s) must be <= %s", i2, 10);
        this.f66325c = Integer.valueOf(i2);
        return this;
    }
}
