package d.a.f0.a.l;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f39859c;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f39860a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f39861b;

    public c() {
        b();
    }

    public static c a() {
        if (f39859c == null) {
            synchronized (c.class) {
                if (f39859c == null) {
                    f39859c = new c();
                }
            }
        }
        return f39859c;
    }

    public final void b() {
        this.f39860a = d.g(5, 15);
        this.f39861b = d.f(3);
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f39860a.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(b bVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (bVar == null || (scheduledThreadPoolExecutor = this.f39861b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            bVar.i(System.currentTimeMillis());
            bVar.h(this.f39861b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
