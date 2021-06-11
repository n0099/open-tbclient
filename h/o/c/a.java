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
/* loaded from: classes8.dex */
public final class a extends h.g implements h {

    /* renamed from: g  reason: collision with root package name */
    public static final long f71842g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f71843h = TimeUnit.SECONDS;

    /* renamed from: i  reason: collision with root package name */
    public static final c f71844i;
    public static final C1978a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f71845e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1978a> f71846f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1978a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f71847a;

        /* renamed from: b  reason: collision with root package name */
        public final long f71848b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f71849c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f71850d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f71851e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f71852f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class ThreadFactoryC1979a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f71853e;

            public ThreadFactoryC1979a(C1978a c1978a, ThreadFactory threadFactory) {
                this.f71853e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f71853e.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* renamed from: h.o.c.a$a$b */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1978a.this.a();
            }
        }

        public C1978a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f71847a = threadFactory;
            this.f71848b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f71849c = new ConcurrentLinkedQueue<>();
            this.f71850d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1979a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f71848b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f71851e = scheduledExecutorService;
            this.f71852f = scheduledFuture;
        }

        public void a() {
            if (this.f71849c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f71849c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f71849c.remove(next)) {
                    this.f71850d.b(next);
                }
            }
        }

        public c b() {
            if (this.f71850d.isUnsubscribed()) {
                return a.f71844i;
            }
            while (!this.f71849c.isEmpty()) {
                c poll = this.f71849c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f71847a);
            this.f71850d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f71848b);
            this.f71849c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f71852f != null) {
                    this.f71852f.cancel(true);
                }
                if (this.f71851e != null) {
                    this.f71851e.shutdownNow();
                }
            } finally {
                this.f71850d.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1978a f71856f;

        /* renamed from: g  reason: collision with root package name */
        public final c f71857g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f71855e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f71858h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1980a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f71859e;

            public C1980a(h.n.a aVar) {
                this.f71859e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f71859e.call();
            }
        }

        public b(C1978a c1978a) {
            this.f71856f = c1978a;
            this.f71857g = c1978a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f71855e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f71857g.h(new C1980a(aVar), j, timeUnit);
            this.f71855e.a(h2);
            h2.addParent(this.f71855e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f71856f.d(this.f71857g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71855e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f71858h.compareAndSet(false, true)) {
                this.f71857g.b(this);
            }
            this.f71855e.unsubscribe();
        }
    }

    /* loaded from: classes8.dex */
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
        f71844i = cVar;
        cVar.unsubscribe();
        C1978a c1978a = new C1978a(null, 0L, null);
        j = c1978a;
        c1978a.e();
        f71842g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f71845e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f71846f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1978a c1978a;
        C1978a c1978a2;
        do {
            c1978a = this.f71846f.get();
            c1978a2 = j;
            if (c1978a == c1978a2) {
                return;
            }
        } while (!this.f71846f.compareAndSet(c1978a, c1978a2));
        c1978a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1978a c1978a = new C1978a(this.f71845e, f71842g, f71843h);
        if (this.f71846f.compareAndSet(j, c1978a)) {
            return;
        }
        c1978a.e();
    }
}
