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
    public static final long f71946g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f71947h = TimeUnit.SECONDS;

    /* renamed from: i  reason: collision with root package name */
    public static final c f71948i;
    public static final C1981a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f71949e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1981a> f71950f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1981a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f71951a;

        /* renamed from: b  reason: collision with root package name */
        public final long f71952b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f71953c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f71954d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f71955e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f71956f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class ThreadFactoryC1982a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f71957e;

            public ThreadFactoryC1982a(C1981a c1981a, ThreadFactory threadFactory) {
                this.f71957e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f71957e.newThread(runnable);
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
                C1981a.this.a();
            }
        }

        public C1981a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f71951a = threadFactory;
            this.f71952b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f71953c = new ConcurrentLinkedQueue<>();
            this.f71954d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1982a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f71952b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f71955e = scheduledExecutorService;
            this.f71956f = scheduledFuture;
        }

        public void a() {
            if (this.f71953c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f71953c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f71953c.remove(next)) {
                    this.f71954d.b(next);
                }
            }
        }

        public c b() {
            if (this.f71954d.isUnsubscribed()) {
                return a.f71948i;
            }
            while (!this.f71953c.isEmpty()) {
                c poll = this.f71953c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f71951a);
            this.f71954d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f71952b);
            this.f71953c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f71956f != null) {
                    this.f71956f.cancel(true);
                }
                if (this.f71955e != null) {
                    this.f71955e.shutdownNow();
                }
            } finally {
                this.f71954d.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1981a f71960f;

        /* renamed from: g  reason: collision with root package name */
        public final c f71961g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f71959e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f71962h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1983a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f71963e;

            public C1983a(h.n.a aVar) {
                this.f71963e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f71963e.call();
            }
        }

        public b(C1981a c1981a) {
            this.f71960f = c1981a;
            this.f71961g = c1981a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f71959e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f71961g.h(new C1983a(aVar), j, timeUnit);
            this.f71959e.a(h2);
            h2.addParent(this.f71959e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f71960f.d(this.f71961g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71959e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f71962h.compareAndSet(false, true)) {
                this.f71961g.b(this);
            }
            this.f71959e.unsubscribe();
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
        f71948i = cVar;
        cVar.unsubscribe();
        C1981a c1981a = new C1981a(null, 0L, null);
        j = c1981a;
        c1981a.e();
        f71946g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f71949e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f71950f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1981a c1981a;
        C1981a c1981a2;
        do {
            c1981a = this.f71950f.get();
            c1981a2 = j;
            if (c1981a == c1981a2) {
                return;
            }
        } while (!this.f71950f.compareAndSet(c1981a, c1981a2));
        c1981a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1981a c1981a = new C1981a(this.f71949e, f71946g, f71947h);
        if (this.f71950f.compareAndSet(j, c1981a)) {
            return;
        }
        c1981a.e();
    }
}
