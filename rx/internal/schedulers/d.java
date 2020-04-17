package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d implements h {
    public static final d nnp;
    private static int nnq;
    private final AtomicReference<ScheduledExecutorService[]> mVq = new AtomicReference<>(nno);
    private static final ScheduledExecutorService[] nno = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService mVs = Executors.newScheduledThreadPool(0);

    static {
        mVs.shutdown();
        nnp = new d();
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
        if (this.mVq.compareAndSet(nno, scheduledExecutorServiceArr)) {
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
            scheduledExecutorServiceArr = this.mVq.get();
            if (scheduledExecutorServiceArr == nno) {
                return;
            }
        } while (!this.mVq.compareAndSet(scheduledExecutorServiceArr, nno));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            g.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService dIa() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = nnp.mVq.get();
        if (scheduledExecutorServiceArr == nno) {
            return mVs;
        }
        int i = nnq + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        nnq = i;
        return scheduledExecutorServiceArr[i];
    }
}
