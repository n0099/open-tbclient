package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class d implements h {
    private static final ScheduledExecutorService[] iLa = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService iLb = Executors.newScheduledThreadPool(0);
    public static final d iLc;
    private static int iLe;
    private final AtomicReference<ScheduledExecutorService[]> iLd = new AtomicReference<>(iLa);

    static {
        iLb.shutdown();
        iLc = new d();
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
        if (this.iLd.compareAndSet(iLa, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.iLd.get();
            if (scheduledExecutorServiceArr == iLa) {
                return;
            }
        } while (!this.iLd.compareAndSet(scheduledExecutorServiceArr, iLa));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService cej() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = iLc.iLd.get();
        if (scheduledExecutorServiceArr == iLa) {
            return iLb;
        }
        int i = iLe + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        iLe = i;
        return scheduledExecutorServiceArr[i];
    }
}
