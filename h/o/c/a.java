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
    public static final long f67863g;

    /* renamed from: h  reason: collision with root package name */
    public static final TimeUnit f67864h = TimeUnit.SECONDS;

    /* renamed from: i  reason: collision with root package name */
    public static final c f67865i;
    public static final C1862a j;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f67866e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1862a> f67867f = new AtomicReference<>(j);

    /* renamed from: h.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1862a {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f67868a;

        /* renamed from: b  reason: collision with root package name */
        public final long f67869b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f67870c;

        /* renamed from: d  reason: collision with root package name */
        public final h.u.b f67871d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f67872e;

        /* renamed from: f  reason: collision with root package name */
        public final Future<?> f67873f;

        /* renamed from: h.o.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class ThreadFactoryC1863a implements ThreadFactory {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f67874e;

            public ThreadFactoryC1863a(C1862a c1862a, ThreadFactory threadFactory) {
                this.f67874e = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f67874e.newThread(runnable);
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
                C1862a.this.a();
            }
        }

        public C1862a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f67868a = threadFactory;
            this.f67869b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f67870c = new ConcurrentLinkedQueue<>();
            this.f67871d = new h.u.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1863a(this, threadFactory));
                g.k(scheduledExecutorService);
                b bVar = new b();
                long j2 = this.f67869b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(bVar, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f67872e = scheduledExecutorService;
            this.f67873f = scheduledFuture;
        }

        public void a() {
            if (this.f67870c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f67870c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.l() > c2) {
                    return;
                }
                if (this.f67870c.remove(next)) {
                    this.f67871d.b(next);
                }
            }
        }

        public c b() {
            if (this.f67871d.isUnsubscribed()) {
                return a.f67865i;
            }
            while (!this.f67870c.isEmpty()) {
                c poll = this.f67870c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f67868a);
            this.f67871d.a(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c cVar) {
            cVar.m(c() + this.f67869b);
            this.f67870c.offer(cVar);
        }

        public void e() {
            try {
                if (this.f67873f != null) {
                    this.f67873f.cancel(true);
                }
                if (this.f67872e != null) {
                    this.f67872e.shutdownNow();
                }
            } finally {
                this.f67871d.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends g.a implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final C1862a f67877f;

        /* renamed from: g  reason: collision with root package name */
        public final c f67878g;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.b f67876e = new h.u.b();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f67879h = new AtomicBoolean();

        /* renamed from: h.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1864a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67880e;

            public C1864a(h.n.a aVar) {
                this.f67880e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f67880e.call();
            }
        }

        public b(C1862a c1862a) {
            this.f67877f = c1862a;
            this.f67878g = c1862a.b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f67876e.isUnsubscribed()) {
                return h.u.e.c();
            }
            ScheduledAction h2 = this.f67878g.h(new C1864a(aVar), j, timeUnit);
            this.f67876e.a(h2);
            h2.addParent(this.f67876e);
            return h2;
        }

        @Override // h.n.a
        public void call() {
            this.f67877f.d(this.f67878g);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67876e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            if (this.f67879h.compareAndSet(false, true)) {
                this.f67878g.b(this);
            }
            this.f67876e.unsubscribe();
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
        f67865i = cVar;
        cVar.unsubscribe();
        C1862a c1862a = new C1862a(null, 0L, null);
        j = c1862a;
        c1862a.e();
        f67863g = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f67866e = threadFactory;
        start();
    }

    @Override // h.g
    public g.a createWorker() {
        return new b(this.f67867f.get());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1862a c1862a;
        C1862a c1862a2;
        do {
            c1862a = this.f67867f.get();
            c1862a2 = j;
            if (c1862a == c1862a2) {
                return;
            }
        } while (!this.f67867f.compareAndSet(c1862a, c1862a2));
        c1862a.e();
    }

    @Override // h.o.c.h
    public void start() {
        C1862a c1862a = new C1862a(this.f67866e, f67863g, f67864h);
        if (this.f67867f.compareAndSet(j, c1862a)) {
            return;
        }
        c1862a.e();
    }
}
