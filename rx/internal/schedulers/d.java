package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes12.dex */
public final class d implements h {
    public static final d pTD;
    private static int pTE;
    private final AtomicReference<ScheduledExecutorService[]> pIB = new AtomicReference<>(pTC);
    private static final ScheduledExecutorService[] pTC = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService pID = Executors.newScheduledThreadPool(0);

    static {
        pID.shutdown();
        pTD = new d();
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
        if (this.pIB.compareAndSet(pTC, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.pIB.get();
            if (scheduledExecutorServiceArr == pTC) {
                return;
            }
        } while (!this.pIB.compareAndSet(scheduledExecutorServiceArr, pTC));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService eFV() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = pTD.pIB.get();
        if (scheduledExecutorServiceArr == pTC) {
            return pID;
        }
        int i = pTE + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        pTE = i;
        return scheduledExecutorServiceArr[i];
    }
}
