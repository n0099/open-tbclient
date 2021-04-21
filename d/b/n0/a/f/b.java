package d.b.n0.a.f;

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
    public static List<WeakReference<ScheduledFuture<?>>> f65107a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f65108b = Executors.newFixedThreadPool(2);

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f65109c = Executors.newScheduledThreadPool(2);

    public static synchronized void a(Runnable runnable) {
        synchronized (b.class) {
            if (f65109c == null || f65109c.isShutdown()) {
                f65109c = Executors.newScheduledThreadPool(2);
            }
            f65109c.execute(runnable);
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        synchronized (b.class) {
            if (f65109c == null || f65109c.isShutdown()) {
                f65109c = Executors.newScheduledThreadPool(2);
            }
            f65107a.add(new WeakReference<>(f65109c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
        }
    }

    public static void c(Runnable runnable) {
        ExecutorService executorService = f65108b;
        if (executorService == null || executorService.isShutdown()) {
            f65108b = Executors.newFixedThreadPool(2);
        }
        f65108b.execute(runnable);
    }
}
