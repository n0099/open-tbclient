package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class i {
    public static final boolean nrr;
    public static final int nrs;
    static final AtomicReference<ScheduledExecutorService> nrt = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> nru = new ConcurrentHashMap();

    static {
        int i = 1;
        Properties properties = System.getProperties();
        boolean z = properties.containsKey("rx2.purge-enabled") ? Boolean.getBoolean("rx2.purge-enabled") : true;
        if (z && properties.containsKey("rx2.purge-period-seconds")) {
            i = Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        }
        nrr = z;
        nrs = i;
        start();
    }

    public static void start() {
        if (!nrr) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = nrt.get();
            if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                if (nrt.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                    newScheduledThreadPool.scheduleAtFixedRate(new a(), nrs, nrs, TimeUnit.SECONDS);
                    return;
                }
                newScheduledThreadPool.shutdownNow();
            } else {
                return;
            }
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (nrr && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            nru.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = new ArrayList(i.nru.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        i.nru.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                io.reactivex.e.a.onError(th);
            }
        }
    }
}
