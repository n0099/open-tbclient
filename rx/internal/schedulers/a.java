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
    private static final long qrN;
    static final C1315a qrP;
    final ThreadFactory qgs;
    final AtomicReference<C1315a> qgt = new AtomicReference<>(qrP);
    private static final TimeUnit qgN = TimeUnit.SECONDS;
    static final c qrO = new c(RxThreadFactory.NONE);

    static {
        qrO.unsubscribe();
        qrP = new C1315a(null, 0L, null);
        qrP.shutdown();
        qrN = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1315a {
        private final long qgQ;
        private final ConcurrentLinkedQueue<c> qgR;
        private final ScheduledExecutorService qgT;
        private final Future<?> qgU;
        private final ThreadFactory qgs;
        private final rx.subscriptions.b qrQ;

        C1315a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qgs = threadFactory;
            this.qgQ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qgR = new ConcurrentLinkedQueue<>();
            this.qrQ = new rx.subscriptions.b();
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
                }, this.qgQ, this.qgQ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qgT = scheduledExecutorService;
            this.qgU = scheduledFuture;
        }

        c eKQ() {
            if (this.qrQ.isUnsubscribed()) {
                return a.qrO;
            }
            while (!this.qgR.isEmpty()) {
                c poll = this.qgR.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qgs);
            this.qrQ.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ju(now() + this.qgQ);
            this.qgR.offer(cVar);
        }

        void eIk() {
            if (!this.qgR.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qgR.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eIl() <= now) {
                        if (this.qgR.remove(next)) {
                            this.qrQ.a(next);
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
                if (this.qgU != null) {
                    this.qgU.cancel(true);
                }
                if (this.qgT != null) {
                    this.qgT.shutdownNow();
                }
            } finally {
                this.qrQ.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.qgs = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1315a c1315a = new C1315a(this.qgs, qrN, qgN);
        if (!this.qgt.compareAndSet(qrP, c1315a)) {
            c1315a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1315a c1315a;
        do {
            c1315a = this.qgt.get();
            if (c1315a == qrP) {
                return;
            }
        } while (!this.qgt.compareAndSet(c1315a, qrP));
        c1315a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.qgt.get());
    }

    /* loaded from: classes14.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1315a qrU;
        private final c qrV;
        private final rx.subscriptions.b qrT = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1315a c1315a) {
            this.qrU = c1315a;
            this.qrV = c1315a.eKQ();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qrV.c(this);
            }
            this.qrT.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qrU.a(this.qrV);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qrT.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qrT.isUnsubscribed()) {
                return rx.subscriptions.e.eLX();
            }
            ScheduledAction b2 = this.qrV.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qrT.add(b2);
            b2.addParent(this.qrT);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class c extends g {
        private long qgX;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qgX = 0L;
        }

        public long eIl() {
            return this.qgX;
        }

        public void ju(long j) {
            this.qgX = j;
        }
    }
}
