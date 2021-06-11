package d.a.f0.a.l;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f43540c;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f43541a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f43542b;

    public c() {
        b();
    }

    public static c a() {
        if (f43540c == null) {
            synchronized (c.class) {
                if (f43540c == null) {
                    f43540c = new c();
                }
            }
        }
        return f43540c;
    }

    public final void b() {
        this.f43541a = d.g(5, 15);
        this.f43542b = d.f(3);
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f43541a.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public void d(b bVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (bVar == null || (scheduledThreadPoolExecutor = this.f43542b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            bVar.i(System.currentTimeMillis());
            bVar.h(this.f43542b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
