package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
public final class d implements h {
    public static final d phl;
    private static int phm;
    private final AtomicReference<ScheduledExecutorService[]> oPt = new AtomicReference<>(phk);
    private static final ScheduledExecutorService[] phk = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService oPv = Executors.newScheduledThreadPool(0);

    static {
        oPv.shutdown();
        phl = new d();
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
        if (this.oPt.compareAndSet(phk, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.oPt.get();
            if (scheduledExecutorServiceArr == phk) {
                return;
            }
        } while (!this.oPt.compareAndSet(scheduledExecutorServiceArr, phk));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService esi() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = phl.oPt.get();
        if (scheduledExecutorServiceArr == phk) {
            return oPv;
        }
        int i = phm + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        phm = i;
        return scheduledExecutorServiceArr[i];
    }
}
