package h.o.c;

import h.g;
import h.k;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes7.dex */
public final class a extends h.g implements h {

    /* renamed from: g  reason: collision with root package name */
    public static final long f68586g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f68587h = TimeUnit.SECONDS;

    /* renamed from: i  reason: collision with root package name */
    public static final c f68588i;
    public static final C1929a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f68589e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1929a> f68590f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1929a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f68591a;

        /* renamed from: b  reason: collision with root package name */
        public final long f68592b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f68593c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f68594d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f68595e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f68596f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class ThreadFactoryC1930a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f68597e;

            public ThreadFactoryC1930a(C1929a c1929a, ThreadFactory threadFactory) {
                this.f68597e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f68597e.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* renamed from: h.o.c.a$a$b */
        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1929a.this.a();
            }
        }

        public C1929a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f68591a = threadFactory;
            this.f68592b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f68593c = new ConcurrentLinkedQueue<>();
            this.f68594d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1930a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f68592b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f68595e = scheduledExecutorService;
            this.f68596f = scheduledFuture;
        }

        public void a() {
            if (this.f68593c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f68593c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f68593c.remove(next)) {
                    this.f68594d.b(next);
                }
            }
        }

        public c b() {
            if (this.f68594d.isUnsubscribed()) {
                return a.f68588i;
            }
            while (!this.f68593c.isEmpty()) {
                c poll = this.f68593c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f68591a);
            this.f68594d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f68592b);
            this.f68593c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f68596f != null) {
                    this.f68596f.cancel(true);
                }
                if (this.f68595e != null) {
                    this.f68595e.shutdownNow();
                }
            } finally {
                this.f68594d.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1929a f68600f;

        /* renamed from: g  reason: collision with root package name */
        public final c f68601g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f68599e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f68602h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1931a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68603e;

            public C1931a(h.n.a aVar) {
                this.f68603e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f68603e.call();
            }
        }

        public b(C1929a c1929a) {
            this.f68600f = c1929a;
            this.f68601g = c1929a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f68599e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f68601g.h(new C1931a(aVar), j, timeUnit);
            this.f68599e.a(h2);
            h2.addParent(this.f68599e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f68600f.d(this.f68601g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68599e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f68602h.compareAndSet(false, true)) {
                this.f68601g.b(this);
            }
            this.f68599e.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends g {
        public long m;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.m = 0L;
        }

        public long l() {
            return this.m;
        }

        public void m(long j) {
            this.m = j;
        }
    }

    static {
        c cVar = new c(RxThreadFactory.NONE);
        f68588i = cVar;
        cVar.unsubscribe();
        C1929a c1929a = new C1929a(null, 0L, null);
        j = c1929a;
        c1929a.e();
        f68586g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f68589e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f68590f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1929a c1929a;
        C1929a c1929a2;
        do {
            c1929a = this.f68590f.get();
            c1929a2 = j;
            if (c1929a == c1929a2) {
                return;
            }
        } while (!this.f68590f.compareAndSet(c1929a, c1929a2));
        c1929a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1929a c1929a = new C1929a(this.f68589e, f68586g, f68587h);
        if (this.f68590f.compareAndSet(j, c1929a)) {
            return;
        }
        c1929a.e();
    }
}
