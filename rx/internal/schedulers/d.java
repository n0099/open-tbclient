package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d nJC;
    private static int nJD;
    private final AtomicReference<ScheduledExecutorService[]> nrG = new AtomicReference<>(nJB);
    private static final ScheduledExecutorService[] nJB = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nrI = Executors.newScheduledThreadPool(0);

    static {
        nrI.shutdown();
        nJC = new d();
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
        if (this.nrG.compareAndSet(nJB, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nrG.get();
            if (scheduledExecutorServiceArr == nJB) {
                return;
            }
        } while (!this.nrG.compareAndSet(scheduledExecutorServiceArr, nJB));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dQf() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nJC.nrG.get();
        if (scheduledExecutorServiceArr == nJB) {
            return nrI;
        }
        int i = nJD + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nJD = i;
        return scheduledExecutorServiceArr[i];
    }
}
