package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public final class d implements h {
    public static final d qsm;
    private static int qsn;
    private final AtomicReference<ScheduledExecutorService[]> qhm = new AtomicReference<>(qsl);
    private static final ScheduledExecutorService[] qsl = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService qho = Executors.newScheduledThreadPool(0);

    static {
        qho.shutdown();
        qsm = new d();
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
        if (this.qhm.compareAndSet(qsl, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.qhm.get();
            if (scheduledExecutorServiceArr == qsl) {
                return;
            }
        } while (!this.qhm.compareAndSet(scheduledExecutorServiceArr, qsl));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService eKS() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = qsm.qhm.get();
        if (scheduledExecutorServiceArr == qsl) {
            return qho;
        }
        int i = qsn + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        qsn = i;
        return scheduledExecutorServiceArr[i];
    }
}
