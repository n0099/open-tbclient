package d.g.c.i.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public String f70097a = null;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f70098b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f70099c = null;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f70100d = null;

    /* renamed from: e  reason: collision with root package name */
    public ThreadFactory f70101e = null;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f70102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f70103f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f70104g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Boolean f70105h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Integer f70106i;
        public final /* synthetic */ Thread.UncaughtExceptionHandler j;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f70102e = threadFactory;
            this.f70103f = str;
            this.f70104g = atomicLong;
            this.f70105h = bool;
            this.f70106i = num;
            this.j = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f70102e.newThread(runnable);
            String str = this.f70103f;
            if (str != null) {
                newThread.setName(r.d(str, Long.valueOf(this.f70104g.getAndIncrement())));
            }
            Boolean bool = this.f70105h;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f70106i;
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
        String str = rVar.f70097a;
        Boolean bool = rVar.f70098b;
        Integer num = rVar.f70099c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = rVar.f70100d;
        ThreadFactory threadFactory = rVar.f70101e;
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
        this.f70097a = str;
        return this;
    }

    public r f(int i2) {
        d.g.c.a.n.g(i2 >= 1, "Thread priority (%s) must be >= %s", i2, 1);
        d.g.c.a.n.g(i2 <= 10, "Thread priority (%s) must be <= %s", i2, 10);
        this.f70099c = Integer.valueOf(i2);
        return this;
    }
}
