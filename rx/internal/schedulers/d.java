package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d nRV;
    private static int nRW;
    private final AtomicReference<ScheduledExecutorService[]> nAc = new AtomicReference<>(nRU);
    private static final ScheduledExecutorService[] nRU = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nAe = Executors.newScheduledThreadPool(0);

    static {
        nAe.shutdown();
        nRV = new d();
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
        if (this.nAc.compareAndSet(nRU, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nAc.get();
            if (scheduledExecutorServiceArr == nRU) {
                return;
            }
        } while (!this.nAc.compareAndSet(scheduledExecutorServiceArr, nRU));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dOA() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nRV.nAc.get();
        if (scheduledExecutorServiceArr == nRU) {
            return nAe;
        }
        int i = nRW + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nRW = i;
        return scheduledExecutorServiceArr[i];
    }
}
