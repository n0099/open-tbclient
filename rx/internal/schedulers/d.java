package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d nIs;
    private static int nIt;
    private final AtomicReference<ScheduledExecutorService[]> nqw = new AtomicReference<>(nIr);
    private static final ScheduledExecutorService[] nIr = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nqy = Executors.newScheduledThreadPool(0);

    static {
        nqy.shutdown();
        nIs = new d();
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
        if (this.nqw.compareAndSet(nIr, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nqw.get();
            if (scheduledExecutorServiceArr == nIr) {
                return;
            }
        } while (!this.nqw.compareAndSet(scheduledExecutorServiceArr, nIr));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dPR() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nIs.nqw.get();
        if (scheduledExecutorServiceArr == nIr) {
            return nqy;
        }
        int i = nIt + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nIt = i;
        return scheduledExecutorServiceArr[i];
    }
}
