package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
public final class d implements h {
    public static final d pYE;
    private static int pYF;
    private final AtomicReference<ScheduledExecutorService[]> pGQ = new AtomicReference<>(pYD);
    private static final ScheduledExecutorService[] pYD = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService pGS = Executors.newScheduledThreadPool(0);

    static {
        pGS.shutdown();
        pYE = new d();
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
        if (this.pGQ.compareAndSet(pYD, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.pGQ.get();
            if (scheduledExecutorServiceArr == pYD) {
                return;
            }
        } while (!this.pGQ.compareAndSet(scheduledExecutorServiceArr, pYD));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService eCg() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = pYE.pGQ.get();
        if (scheduledExecutorServiceArr == pYD) {
            return pGS;
        }
        int i = pYF + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        pYF = i;
        return scheduledExecutorServiceArr[i];
    }
}
