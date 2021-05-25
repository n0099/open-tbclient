package d.g.c.i.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public String f66366a = null;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f66367b = null;

    /* renamed from: c  reason: collision with root package name */
    public Integer f66368c = null;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f66369d = null;

    /* renamed from: e  reason: collision with root package name */
    public ThreadFactory f66370e = null;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f66371e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66372f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f66373g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Boolean f66374h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Integer f66375i;
        public final /* synthetic */ Thread.UncaughtExceptionHandler j;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f66371e = threadFactory;
            this.f66372f = str;
            this.f66373g = atomicLong;
            this.f66374h = bool;
            this.f66375i = num;
            this.j = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f66371e.newThread(runnable);
            String str = this.f66372f;
            if (str != null) {
                newThread.setName(r.d(str, Long.valueOf(this.f66373g.getAndIncrement())));
            }
            Boolean bool = this.f66374h;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f66375i;
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
        String str = rVar.f66366a;
        Boolean bool = rVar.f66367b;
        Integer num = rVar.f66368c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = rVar.f66369d;
        ThreadFactory threadFactory = rVar.f66370e;
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
        this.f66366a = str;
        return this;
    }

    public r f(int i2) {
        d.g.c.a.n.g(i2 >= 1, "Thread priority (%s) must be >= %s", i2, 1);
        d.g.c.a.n.g(i2 <= 10, "Thread priority (%s) must be <= %s", i2, 10);
        this.f66368c = Integer.valueOf(i2);
        return this;
    }
}
