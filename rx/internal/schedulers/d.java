package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
public final class d implements h {
    public static final d qhY;
    private static int qhZ;
    private final AtomicReference<ScheduledExecutorService[]> pQk = new AtomicReference<>(qhX);
    private static final ScheduledExecutorService[] qhX = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService pQm = Executors.newScheduledThreadPool(0);

    static {
        pQm.shutdown();
        qhY = new d();
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
        if (this.pQk.compareAndSet(qhX, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.pQk.get();
            if (scheduledExecutorServiceArr == qhX) {
                return;
            }
        } while (!this.pQk.compareAndSet(scheduledExecutorServiceArr, qhX));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService eFV() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = qhY.pQk.get();
        if (scheduledExecutorServiceArr == qhX) {
            return pQm;
        }
        int i = qhZ + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        qhZ = i;
        return scheduledExecutorServiceArr[i];
    }
}
