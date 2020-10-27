package rx.internal.schedulers;

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
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes16.dex */
public final class a extends rx.g implements h {
    private static final long pYe;
    static final C1086a pYg;
    final ThreadFactory pFV;
    final AtomicReference<C1086a> pFW = new AtomicReference<>(pYg);
    private static final TimeUnit pGq = TimeUnit.SECONDS;
    static final c pYf = new c(RxThreadFactory.NONE);

    static {
        pYf.unsubscribe();
        pYg = new C1086a(null, 0L, null);
        pYg.shutdown();
        pYe = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C1086a {
        private final ThreadFactory pFV;
        private final long pGt;
        private final ConcurrentLinkedQueue<c> pGu;
        private final ScheduledExecutorService pGw;
        private final Future<?> pGx;
        private final rx.subscriptions.b pYh;

        C1086a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pFV = threadFactory;
            this.pGt = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pGu = new ConcurrentLinkedQueue<>();
            this.pYh = new rx.subscriptions.b();
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.schedulers.a.a.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                g.b(newScheduledThreadPool);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.schedulers.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C1086a.this.exg();
                    }
                }, this.pGt, this.pGt, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pGw = scheduledExecutorService;
            this.pGx = scheduledFuture;
        }

        c eCe() {
            if (this.pYh.isUnsubscribed()) {
                return a.pYf;
            }
            while (!this.pGu.isEmpty()) {
                c poll = this.pGu.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pFV);
            this.pYh.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hJ(now() + this.pGt);
            this.pGu.offer(cVar);
        }

        void exg() {
            if (!this.pGu.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pGu.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.exh() <= now) {
                        if (this.pGu.remove(next)) {
                            this.pYh.a(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        long now() {
            return System.nanoTime();
        }

        void shutdown() {
            try {
                if (this.pGx != null) {
                    this.pGx.cancel(true);
                }
                if (this.pGw != null) {
                    this.pGw.shutdownNow();
                }
            } finally {
                this.pYh.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.pFV = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1086a c1086a = new C1086a(this.pFV, pYe, pGq);
        if (!this.pFW.compareAndSet(pYg, c1086a)) {
            c1086a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1086a c1086a;
        do {
            c1086a = this.pFW.get();
            if (c1086a == pYg) {
                return;
            }
        } while (!this.pFW.compareAndSet(c1086a, pYg));
        c1086a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.pFW.get());
    }

    /* loaded from: classes16.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1086a pYl;
        private final c pYm;
        private final rx.subscriptions.b pYk = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1086a c1086a) {
            this.pYl = c1086a;
            this.pYm = c1086a.eCe();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.pYm.c(this);
            }
            this.pYk.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.pYl.a(this.pYm);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pYk.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.pYk.isUnsubscribed()) {
                return rx.subscriptions.e.eDj();
            }
            ScheduledAction b = this.pYm.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.pYk.add(b);
            b.addParent(this.pYk);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class c extends g {
        private long pGA;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pGA = 0L;
        }

        public long exh() {
            return this.pGA;
        }

        public void hJ(long j) {
            this.pGA = j;
        }
    }
}
