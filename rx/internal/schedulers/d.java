package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d oob;
    private static int ooc;
    private final AtomicReference<ScheduledExecutorService[]> nWf = new AtomicReference<>(ooa);
    private static final ScheduledExecutorService[] ooa = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nWh = Executors.newScheduledThreadPool(0);

    static {
        nWh.shutdown();
        oob = new d();
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
        if (this.nWf.compareAndSet(ooa, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nWf.get();
            if (scheduledExecutorServiceArr == ooa) {
                return;
            }
        } while (!this.nWf.compareAndSet(scheduledExecutorServiceArr, ooa));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dYl() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = oob.nWf.get();
        if (scheduledExecutorServiceArr == ooa) {
            return nWh;
        }
        int i = ooc + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        ooc = i;
        return scheduledExecutorServiceArr[i];
    }
}
