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
/* loaded from: classes6.dex */
public class g extends g.a implements k {
    private static final boolean ooi;
    private static volatile Object oom;
    private final ScheduledExecutorService executor;
    volatile boolean isUnsubscribed;
    private static final Object oon = new Object();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> ook = new ConcurrentHashMap<>();
    private static final AtomicReference<ScheduledExecutorService> ool = new AtomicReference<>();
    public static final int ooj = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int dYr = rx.internal.util.f.dYr();
        ooi = !z && (dYr == 0 || dYr >= 21);
    }

    public static void a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            if (ool.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (ool.compareAndSet(null, newScheduledThreadPool)) {
                newScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: rx.internal.schedulers.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.dYn();
                    }
                }, ooj, ooj, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        ook.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        ook.remove(scheduledExecutorService);
    }

    static void dYn() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = ook.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            rx.exceptions.a.K(th);
            rx.c.c.onError(th);
        }
    }

    public static boolean b(ScheduledExecutorService scheduledExecutorService) {
        Method c;
        if (ooi) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = oom;
                if (obj == oon) {
                    return false;
                }
                if (obj == null) {
                    c = c(scheduledExecutorService);
                    oom = c != null ? c : oon;
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
    public k c(rx.functions.a aVar) {
        return a(aVar, 0L, null);
    }

    @Override // rx.g.a
    public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
        return this.isUnsubscribed ? rx.subscriptions.e.dZp() : b(aVar, j, timeUnit);
    }

    public ScheduledAction b(rx.functions.a aVar, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.i(aVar));
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
        ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.i(aVar), bVar);
        bVar.add(scheduledAction);
        if (j <= 0) {
            schedule = this.executor.submit(scheduledAction);
        } else {
            schedule = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction a(rx.functions.a aVar, long j, TimeUnit timeUnit, rx.internal.util.i iVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.c.c.i(aVar), iVar);
        iVar.add(scheduledAction);
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
