package d.a.r0.a.f;

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
    public static List<WeakReference<ScheduledFuture<?>>> f68171a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f68172b = Executors.newFixedThreadPool(2);

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f68173c = Executors.newScheduledThreadPool(2);

    public static synchronized void a(Runnable runnable) {
        synchronized (b.class) {
            if (f68173c == null || f68173c.isShutdown()) {
                f68173c = Executors.newScheduledThreadPool(2);
            }
            f68173c.execute(runnable);
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        synchronized (b.class) {
            if (f68173c == null || f68173c.isShutdown()) {
                f68173c = Executors.newScheduledThreadPool(2);
            }
            f68171a.add(new WeakReference<>(f68173c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static void c(Runnable runnable) {
        ExecutorService executorService = f68172b;
        if (executorService == null || executorService.isShutdown()) {
            f68172b = Executors.newFixedThreadPool(2);
        }
        f68172b.execute(runnable);
    }
}
