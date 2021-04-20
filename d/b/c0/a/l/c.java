package d.b.c0.a.l;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f43064c;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f43065a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f43066b;

    public c() {
        b();
    }

    public static c a() {
        if (f43064c == null) {
            synchronized (c.class) {
                if (f43064c == null) {
                    f43064c = new c();
                }
            }
        }
        return f43064c;
    }

    public final void b() {
        this.f43065a = d.g(5, 15);
        this.f43066b = d.f(3);
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f43065a.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(b bVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (bVar == null || (scheduledThreadPoolExecutor = this.f43066b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            bVar.i(System.currentTimeMillis());
            bVar.h(this.f43066b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
