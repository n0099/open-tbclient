package d.a.d0.a.l;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f39873c;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f39874a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f39875b;

    public c() {
        b();
    }

    public static c a() {
        if (f39873c == null) {
            synchronized (c.class) {
                if (f39873c == null) {
                    f39873c = new c();
                }
            }
        }
        return f39873c;
    }

    public final void b() {
        this.f39874a = d.g(5, 15);
        this.f39875b = d.f(3);
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f39874a.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(b bVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (bVar == null || (scheduledThreadPoolExecutor = this.f39875b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            bVar.i(System.currentTimeMillis());
            bVar.h(this.f39875b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
