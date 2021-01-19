package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public final class d implements h {
    public static final d qsn;
    private static int qso;
    private final AtomicReference<ScheduledExecutorService[]> qhn = new AtomicReference<>(qsm);
    private static final ScheduledExecutorService[] qsm = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService qhp = Executors.newScheduledThreadPool(0);

    static {
        qhp.shutdown();
        qsn = new d();
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
        if (this.qhn.compareAndSet(qsm, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.qhn.get();
            if (scheduledExecutorServiceArr == qsm) {
                return;
            }
        } while (!this.qhn.compareAndSet(scheduledExecutorServiceArr, qsm));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService eKS() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = qsn.qhn.get();
        if (scheduledExecutorServiceArr == qsm) {
            return qhp;
        }
        int i = qso + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        qso = i;
        return scheduledExecutorServiceArr[i];
    }
}
