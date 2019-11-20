package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class d implements h {
    public static final d kCB;
    private static int kCD;
    private final AtomicReference<ScheduledExecutorService[]> kCC = new AtomicReference<>(kCz);
    private static final ScheduledExecutorService[] kCz = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService kCA = Executors.newScheduledThreadPool(0);

    static {
        kCA.shutdown();
        kCB = new d();
    }

    private d() {
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        int i = availableProcessors <= 8 ? availableProcessors : 8;
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[i];
        for (int i2 = 0; i2 < i; i2++) {
            scheduledExecutorServiceArr[i2] = GenericScheduledExecutorServiceFactory.create();
        }
        if (this.kCC.compareAndSet(kCz, scheduledExecutorServiceArr)) {
            for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
                if (!g.b(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    g.a((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
            }
            return;
        }
        for (ScheduledExecutorService scheduledExecutorService2 : scheduledExecutorServiceArr) {
            scheduledExecutorService2.shutdownNow();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        do {
            scheduledExecutorServiceArr = this.kCC.get();
            if (scheduledExecutorServiceArr == kCz) {
                return;
            }
        } while (!this.kCC.compareAndSet(scheduledExecutorServiceArr, kCz));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService cOS() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = kCB.kCC.get();
        if (scheduledExecutorServiceArr == kCz) {
            return kCA;
        }
        int i = kCD + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        kCD = i;
        return scheduledExecutorServiceArr[i];
    }
}
