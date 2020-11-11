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
    static final C1106a qhA;
    private static final long qhy;
    final ThreadFactory pPp;
    final AtomicReference<C1106a> pPq = new AtomicReference<>(qhA);
    private static final TimeUnit pPK = TimeUnit.SECONDS;
    static final c qhz = new c(RxThreadFactory.NONE);

    static {
        qhz.unsubscribe();
        qhA = new C1106a(null, 0L, null);
        qhA.shutdown();
        qhy = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C1106a {
        private final long pPN;
        private final ConcurrentLinkedQueue<c> pPO;
        private final ScheduledExecutorService pPQ;
        private final Future<?> pPR;
        private final ThreadFactory pPp;
        private final rx.subscriptions.b qhB;

        C1106a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pPp = threadFactory;
            this.pPN = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pPO = new ConcurrentLinkedQueue<>();
            this.qhB = new rx.subscriptions.b();
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
                        C1106a.this.eAV();
                    }
                }, this.pPN, this.pPN, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pPQ = scheduledExecutorService;
            this.pPR = scheduledFuture;
        }

        c eFT() {
            if (this.qhB.isUnsubscribed()) {
                return a.qhz;
            }
            while (!this.pPO.isEmpty()) {
                c poll = this.pPO.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pPp);
            this.qhB.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.m605if(now() + this.pPN);
            this.pPO.offer(cVar);
        }

        void eAV() {
            if (!this.pPO.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pPO.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eAW() <= now) {
                        if (this.pPO.remove(next)) {
                            this.qhB.a(next);
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
                if (this.pPR != null) {
                    this.pPR.cancel(true);
                }
                if (this.pPQ != null) {
                    this.pPQ.shutdownNow();
                }
            } finally {
                this.qhB.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.pPp = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1106a c1106a = new C1106a(this.pPp, qhy, pPK);
        if (!this.pPq.compareAndSet(qhA, c1106a)) {
            c1106a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1106a c1106a;
        do {
            c1106a = this.pPq.get();
            if (c1106a == qhA) {
                return;
            }
        } while (!this.pPq.compareAndSet(c1106a, qhA));
        c1106a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.pPq.get());
    }

    /* loaded from: classes16.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1106a qhF;
        private final c qhG;
        private final rx.subscriptions.b qhE = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1106a c1106a) {
            this.qhF = c1106a;
            this.qhG = c1106a.eFT();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qhG.c(this);
            }
            this.qhE.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qhF.a(this.qhG);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qhE.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qhE.isUnsubscribed()) {
                return rx.subscriptions.e.eGY();
            }
            ScheduledAction b = this.qhG.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qhE.add(b);
            b.addParent(this.qhE);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class c extends g {
        private long pPU;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pPU = 0L;
        }

        public long eAW() {
            return this.pPU;
        }

        /* renamed from: if  reason: not valid java name */
        public void m605if(long j) {
            this.pPU = j;
        }
    }
}
