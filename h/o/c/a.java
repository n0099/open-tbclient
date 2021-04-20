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
    public static final long f68862g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f68863h = TimeUnit.SECONDS;
    public static final c i;
    public static final C1911a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f68864e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1911a> f68865f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1911a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f68866a;

        /* renamed from: b  reason: collision with root package name */
        public final long f68867b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f68868c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f68869d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f68870e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f68871f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class ThreadFactoryC1912a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f68872e;

            public ThreadFactoryC1912a(C1911a c1911a, ThreadFactory threadFactory) {
                this.f68872e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f68872e.newThread(runnable);
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
                C1911a.this.a();
            }
        }

        public C1911a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f68866a = threadFactory;
            this.f68867b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f68868c = new ConcurrentLinkedQueue<>();
            this.f68869d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1912a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f68867b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f68870e = scheduledExecutorService;
            this.f68871f = scheduledFuture;
        }

        public void a() {
            if (this.f68868c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f68868c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f68868c.remove(next)) {
                    this.f68869d.b(next);
                }
            }
        }

        public c b() {
            if (this.f68869d.isUnsubscribed()) {
                return a.i;
            }
            while (!this.f68868c.isEmpty()) {
                c poll = this.f68868c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f68866a);
            this.f68869d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f68867b);
            this.f68868c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f68871f != null) {
                    this.f68871f.cancel(true);
                }
                if (this.f68870e != null) {
                    this.f68870e.shutdownNow();
                }
            } finally {
                this.f68869d.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1911a f68875f;

        /* renamed from: g  reason: collision with root package name */
        public final c f68876g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f68874e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f68877h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1913a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68878e;

            public C1913a(h.n.a aVar) {
                this.f68878e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f68878e.call();
            }
        }

        public b(C1911a c1911a) {
            this.f68875f = c1911a;
            this.f68876g = c1911a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f68874e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f68876g.h(new C1913a(aVar), j, timeUnit);
            this.f68874e.a(h2);
            h2.addParent(this.f68874e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f68875f.d(this.f68876g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68874e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f68877h.compareAndSet(false, true)) {
                this.f68876g.b(this);
            }
            this.f68874e.unsubscribe();
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
        C1911a c1911a = new C1911a(null, 0L, null);
        j = c1911a;
        c1911a.e();
        f68862g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f68864e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f68865f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1911a c1911a;
        C1911a c1911a2;
        do {
            c1911a = this.f68865f.get();
            c1911a2 = j;
            if (c1911a == c1911a2) {
                return;
            }
        } while (!this.f68865f.compareAndSet(c1911a, c1911a2));
        c1911a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1911a c1911a = new C1911a(this.f68864e, f68862g, f68863h);
        if (this.f68865f.compareAndSet(j, c1911a)) {
            return;
        }
        c1911a.e();
    }
}
