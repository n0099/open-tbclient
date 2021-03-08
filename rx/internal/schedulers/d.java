package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class d implements h {
    public static final d qDs;
    private static int qDt;
    private final AtomicReference<ScheduledExecutorService[]> qst = new AtomicReference<>(qDr);
    private static final ScheduledExecutorService[] qDr = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService qsv = Executors.newScheduledThreadPool(0);

    static {
        qsv.shutdown();
        qDs = new d();
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
        if (this.qst.compareAndSet(qDr, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.qst.get();
            if (scheduledExecutorServiceArr == qDr) {
                return;
            }
        } while (!this.qst.compareAndSet(scheduledExecutorServiceArr, qDr));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService eMY() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = qDs.qst.get();
        if (scheduledExecutorServiceArr == qDr) {
            return qsv;
        }
        int i = qDt + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        qDt = i;
        return scheduledExecutorServiceArr[i];
    }
}
