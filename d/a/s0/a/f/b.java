package d.a.s0.a.f;

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
    public static List<WeakReference<ScheduledFuture<?>>> f68287a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f68288b = Executors.newFixedThreadPool(2);

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f68289c = Executors.newScheduledThreadPool(2);

    public static synchronized void a(Runnable runnable) {
        synchronized (b.class) {
            if (f68289c == null || f68289c.isShutdown()) {
                f68289c = Executors.newScheduledThreadPool(2);
            }
            f68289c.execute(runnable);
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        synchronized (b.class) {
            if (f68289c == null || f68289c.isShutdown()) {
                f68289c = Executors.newScheduledThreadPool(2);
            }
            f68287a.add(new WeakReference<>(f68289c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static void c(Runnable runnable) {
        ExecutorService executorService = f68288b;
        if (executorService == null || executorService.isShutdown()) {
            f68288b = Executors.newFixedThreadPool(2);
        }
        f68288b.execute(runnable);
    }
}
