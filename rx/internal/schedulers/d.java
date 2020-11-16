package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public final class d implements h {
    public static final d qjC;
    private static int qjD;
    private final AtomicReference<ScheduledExecutorService[]> pRN = new AtomicReference<>(qjB);
    private static final ScheduledExecutorService[] qjB = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService pRP = Executors.newScheduledThreadPool(0);

    static {
        pRP.shutdown();
        qjC = new d();
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
        if (this.pRN.compareAndSet(qjB, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.pRN.get();
            if (scheduledExecutorServiceArr == qjB) {
                return;
            }
        } while (!this.pRN.compareAndSet(scheduledExecutorServiceArr, qjB));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService eFW() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = qjC.pRN.get();
        if (scheduledExecutorServiceArr == qjB) {
            return pRP;
        }
        int i = qjD + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        qjD = i;
        return scheduledExecutorServiceArr[i];
    }
}
