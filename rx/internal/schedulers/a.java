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
/* loaded from: classes14.dex */
public final class a extends rx.g implements h {
    private static final long qrM;
    static final C1315a qrO;
    final ThreadFactory qgr;
    final AtomicReference<C1315a> qgs = new AtomicReference<>(qrO);
    private static final TimeUnit qgM = TimeUnit.SECONDS;
    static final c qrN = new c(RxThreadFactory.NONE);

    static {
        qrN.unsubscribe();
        qrO = new C1315a(null, 0L, null);
        qrO.shutdown();
        qrM = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1315a {
        private final long qgP;
        private final ConcurrentLinkedQueue<c> qgQ;
        private final ScheduledExecutorService qgS;
        private final Future<?> qgT;
        private final ThreadFactory qgr;
        private final rx.subscriptions.b qrP;

        C1315a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qgr = threadFactory;
            this.qgP = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qgQ = new ConcurrentLinkedQueue<>();
            this.qrP = new rx.subscriptions.b();
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
                        C1315a.this.eIk();
                    }
                }, this.qgP, this.qgP, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qgS = scheduledExecutorService;
            this.qgT = scheduledFuture;
        }

        c eKQ() {
            if (this.qrP.isUnsubscribed()) {
                return a.qrN;
            }
            while (!this.qgQ.isEmpty()) {
                c poll = this.qgQ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qgr);
            this.qrP.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ju(now() + this.qgP);
            this.qgQ.offer(cVar);
        }

        void eIk() {
            if (!this.qgQ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qgQ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eIl() <= now) {
                        if (this.qgQ.remove(next)) {
                            this.qrP.a(next);
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
                if (this.qgT != null) {
                    this.qgT.cancel(true);
                }
                if (this.qgS != null) {
                    this.qgS.shutdownNow();
                }
            } finally {
                this.qrP.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.qgr = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1315a c1315a = new C1315a(this.qgr, qrM, qgM);
        if (!this.qgs.compareAndSet(qrO, c1315a)) {
            c1315a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1315a c1315a;
        do {
            c1315a = this.qgs.get();
            if (c1315a == qrO) {
                return;
            }
        } while (!this.qgs.compareAndSet(c1315a, qrO));
        c1315a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.qgs.get());
    }

    /* loaded from: classes14.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1315a qrT;
        private final c qrU;
        private final rx.subscriptions.b qrS = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1315a c1315a) {
            this.qrT = c1315a;
            this.qrU = c1315a.eKQ();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qrU.c(this);
            }
            this.qrS.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qrT.a(this.qrU);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qrS.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qrS.isUnsubscribed()) {
                return rx.subscriptions.e.eLX();
            }
            ScheduledAction b2 = this.qrU.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qrS.add(b2);
            b2.addParent(this.qrS);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class c extends g {
        private long qgW;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qgW = 0L;
        }

        public long eIl() {
            return this.qgW;
        }

        public void ju(long j) {
            this.qgW = j;
        }
    }
}
