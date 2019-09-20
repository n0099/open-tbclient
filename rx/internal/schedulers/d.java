package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class d implements h {
    private static final ScheduledExecutorService[] kCI = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService kCJ = Executors.newScheduledThreadPool(0);
    public static final d kCK;
    private static int kCM;
    private final AtomicReference<ScheduledExecutorService[]> kCL = new AtomicReference<>(kCI);

    static {
        kCJ.shutdown();
        kCK = new d();
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
        if (this.kCL.compareAndSet(kCI, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.kCL.get();
            if (scheduledExecutorServiceArr == kCI) {
                return;
            }
        } while (!this.kCL.compareAndSet(scheduledExecutorServiceArr, kCI));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService cQP() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = kCK.kCL.get();
        if (scheduledExecutorServiceArr == kCI) {
            return kCJ;
        }
        int i = kCM + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        kCM = i;
        return scheduledExecutorServiceArr[i];
    }
}
