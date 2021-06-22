package d.g.c.i.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public String f70201a = null;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f70202b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f70203c = null;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f70204d = null;

    /* renamed from: e  reason: collision with root package name */
    public ThreadFactory f70205e = null;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f70206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f70207f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f70208g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Boolean f70209h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Integer f70210i;
        public final /* synthetic */ Thread.UncaughtExceptionHandler j;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f70206e = threadFactory;
            this.f70207f = str;
            this.f70208g = atomicLong;
            this.f70209h = bool;
            this.f70210i = num;
            this.j = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f70206e.newThread(runnable);
            String str = this.f70207f;
            if (str != null) {
                newThread.setName(r.d(str, Long.valueOf(this.f70208g.getAndIncrement())));
            }
            Boolean bool = this.f70209h;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f70210i;
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
        String str = rVar.f70201a;
        Boolean bool = rVar.f70202b;
        Integer num = rVar.f70203c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = rVar.f70204d;
        ThreadFactory threadFactory = rVar.f70205e;
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
        this.f70201a = str;
        return this;
    }

    public r f(int i2) {
        d.g.c.a.n.g(i2 >= 1, "Thread priority (%s) must be >= %s", i2, 1);
        d.g.c.a.n.g(i2 <= 10, "Thread priority (%s) must be <= %s", i2, 10);
        this.f70203c = Integer.valueOf(i2);
        return this;
    }
}
