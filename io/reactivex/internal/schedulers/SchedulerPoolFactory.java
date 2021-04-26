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
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    public static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
    public static final int PURGE_PERIOD_SECONDS;
    public static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
    public static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference<>();
    public static final Map<ScheduledThreadPoolExecutor, Object> POOLS = new ConcurrentHashMap();

    /* loaded from: classes7.dex */
    public static final class PurgeProperties {
        public boolean purgeEnable;
        public int purgePeriod;

        public void load(Properties properties) {
            if (properties.containsKey(SchedulerPoolFactory.PURGE_ENABLED_KEY)) {
                this.purgeEnable = Boolean.parseBoolean(properties.getProperty(SchedulerPoolFactory.PURGE_ENABLED_KEY));
            } else {
                this.purgeEnable = true;
            }
            if (this.purgeEnable && properties.containsKey(SchedulerPoolFactory.PURGE_PERIOD_SECONDS_KEY)) {
                try {
                    this.purgePeriod = Integer.parseInt(properties.getProperty(SchedulerPoolFactory.PURGE_PERIOD_SECONDS_KEY));
                    return;
                } catch (NumberFormatException unused) {
                    this.purgePeriod = 1;
                    return;
                }
            }
            this.purgePeriod = 1;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ScheduledTask implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.POOLS.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.POOLS.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        PurgeProperties purgeProperties = new PurgeProperties();
        purgeProperties.load(properties);
        PURGE_ENABLED = purgeProperties.purgeEnable;
        PURGE_PERIOD_SECONDS = purgeProperties.purgePeriod;
        start();
    }

    public SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        tryPutIntoPool(PURGE_ENABLED, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    public static void shutdown() {
        ScheduledExecutorService andSet = PURGE_THREAD.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        POOLS.clear();
    }

    public static void start() {
        tryStart(PURGE_ENABLED);
    }

    public static void tryPutIntoPool(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            POOLS.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void tryStart(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = PURGE_THREAD.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (PURGE_THREAD.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                ScheduledTask scheduledTask = new ScheduledTask();
                int i2 = PURGE_PERIOD_SECONDS;
                newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, i2, i2, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }
}
