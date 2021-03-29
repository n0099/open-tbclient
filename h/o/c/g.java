package h.o.c;

import h.g;
import h.k;
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
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes7.dex */
public class g extends g.a implements k {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f67904g;
    public static volatile Object k;

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f67906e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f67907f;
    public static final Object l = new Object();
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> i = new ConcurrentHashMap<>();
    public static final AtomicReference<ScheduledExecutorService> j = new AtomicReference<>();

    /* renamed from: h  reason: collision with root package name */
    public static final int f67905h = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            g.f();
        }
    }

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a2 = h.o.d.f.a();
        f67904g = !z && (a2 == 0 || a2 >= 21);
    }

    public g(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!k(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            g((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f67906e = newScheduledThreadPool;
    }

    public static void d(ScheduledExecutorService scheduledExecutorService) {
        i.remove(scheduledExecutorService);
    }

    public static Method e(ScheduledExecutorService scheduledExecutorService) {
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

    public static void f() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = i.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            h.m.a.e(th);
            h.r.c.j(th);
        }
    }

    public static void g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            if (j.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (j.compareAndSet(null, newScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f67905h;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        i.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean k(ScheduledExecutorService scheduledExecutorService) {
        Method e2;
        if (f67904g) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = k;
                if (obj == l) {
                    return false;
                }
                if (obj == null) {
                    e2 = e(scheduledExecutorService);
                    k = e2 != null ? e2 : l;
                } else {
                    e2 = (Method) obj;
                }
            } else {
                e2 = e(scheduledExecutorService);
            }
            if (e2 != null) {
                try {
                    e2.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e3) {
                    h.r.c.j(e3);
                } catch (IllegalArgumentException e4) {
                    h.r.c.j(e4);
                } catch (InvocationTargetException e5) {
                    h.r.c.j(e5);
                }
            }
        }
        return false;
    }

    @Override // h.g.a
    public k b(h.n.a aVar) {
        return c(aVar, 0L, null);
    }

    @Override // h.g.a
    public k c(h.n.a aVar, long j2, TimeUnit timeUnit) {
        if (this.f67907f) {
            return h.u.e.c();
        }
        return h(aVar, j2, timeUnit);
    }

    public ScheduledAction h(h.n.a aVar, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar));
        if (j2 <= 0) {
            schedule = this.f67906e.submit(scheduledAction);
        } else {
            schedule = this.f67906e.schedule(scheduledAction, j2, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction i(h.n.a aVar, long j2, TimeUnit timeUnit, h.o.d.i iVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), iVar);
        iVar.a(scheduledAction);
        if (j2 <= 0) {
            schedule = this.f67906e.submit(scheduledAction);
        } else {
            schedule = this.f67906e.schedule(scheduledAction, j2, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f67907f;
    }

    public ScheduledAction j(h.n.a aVar, long j2, TimeUnit timeUnit, h.u.b bVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), bVar);
        bVar.a(scheduledAction);
        if (j2 <= 0) {
            schedule = this.f67906e.submit(scheduledAction);
        } else {
            schedule = this.f67906e.schedule(scheduledAction, j2, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    @Override // h.k
    public void unsubscribe() {
        this.f67907f = true;
        this.f67906e.shutdownNow();
        d(this.f67906e);
    }
}
