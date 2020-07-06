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
/* loaded from: classes6.dex */
public final class a extends rx.g implements h {
    private static final long oeS;
    static final C0926a oeU;
    final ThreadFactory bAJ;
    final AtomicReference<C0926a> nMC = new AtomicReference<>(oeU);
    private static final TimeUnit nMW = TimeUnit.SECONDS;
    static final c oeT = new c(RxThreadFactory.NONE);

    static {
        oeT.unsubscribe();
        oeU = new C0926a(null, 0L, null);
        oeU.shutdown();
        oeS = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0926a {
        private final ThreadFactory bAJ;
        private final long nMZ;
        private final ConcurrentLinkedQueue<c> nNa;
        private final ScheduledExecutorService nNc;
        private final Future<?> nNd;
        private final rx.subscriptions.b oeV;

        C0926a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.bAJ = threadFactory;
            this.nMZ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nNa = new ConcurrentLinkedQueue<>();
            this.oeV = new rx.subscriptions.b();
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
                        C0926a.this.dPQ();
                    }
                }, this.nMZ, this.nMZ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nNc = scheduledExecutorService;
            this.nNd = scheduledFuture;
        }

        c dUN() {
            if (this.oeV.isUnsubscribed()) {
                return a.oeT;
            }
            while (!this.nNa.isEmpty()) {
                c poll = this.nNa.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bAJ);
            this.oeV.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gl(now() + this.nMZ);
            this.nNa.offer(cVar);
        }

        void dPQ() {
            if (!this.nNa.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nNa.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dPR() <= now) {
                        if (this.nNa.remove(next)) {
                            this.oeV.a(next);
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
                if (this.nNd != null) {
                    this.nNd.cancel(true);
                }
                if (this.nNc != null) {
                    this.nNc.shutdownNow();
                }
            } finally {
                this.oeV.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0926a c0926a = new C0926a(this.bAJ, oeS, nMW);
        if (!this.nMC.compareAndSet(oeU, c0926a)) {
            c0926a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0926a c0926a;
        do {
            c0926a = this.nMC.get();
            if (c0926a == oeU) {
                return;
            }
        } while (!this.nMC.compareAndSet(c0926a, oeU));
        c0926a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nMC.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0926a oeZ;
        private final c ofa;
        private final rx.subscriptions.b oeY = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0926a c0926a) {
            this.oeZ = c0926a;
            this.ofa = c0926a.dUN();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.ofa.c(this);
            }
            this.oeY.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.oeZ.a(this.ofa);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oeY.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.oeY.isUnsubscribed()) {
                return rx.subscriptions.e.dVS();
            }
            ScheduledAction b = this.ofa.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.oeY.add(b);
            b.addParent(this.oeY);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nNg;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nNg = 0L;
        }

        public long dPR() {
            return this.nNg;
        }

        public void gl(long j) {
            this.nNg = j;
        }
    }
}
