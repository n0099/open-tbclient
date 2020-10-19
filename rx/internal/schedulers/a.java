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
    private static final long pgL;
    static final C1014a pgN;
    final ThreadFactory oOy;
    final AtomicReference<C1014a> oOz = new AtomicReference<>(pgN);
    private static final TimeUnit oOT = TimeUnit.SECONDS;
    static final c pgM = new c(RxThreadFactory.NONE);

    static {
        pgM.unsubscribe();
        pgN = new C1014a(null, 0L, null);
        pgN.shutdown();
        pgL = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C1014a {
        private final long oOW;
        private final ConcurrentLinkedQueue<c> oOX;
        private final ScheduledExecutorService oOZ;
        private final ThreadFactory oOy;
        private final Future<?> oPa;
        private final rx.subscriptions.b pgO;

        C1014a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.oOy = threadFactory;
            this.oOW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.oOX = new ConcurrentLinkedQueue<>();
            this.pgO = new rx.subscriptions.b();
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
                        C1014a.this.enh();
                    }
                }, this.oOW, this.oOW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.oOZ = scheduledExecutorService;
            this.oPa = scheduledFuture;
        }

        c esg() {
            if (this.pgO.isUnsubscribed()) {
                return a.pgM;
            }
            while (!this.oOX.isEmpty()) {
                c poll = this.oOX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.oOy);
            this.pgO.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ht(now() + this.oOW);
            this.oOX.offer(cVar);
        }

        void enh() {
            if (!this.oOX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.oOX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eni() <= now) {
                        if (this.oOX.remove(next)) {
                            this.pgO.a(next);
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
                if (this.oPa != null) {
                    this.oPa.cancel(true);
                }
                if (this.oOZ != null) {
                    this.oOZ.shutdownNow();
                }
            } finally {
                this.pgO.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.oOy = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1014a c1014a = new C1014a(this.oOy, pgL, oOT);
        if (!this.oOz.compareAndSet(pgN, c1014a)) {
            c1014a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1014a c1014a;
        do {
            c1014a = this.oOz.get();
            if (c1014a == pgN) {
                return;
            }
        } while (!this.oOz.compareAndSet(c1014a, pgN));
        c1014a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.oOz.get());
    }

    /* loaded from: classes16.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1014a pgS;
        private final c pgT;
        private final rx.subscriptions.b pgR = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1014a c1014a) {
            this.pgS = c1014a;
            this.pgT = c1014a.esg();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.pgT.c(this);
            }
            this.pgR.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.pgS.a(this.pgT);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pgR.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.pgR.isUnsubscribed()) {
                return rx.subscriptions.e.etl();
            }
            ScheduledAction b = this.pgT.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.pgR.add(b);
            b.addParent(this.pgR);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class c extends g {
        private long oPd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.oPd = 0L;
        }

        public long eni() {
            return this.oPd;
        }

        public void ht(long j) {
            this.oPd = j;
        }
    }
}
