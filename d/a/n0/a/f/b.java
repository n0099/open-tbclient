package d.a.n0.a.f;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<ScheduledFuture<?>>> f63418a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f63419b = Executors.newFixedThreadPool(2);

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f63420c = Executors.newScheduledThreadPool(2);

    public static synchronized void a(Runnable runnable) {
        synchronized (b.class) {
            if (f63420c == null || f63420c.isShutdown()) {
                f63420c = Executors.newScheduledThreadPool(2);
            }
            f63420c.execute(runnable);
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        synchronized (b.class) {
            if (f63420c == null || f63420c.isShutdown()) {
                f63420c = Executors.newScheduledThreadPool(2);
            }
            f63418a.add(new WeakReference<>(f63420c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static void c(Runnable runnable) {
        ExecutorService executorService = f63419b;
        if (executorService == null || executorService.isShutdown()) {
            f63419b = Executors.newFixedThreadPool(2);
        }
        f63419b.execute(runnable);
    }
}
