package d.g.c.i.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public String f67074a = null;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f67075b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f67076c = null;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f67077d = null;

    /* renamed from: e  reason: collision with root package name */
    public ThreadFactory f67078e = null;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f67079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67080f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f67081g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Boolean f67082h;
        public final /* synthetic */ Integer i;
        public final /* synthetic */ Thread.UncaughtExceptionHandler j;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f67079e = threadFactory;
            this.f67080f = str;
            this.f67081g = atomicLong;
            this.f67082h = bool;
            this.i = num;
            this.j = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f67079e.newThread(runnable);
            String str = this.f67080f;
            if (str != null) {
                newThread.setName(r.d(str, Long.valueOf(this.f67081g.getAndIncrement())));
            }
            Boolean bool = this.f67082h;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.i;
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
        String str = rVar.f67074a;
        Boolean bool = rVar.f67075b;
        Integer num = rVar.f67076c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = rVar.f67077d;
        ThreadFactory threadFactory = rVar.f67078e;
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
        this.f67074a = str;
        return this;
    }

    public r f(int i) {
        d.g.c.a.n.g(i >= 1, "Thread priority (%s) must be >= %s", i, 1);
        d.g.c.a.n.g(i <= 10, "Thread priority (%s) must be <= %s", i, 10);
        this.f67076c = Integer.valueOf(i);
        return this;
    }
}
