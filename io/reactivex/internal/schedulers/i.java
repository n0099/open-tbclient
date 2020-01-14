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
/* loaded from: classes5.dex */
public final class i {
    public static final boolean nyX;
    public static final int nyY;
    static final AtomicReference<ScheduledExecutorService> nyZ = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> nza = new ConcurrentHashMap();

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        nyX = aVar.nzb;
        nyY = aVar.nzc;
        start();
    }

    public static void start() {
        wC(nyX);
    }

    static void wC(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = nyZ.get();
            if (scheduledExecutorService == null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                if (nyZ.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                    newScheduledThreadPool.scheduleAtFixedRate(new b(), nyY, nyY, TimeUnit.SECONDS);
                    return;
                }
                newScheduledThreadPool.shutdownNow();
            } else {
                return;
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class a {
        boolean nzb;
        int nzc;

        a() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.nzb = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.nzb = true;
            }
            if (this.nzb && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.nzc = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException e) {
                    this.nzc = 1;
                    return;
                }
            }
            this.nzc = 1;
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(nyX, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            nza.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(i.nza.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    i.nza.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}
