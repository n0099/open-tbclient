package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class d implements h {
    private static final ScheduledExecutorService[] krH = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService krI = Executors.newScheduledThreadPool(0);
    public static final d krJ;
    private static int krL;
    private final AtomicReference<ScheduledExecutorService[]> krK = new AtomicReference<>(krH);

    static {
        krI.shutdown();
        krJ = new d();
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
        if (this.krK.compareAndSet(krH, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.krK.get();
            if (scheduledExecutorServiceArr == krH) {
                return;
            }
        } while (!this.krK.compareAndSet(scheduledExecutorServiceArr, krH));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService cLS() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = krJ.krK.get();
        if (scheduledExecutorServiceArr == krH) {
            return krI;
        }
        int i = krL + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        krL = i;
        return scheduledExecutorServiceArr[i];
    }
}
