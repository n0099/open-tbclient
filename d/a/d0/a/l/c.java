package d.a.d0.a.l;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f40628c;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f40629a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f40630b;

    public c() {
        b();
    }

    public static c a() {
        if (f40628c == null) {
            synchronized (c.class) {
                if (f40628c == null) {
                    f40628c = new c();
                }
            }
        }
        return f40628c;
    }

    public final void b() {
        this.f40629a = d.g(5, 15);
        this.f40630b = d.f(3);
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f40629a.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(b bVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (bVar == null || (scheduledThreadPoolExecutor = this.f40630b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            bVar.i(System.currentTimeMillis());
            bVar.h(this.f40630b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
