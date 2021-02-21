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
/* loaded from: classes5.dex */
public final class a extends rx.g implements h {
    private static final long qCq;
    static final C1327a qCs;
    final ThreadFactory qqW;
    final AtomicReference<C1327a> qqX = new AtomicReference<>(qCs);
    private static final TimeUnit qrr = TimeUnit.SECONDS;
    static final c qCr = new c(RxThreadFactory.NONE);

    static {
        qCr.unsubscribe();
        qCs = new C1327a(null, 0L, null);
        qCs.shutdown();
        qCq = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1327a {
        private final rx.subscriptions.b qCt;
        private final ThreadFactory qqW;
        private final long qru;
        private final ConcurrentLinkedQueue<c> qrv;
        private final ScheduledExecutorService qrx;
        private final Future<?> qry;

        C1327a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qqW = threadFactory;
            this.qru = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qrv = new ConcurrentLinkedQueue<>();
            this.qCt = new rx.subscriptions.b();
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.schedulers.a.a.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                g.b(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.schedulers.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C1327a.this.eKI();
                    }
                }, this.qru, this.qru, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qrx = scheduledExecutorService;
            this.qry = scheduledFuture;
        }

        c eNo() {
            if (this.qCt.isUnsubscribed()) {
                return a.qCr;
            }
            while (!this.qrv.isEmpty()) {
                c poll = this.qrv.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qqW);
            this.qCt.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jx(now() + this.qru);
            this.qrv.offer(cVar);
        }

        void eKI() {
            if (!this.qrv.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qrv.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eKJ() <= now) {
                        if (this.qrv.remove(next)) {
                            this.qCt.a(next);
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
                if (this.qry != null) {
                    this.qry.cancel(true);
                }
                if (this.qrx != null) {
                    this.qrx.shutdownNow();
                }
            } finally {
                this.qCt.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.qqW = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1327a c1327a = new C1327a(this.qqW, qCq, qrr);
        if (!this.qqX.compareAndSet(qCs, c1327a)) {
            c1327a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1327a c1327a;
        do {
            c1327a = this.qqX.get();
            if (c1327a == qCs) {
                return;
            }
        } while (!this.qqX.compareAndSet(c1327a, qCs));
        c1327a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.qqX.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1327a qCx;
        private final c qCy;
        private final rx.subscriptions.b qCw = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1327a c1327a) {
            this.qCx = c1327a;
            this.qCy = c1327a.eNo();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qCy.c(this);
            }
            this.qCw.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qCx.a(this.qCy);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qCw.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qCw.isUnsubscribed()) {
                return rx.subscriptions.e.eOv();
            }
            ScheduledAction b2 = this.qCy.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qCw.add(b2);
            b2.addParent(this.qCw);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        private long qrB;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qrB = 0L;
        }

        public long eKJ() {
            return this.qrB;
        }

        public void jx(long j) {
            this.qrB = j;
        }
    }
}
