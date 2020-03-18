package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d nTI;
    private static int nTJ;
    private final AtomicReference<ScheduledExecutorService[]> nBP = new AtomicReference<>(nTH);
    private static final ScheduledExecutorService[] nTH = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nBR = Executors.newScheduledThreadPool(0);

    static {
        nBR.shutdown();
        nTI = new d();
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
        if (this.nBP.compareAndSet(nTH, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nBP.get();
            if (scheduledExecutorServiceArr == nTH) {
                return;
            }
        } while (!this.nBP.compareAndSet(scheduledExecutorServiceArr, nTH));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dPa() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nTI.nBP.get();
        if (scheduledExecutorServiceArr == nTH) {
            return nBR;
        }
        int i = nTJ + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nTJ = i;
        return scheduledExecutorServiceArr[i];
    }
}
