package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class d implements h {
    private static final ScheduledExecutorService[] iPr = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService iPs = Executors.newScheduledThreadPool(0);
    public static final d iPt;
    private static int iPv;
    private final AtomicReference<ScheduledExecutorService[]> iPu = new AtomicReference<>(iPr);

    static {
        iPs.shutdown();
        iPt = new d();
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
        if (this.iPu.compareAndSet(iPr, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.iPu.get();
            if (scheduledExecutorServiceArr == iPr) {
                return;
            }
        } while (!this.iPu.compareAndSet(scheduledExecutorServiceArr, iPr));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService cfH() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = iPt.iPu.get();
        if (scheduledExecutorServiceArr == iPr) {
            return iPs;
        }
        int i = iPv + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        iPv = i;
        return scheduledExecutorServiceArr[i];
    }
}
