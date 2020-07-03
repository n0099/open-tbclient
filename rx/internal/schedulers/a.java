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
    private static final long oeP;
    static final C0925a oeR;
    final ThreadFactory bAJ;
    final AtomicReference<C0925a> nMz = new AtomicReference<>(oeR);
    private static final TimeUnit nMT = TimeUnit.SECONDS;
    static final c oeQ = new c(RxThreadFactory.NONE);

    static {
        oeQ.unsubscribe();
        oeR = new C0925a(null, 0L, null);
        oeR.shutdown();
        oeP = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0925a {
        private final ThreadFactory bAJ;
        private final long nMW;
        private final ConcurrentLinkedQueue<c> nMX;
        private final ScheduledExecutorService nMZ;
        private final Future<?> nNa;
        private final rx.subscriptions.b oeS;

        C0925a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.bAJ = threadFactory;
            this.nMW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nMX = new ConcurrentLinkedQueue<>();
            this.oeS = new rx.subscriptions.b();
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
                        C0925a.this.dPM();
                    }
                }, this.nMW, this.nMW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nMZ = scheduledExecutorService;
            this.nNa = scheduledFuture;
        }

        c dUJ() {
            if (this.oeS.isUnsubscribed()) {
                return a.oeQ;
            }
            while (!this.nMX.isEmpty()) {
                c poll = this.nMX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bAJ);
            this.oeS.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gl(now() + this.nMW);
            this.nMX.offer(cVar);
        }

        void dPM() {
            if (!this.nMX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nMX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dPN() <= now) {
                        if (this.nMX.remove(next)) {
                            this.oeS.a(next);
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
                if (this.nNa != null) {
                    this.nNa.cancel(true);
                }
                if (this.nMZ != null) {
                    this.nMZ.shutdownNow();
                }
            } finally {
                this.oeS.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0925a c0925a = new C0925a(this.bAJ, oeP, nMT);
        if (!this.nMz.compareAndSet(oeR, c0925a)) {
            c0925a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0925a c0925a;
        do {
            c0925a = this.nMz.get();
            if (c0925a == oeR) {
                return;
            }
        } while (!this.nMz.compareAndSet(c0925a, oeR));
        c0925a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nMz.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0925a oeW;
        private final c oeX;
        private final rx.subscriptions.b oeV = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0925a c0925a) {
            this.oeW = c0925a;
            this.oeX = c0925a.dUJ();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.oeX.c(this);
            }
            this.oeV.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.oeW.a(this.oeX);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oeV.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.oeV.isUnsubscribed()) {
                return rx.subscriptions.e.dVO();
            }
            ScheduledAction b = this.oeX.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.oeV.add(b);
            b.addParent(this.oeV);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nNd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nNd = 0L;
        }

        public long dPN() {
            return this.nNd;
        }

        public void gl(long j) {
            this.nNd = j;
        }
    }
}
