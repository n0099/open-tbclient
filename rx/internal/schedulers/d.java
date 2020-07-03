package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d ofq;
    private static int ofr;
    private final AtomicReference<ScheduledExecutorService[]> nNt = new AtomicReference<>(ofp);
    private static final ScheduledExecutorService[] ofp = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService nNv = Executors.newScheduledThreadPool(0);

    static {
        nNv.shutdown();
        ofq = new d();
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
        if (this.nNt.compareAndSet(ofp, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.nNt.get();
            if (scheduledExecutorServiceArr == ofp) {
                return;
            }
        } while (!this.nNt.compareAndSet(scheduledExecutorServiceArr, ofp));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dUL() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = ofq.nNt.get();
        if (scheduledExecutorServiceArr == ofp) {
            return nNv;
        }
        int i = ofr + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        ofr = i;
        return scheduledExecutorServiceArr[i];
    }
}
