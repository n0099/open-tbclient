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
    public static final long f67852g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f67853h = TimeUnit.SECONDS;
    public static final c i;
    public static final C1876a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f67854e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1876a> f67855f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1876a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f67856a;

        /* renamed from: b  reason: collision with root package name */
        public final long f67857b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f67858c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f67859d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f67860e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f67861f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class ThreadFactoryC1877a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f67862e;

            public ThreadFactoryC1877a(C1876a c1876a, ThreadFactory threadFactory) {
                this.f67862e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f67862e.newThread(runnable);
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
                C1876a.this.a();
            }
        }

        public C1876a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f67856a = threadFactory;
            this.f67857b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f67858c = new ConcurrentLinkedQueue<>();
            this.f67859d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1877a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f67857b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f67860e = scheduledExecutorService;
            this.f67861f = scheduledFuture;
        }

        public void a() {
            if (this.f67858c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f67858c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f67858c.remove(next)) {
                    this.f67859d.b(next);
                }
            }
        }

        public c b() {
            if (this.f67859d.isUnsubscribed()) {
                return a.i;
            }
            while (!this.f67858c.isEmpty()) {
                c poll = this.f67858c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f67856a);
            this.f67859d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f67857b);
            this.f67858c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f67861f != null) {
                    this.f67861f.cancel(true);
                }
                if (this.f67860e != null) {
                    this.f67860e.shutdownNow();
                }
            } finally {
                this.f67859d.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1876a f67865f;

        /* renamed from: g  reason: collision with root package name */
        public final c f67866g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f67864e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f67867h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1878a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67868e;

            public C1878a(h.n.a aVar) {
                this.f67868e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f67868e.call();
            }
        }

        public b(C1876a c1876a) {
            this.f67865f = c1876a;
            this.f67866g = c1876a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f67864e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f67866g.h(new C1878a(aVar), j, timeUnit);
            this.f67864e.a(h2);
            h2.addParent(this.f67864e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f67865f.d(this.f67866g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67864e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f67867h.compareAndSet(false, true)) {
                this.f67866g.b(this);
            }
            this.f67864e.unsubscribe();
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
        C1876a c1876a = new C1876a(null, 0L, null);
        j = c1876a;
        c1876a.e();
        f67852g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f67854e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f67855f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1876a c1876a;
        C1876a c1876a2;
        do {
            c1876a = this.f67855f.get();
            c1876a2 = j;
            if (c1876a == c1876a2) {
                return;
            }
        } while (!this.f67855f.compareAndSet(c1876a, c1876a2));
        c1876a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1876a c1876a = new C1876a(this.f67854e, f67852g, f67853h);
        if (this.f67855f.compareAndSet(j, c1876a)) {
            return;
        }
        c1876a.e();
    }
}
