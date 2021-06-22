package d.a.g0.a.l;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f43676c;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f43677a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f43678b;

    public c() {
        b();
    }

    public static c a() {
        if (f43676c == null) {
            synchronized (c.class) {
                if (f43676c == null) {
                    f43676c = new c();
                }
            }
        }
        return f43676c;
    }

    public final void b() {
        this.f43677a = d.g(5, 15);
        this.f43678b = d.f(3);
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f43677a.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(b bVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (bVar == null || (scheduledThreadPoolExecutor = this.f43678b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            bVar.i(System.currentTimeMillis());
            bVar.h(this.f43678b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
