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
    public static final long f69009g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f69010h = TimeUnit.SECONDS;
    public static final c i;
    public static final C1915a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f69011e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1915a> f69012f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1915a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f69013a;

        /* renamed from: b  reason: collision with root package name */
        public final long f69014b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f69015c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f69016d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f69017e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f69018f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class ThreadFactoryC1916a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f69019e;

            public ThreadFactoryC1916a(C1915a c1915a, ThreadFactory threadFactory) {
                this.f69019e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f69019e.newThread(runnable);
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
                C1915a.this.a();
            }
        }

        public C1915a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f69013a = threadFactory;
            this.f69014b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f69015c = new ConcurrentLinkedQueue<>();
            this.f69016d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1916a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f69014b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f69017e = scheduledExecutorService;
            this.f69018f = scheduledFuture;
        }

        public void a() {
            if (this.f69015c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f69015c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f69015c.remove(next)) {
                    this.f69016d.b(next);
                }
            }
        }

        public c b() {
            if (this.f69016d.isUnsubscribed()) {
                return a.i;
            }
            while (!this.f69015c.isEmpty()) {
                c poll = this.f69015c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f69013a);
            this.f69016d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f69014b);
            this.f69015c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f69018f != null) {
                    this.f69018f.cancel(true);
                }
                if (this.f69017e != null) {
                    this.f69017e.shutdownNow();
                }
            } finally {
                this.f69016d.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1915a f69022f;

        /* renamed from: g  reason: collision with root package name */
        public final c f69023g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f69021e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f69024h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1917a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f69025e;

            public C1917a(h.n.a aVar) {
                this.f69025e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f69025e.call();
            }
        }

        public b(C1915a c1915a) {
            this.f69022f = c1915a;
            this.f69023g = c1915a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f69021e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f69023g.h(new C1917a(aVar), j, timeUnit);
            this.f69021e.a(h2);
            h2.addParent(this.f69021e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f69022f.d(this.f69023g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69021e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f69024h.compareAndSet(false, true)) {
                this.f69023g.b(this);
            }
            this.f69021e.unsubscribe();
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
        i = cVar;
        cVar.unsubscribe();
        C1915a c1915a = new C1915a(null, 0L, null);
        j = c1915a;
        c1915a.e();
        f69009g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f69011e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f69012f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1915a c1915a;
        C1915a c1915a2;
        do {
            c1915a = this.f69012f.get();
            c1915a2 = j;
            if (c1915a == c1915a2) {
                return;
            }
        } while (!this.f69012f.compareAndSet(c1915a, c1915a2));
        c1915a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1915a c1915a = new C1915a(this.f69011e, f69009g, f69010h);
        if (this.f69012f.compareAndSet(j, c1915a)) {
            return;
        }
        c1915a.e();
    }
}
