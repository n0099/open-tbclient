package rx.internal.schedulers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public class g extends g.a implements k {
    private static final boolean iCr;
    private static volatile Object iCv;
    private final ScheduledExecutorService executor;
    volatile boolean isUnsubscribed;
    private static final Object iCw = new Object();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> iCt = new ConcurrentHashMap<>();
    private static final AtomicReference<ScheduledExecutorService> iCu = new AtomicReference<>();
    public static final int iCs = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int ccQ = rx.internal.util.g.ccQ();
        iCr = !z && (ccQ == 0 || ccQ >= 21);
    }

    public static void a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            if (iCu.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (iCu.compareAndSet(null, newScheduledThreadPool)) {
                newScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: rx.internal.schedulers.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.ccK();
                    }
                }, iCs, iCs, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        iCt.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        iCt.remove(scheduledExecutorService);
    }

    static void ccK() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = iCt.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            rx.c.c.onError(th);
        }
    }

    public static boolean b(ScheduledExecutorService scheduledExecutorService) {
        Method c;
        if (iCr) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = iCv;
                if (obj == iCw) {
                    return false;
                }
                if (obj == null) {
                    c = c(scheduledExecutorService);
                    iCv = c != null ? c : iCw;
                } else {
                    c = (Method) obj;
                }
            } else {
                c = c(scheduledExecutorService);
            }
            if (c != null) {
                try {
                    c.invoke(scheduledExecutorService, true);
                    return true;
                } catch (IllegalAccessException e) {
                    rx.c.c.onError(e);
                } catch (IllegalArgumentException e2) {
                    rx.c.c.onError(e2);
                } catch (InvocationTargetException e3) {
                    rx.c.c.onError(e3);
                }
            }
        }
        return false;
    }

    static Method c(ScheduledExecutorService scheduledExecutorService) {
        Method[] methods;
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public g(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!b(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            a((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.executor = newScheduledThreadPool;
    }

    @Override // rx.g.a
    public k a(rx.functions.a aVar) {
        return a(aVar, 0L, null);
    }

    @Override // rx.g.a
    public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
        return this.isUnsubscribed ? rx.subscriptions.e.cdU() : b(aVar, j, timeUnit);
    }

    public ScheduledAction b(rx.functions.a aVar, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.g(aVar));
        if (j <= 0) {
            schedule = this.executor.submit(scheduledAction);
        } else {
            schedule = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction a(rx.functions.a aVar, long j, TimeUnit timeUnit, rx.subscriptions.b bVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.g(aVar), bVar);
        bVar.add(scheduledAction);
        if (j <= 0) {
            schedule = this.executor.submit(scheduledAction);
        } else {
            schedule = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction a(rx.functions.a aVar, long j, TimeUnit timeUnit, rx.internal.util.j jVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.g(aVar), jVar);
        jVar.add(scheduledAction);
        if (j <= 0) {
            schedule = this.executor.submit(scheduledAction);
        } else {
            schedule = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    @Override // rx.k
    public void unsubscribe() {
        this.isUnsubscribed = true;
        this.executor.shutdownNow();
        a(this.executor);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.isUnsubscribed;
    }
}
