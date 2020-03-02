package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d nRK;
    private static int nRL;
    private final AtomicReference<ScheduledExecutorService[]> nzR = new AtomicReference<>(nRJ);
    private static final ScheduledExecutorService[] nRJ = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nzT = Executors.newScheduledThreadPool(0);

    static {
        nzT.shutdown();
        nRK = new d();
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
        if (this.nzR.compareAndSet(nRJ, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nzR.get();
            if (scheduledExecutorServiceArr == nRJ) {
                return;
            }
        } while (!this.nzR.compareAndSet(scheduledExecutorServiceArr, nRJ));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dOz() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nRK.nzR.get();
        if (scheduledExecutorServiceArr == nRJ) {
            return nzT;
        }
        int i = nRL + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nRL = i;
        return scheduledExecutorServiceArr[i];
    }
}
