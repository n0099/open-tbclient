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
    public static final long f68543g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f68544h = TimeUnit.SECONDS;

    /* renamed from: i  reason: collision with root package name */
    public static final c f68545i;
    public static final C1925a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f68546e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1925a> f68547f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1925a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f68548a;

        /* renamed from: b  reason: collision with root package name */
        public final long f68549b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f68550c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f68551d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f68552e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f68553f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class ThreadFactoryC1926a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f68554e;

            public ThreadFactoryC1926a(C1925a c1925a, ThreadFactory threadFactory) {
                this.f68554e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f68554e.newThread(runnable);
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
                C1925a.this.a();
            }
        }

        public C1925a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f68548a = threadFactory;
            this.f68549b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f68550c = new ConcurrentLinkedQueue<>();
            this.f68551d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1926a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f68549b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f68552e = scheduledExecutorService;
            this.f68553f = scheduledFuture;
        }

        public void a() {
            if (this.f68550c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f68550c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f68550c.remove(next)) {
                    this.f68551d.b(next);
                }
            }
        }

        public c b() {
            if (this.f68551d.isUnsubscribed()) {
                return a.f68545i;
            }
            while (!this.f68550c.isEmpty()) {
                c poll = this.f68550c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f68548a);
            this.f68551d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f68549b);
            this.f68550c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f68553f != null) {
                    this.f68553f.cancel(true);
                }
                if (this.f68552e != null) {
                    this.f68552e.shutdownNow();
                }
            } finally {
                this.f68551d.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1925a f68557f;

        /* renamed from: g  reason: collision with root package name */
        public final c f68558g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f68556e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f68559h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1927a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68560e;

            public C1927a(h.n.a aVar) {
                this.f68560e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f68560e.call();
            }
        }

        public b(C1925a c1925a) {
            this.f68557f = c1925a;
            this.f68558g = c1925a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f68556e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f68558g.h(new C1927a(aVar), j, timeUnit);
            this.f68556e.a(h2);
            h2.addParent(this.f68556e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f68557f.d(this.f68558g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68556e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f68559h.compareAndSet(false, true)) {
                this.f68558g.b(this);
            }
            this.f68556e.unsubscribe();
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
        f68545i = cVar;
        cVar.unsubscribe();
        C1925a c1925a = new C1925a(null, 0L, null);
        j = c1925a;
        c1925a.e();
        f68543g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f68546e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f68547f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1925a c1925a;
        C1925a c1925a2;
        do {
            c1925a = this.f68547f.get();
            c1925a2 = j;
            if (c1925a == c1925a2) {
                return;
            }
        } while (!this.f68547f.compareAndSet(c1925a, c1925a2));
        c1925a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1925a c1925a = new C1925a(this.f68546e, f68543g, f68544h);
        if (this.f68547f.compareAndSet(j, c1925a)) {
            return;
        }
        c1925a.e();
    }
}
