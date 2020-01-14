package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class d implements h {
    public static final d nQT;
    private static int nQU;
    private final AtomicReference<ScheduledExecutorService[]> nzn = new AtomicReference<>(nQS);
    private static final ScheduledExecutorService[] nQS = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nzp = Executors.newScheduledThreadPool(0);

    static {
        nzp.shutdown();
        nQT = new d();
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
        if (this.nzn.compareAndSet(nQS, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nzn.get();
            if (scheduledExecutorServiceArr == nQS) {
                return;
            }
        } while (!this.nzn.compareAndSet(scheduledExecutorServiceArr, nQS));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dNk() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nQT.nzn.get();
        if (scheduledExecutorServiceArr == nQS) {
            return nzp;
        }
        int i = nQU + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nQU = i;
        return scheduledExecutorServiceArr[i];
    }
}
