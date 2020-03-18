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
    public static final int nBA;
    static final AtomicReference<ScheduledExecutorService> nBB = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> nBC = new ConcurrentHashMap();
    public static final boolean nBz;

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        nBz = aVar.nBD;
        nBA = aVar.nBE;
        start();
    }

    public static void start() {
        wN(nBz);
    }

    static void wN(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = nBB.get();
            if (scheduledExecutorService == null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                if (nBB.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                    newScheduledThreadPool.scheduleAtFixedRate(new b(), nBA, nBA, TimeUnit.SECONDS);
                    return;
                }
                newScheduledThreadPool.shutdownNow();
            } else {
                return;
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a {
        boolean nBD;
        int nBE;

        a() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.nBD = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.nBD = true;
            }
            if (this.nBD && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.nBE = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException e) {
                    this.nBE = 1;
                    return;
                }
            }
            this.nBE = 1;
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(nBz, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            nBC.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(i.nBC.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    i.nBC.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}
