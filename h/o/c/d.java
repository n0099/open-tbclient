package h.o.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.GenericScheduledExecutorServiceFactory;
/* loaded from: classes7.dex */
public final class d implements h {

    /* renamed from: f  reason: collision with root package name */
    public static final ScheduledExecutorService[] f67910f = new ScheduledExecutorService[0];

    /* renamed from: g  reason: collision with root package name */
    public static final ScheduledExecutorService f67911g;

    /* renamed from: h  reason: collision with root package name */
    public static final d f67912h;

    /* renamed from: i  reason: collision with root package name */
    public static int f67913i;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService[]> f67914e = new AtomicReference<>(f67910f);

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f67911g = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f67912h = new d();
    }

    public d() {
        start();
    }

    public static ScheduledExecutorService a() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = f67912h.f67914e.get();
        if (scheduledExecutorServiceArr == f67910f) {
            return f67911g;
        }
        int i2 = f67913i + 1;
        if (i2 >= scheduledExecutorServiceArr.length) {
            i2 = 0;
        }
        f67913i = i2;
        return scheduledExecutorServiceArr[i2];
    }

    @Override // h.o.c.h
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.f67914e.get();
            scheduledExecutorServiceArr2 = f67910f;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.f67914e.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.d(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // h.o.c.h
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
        int i2 = 0;
        for (int i3 = 0; i3 < availableProcessors; i3++) {
            scheduledExecutorServiceArr[i3] = GenericScheduledExecutorServiceFactory.create();
        }
        if (!this.f67914e.compareAndSet(f67910f, scheduledExecutorServiceArr)) {
            while (i2 < availableProcessors) {
                scheduledExecutorServiceArr[i2].shutdownNow();
                i2++;
            }
            return;
        }
        while (i2 < availableProcessors) {
            ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i2];
            if (!g.k(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                g.g((ScheduledThreadPoolExecutor) scheduledExecutorService);
            }
            i2++;
        }
    }
}
