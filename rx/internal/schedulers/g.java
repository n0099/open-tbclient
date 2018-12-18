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
    private static final boolean iLi;
    private static volatile Object iLm;
    private final ScheduledExecutorService executor;
    volatile boolean isUnsubscribed;
    private static final Object iLn = new Object();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> iLk = new ConcurrentHashMap<>();
    private static final AtomicReference<ScheduledExecutorService> iLl = new AtomicReference<>();
    public static final int iLj = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int cep = rx.internal.util.g.cep();
        iLi = !z && (cep == 0 || cep >= 21);
    }

    public static void a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            if (iLl.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (iLl.compareAndSet(null, newScheduledThreadPool)) {
                newScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: rx.internal.schedulers.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.cej();
                    }
                }, iLj, iLj, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        iLk.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        iLk.remove(scheduledExecutorService);
    }

    static void cej() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = iLk.keySet().iterator();
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
        if (iLi) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = iLm;
                if (obj == iLn) {
                    return false;
                }
                if (obj == null) {
                    c = c(scheduledExecutorService);
                    iLm = c != null ? c : iLn;
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
        return this.isUnsubscribed ? rx.subscriptions.e.cft() : b(aVar, j, timeUnit);
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
