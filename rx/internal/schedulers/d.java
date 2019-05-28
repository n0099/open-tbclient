package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class d implements h {
    private static final ScheduledExecutorService[] krI = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService krJ = Executors.newScheduledThreadPool(0);
    public static final d krK;
    private static int krM;
    private final AtomicReference<ScheduledExecutorService[]> krL = new AtomicReference<>(krI);

    static {
        krJ.shutdown();
        krK = new d();
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
        if (this.krL.compareAndSet(krI, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.krL.get();
            if (scheduledExecutorServiceArr == krI) {
                return;
            }
        } while (!this.krL.compareAndSet(scheduledExecutorServiceArr, krI));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService cLU() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = krK.krL.get();
        if (scheduledExecutorServiceArr == krI) {
            return krJ;
        }
        int i = krM + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        krM = i;
        return scheduledExecutorServiceArr[i];
    }
}
