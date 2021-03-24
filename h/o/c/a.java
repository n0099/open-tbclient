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
    public static final long f67847g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f67848h = TimeUnit.SECONDS;
    public static final c i;
    public static final C1875a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f67849e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1875a> f67850f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1875a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f67851a;

        /* renamed from: b  reason: collision with root package name */
        public final long f67852b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f67853c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f67854d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f67855e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f67856f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class ThreadFactoryC1876a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f67857e;

            public ThreadFactoryC1876a(C1875a c1875a, ThreadFactory threadFactory) {
                this.f67857e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f67857e.newThread(runnable);
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
                C1875a.this.a();
            }
        }

        public C1875a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f67851a = threadFactory;
            this.f67852b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f67853c = new ConcurrentLinkedQueue<>();
            this.f67854d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1876a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f67852b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f67855e = scheduledExecutorService;
            this.f67856f = scheduledFuture;
        }

        public void a() {
            if (this.f67853c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f67853c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f67853c.remove(next)) {
                    this.f67854d.b(next);
                }
            }
        }

        public c b() {
            if (this.f67854d.isUnsubscribed()) {
                return a.i;
            }
            while (!this.f67853c.isEmpty()) {
                c poll = this.f67853c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f67851a);
            this.f67854d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f67852b);
            this.f67853c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f67856f != null) {
                    this.f67856f.cancel(true);
                }
                if (this.f67855e != null) {
                    this.f67855e.shutdownNow();
                }
            } finally {
                this.f67854d.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1875a f67860f;

        /* renamed from: g  reason: collision with root package name */
        public final c f67861g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f67859e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f67862h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1877a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67863e;

            public C1877a(h.n.a aVar) {
                this.f67863e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f67863e.call();
            }
        }

        public b(C1875a c1875a) {
            this.f67860f = c1875a;
            this.f67861g = c1875a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f67859e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f67861g.h(new C1877a(aVar), j, timeUnit);
            this.f67859e.a(h2);
            h2.addParent(this.f67859e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f67860f.d(this.f67861g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67859e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f67862h.compareAndSet(false, true)) {
                this.f67861g.b(this);
            }
            this.f67859e.unsubscribe();
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
        C1875a c1875a = new C1875a(null, 0L, null);
        j = c1875a;
        c1875a.e();
        f67847g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f67849e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f67850f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1875a c1875a;
        C1875a c1875a2;
        do {
            c1875a = this.f67850f.get();
            c1875a2 = j;
            if (c1875a == c1875a2) {
                return;
            }
        } while (!this.f67850f.compareAndSet(c1875a, c1875a2));
        c1875a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1875a c1875a = new C1875a(this.f67849e, f67847g, f67848h);
        if (this.f67850f.compareAndSet(j, c1875a)) {
            return;
        }
        c1875a.e();
    }
}
