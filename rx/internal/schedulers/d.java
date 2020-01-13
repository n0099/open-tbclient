package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class d implements h {
    public static final d nQO;
    private static int nQP;
    private final AtomicReference<ScheduledExecutorService[]> nzi = new AtomicReference<>(nQN);
    private static final ScheduledExecutorService[] nQN = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nzk = Executors.newScheduledThreadPool(0);

    static {
        nzk.shutdown();
        nQO = new d();
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
        if (this.nzi.compareAndSet(nQN, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nzi.get();
            if (scheduledExecutorServiceArr == nQN) {
                return;
            }
        } while (!this.nzi.compareAndSet(scheduledExecutorServiceArr, nQN));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dNi() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nQO.nzi.get();
        if (scheduledExecutorServiceArr == nQN) {
            return nzk;
        }
        int i = nQP + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nQP = i;
        return scheduledExecutorServiceArr[i];
    }
}
