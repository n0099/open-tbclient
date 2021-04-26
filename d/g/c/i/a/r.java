package d.g.c.i.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public String f65637a = null;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f65638b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f65639c = null;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f65640d = null;

    /* renamed from: e  reason: collision with root package name */
    public ThreadFactory f65641e = null;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f65642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f65643f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f65644g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Boolean f65645h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Integer f65646i;
        public final /* synthetic */ Thread.UncaughtExceptionHandler j;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f65642e = threadFactory;
            this.f65643f = str;
            this.f65644g = atomicLong;
            this.f65645h = bool;
            this.f65646i = num;
            this.j = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f65642e.newThread(runnable);
            String str = this.f65643f;
            if (str != null) {
                newThread.setName(r.d(str, Long.valueOf(this.f65644g.getAndIncrement())));
            }
            Boolean bool = this.f65645h;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f65646i;
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
        String str = rVar.f65637a;
        Boolean bool = rVar.f65638b;
        Integer num = rVar.f65639c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = rVar.f65640d;
        ThreadFactory threadFactory = rVar.f65641e;
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
        this.f65637a = str;
        return this;
    }

    public r f(int i2) {
        d.g.c.a.n.g(i2 >= 1, "Thread priority (%s) must be >= %s", i2, 1);
        d.g.c.a.n.g(i2 <= 10, "Thread priority (%s) must be <= %s", i2, 10);
        this.f65639c = Integer.valueOf(i2);
        return this;
    }
}
