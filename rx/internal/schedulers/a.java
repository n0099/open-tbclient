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
    private static final long nHS;
    static final C0905a nHU;
    final ThreadFactory bvS;
    final AtomicReference<C0905a> npC = new AtomicReference<>(nHU);
    private static final TimeUnit npW = TimeUnit.SECONDS;
    static final c nHT = new c(RxThreadFactory.NONE);

    static {
        nHT.unsubscribe();
        nHU = new C0905a(null, 0L, null);
        nHU.shutdown();
        nHS = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0905a {
        private final ThreadFactory bvS;
        private final rx.subscriptions.b nHV;
        private final long npZ;
        private final ConcurrentLinkedQueue<c> nqa;
        private final ScheduledExecutorService nqc;
        private final Future<?> nqd;

        C0905a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.bvS = threadFactory;
            this.npZ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nqa = new ConcurrentLinkedQueue<>();
            this.nHV = new rx.subscriptions.b();
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
                        C0905a.this.dKS();
                    }
                }, this.npZ, this.npZ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nqc = scheduledExecutorService;
            this.nqd = scheduledFuture;
        }

        c dPP() {
            if (this.nHV.isUnsubscribed()) {
                return a.nHT;
            }
            while (!this.nqa.isEmpty()) {
                c poll = this.nqa.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bvS);
            this.nHV.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gg(now() + this.npZ);
            this.nqa.offer(cVar);
        }

        void dKS() {
            if (!this.nqa.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nqa.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dKT() <= now) {
                        if (this.nqa.remove(next)) {
                            this.nHV.a(next);
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
                if (this.nqd != null) {
                    this.nqd.cancel(true);
                }
                if (this.nqc != null) {
                    this.nqc.shutdownNow();
                }
            } finally {
                this.nHV.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0905a c0905a = new C0905a(this.bvS, nHS, npW);
        if (!this.npC.compareAndSet(nHU, c0905a)) {
            c0905a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0905a c0905a;
        do {
            c0905a = this.npC.get();
            if (c0905a == nHU) {
                return;
            }
        } while (!this.npC.compareAndSet(c0905a, nHU));
        c0905a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.npC.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0905a nHZ;
        private final c nIa;
        private final rx.subscriptions.b nHY = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0905a c0905a) {
            this.nHZ = c0905a;
            this.nIa = c0905a.dPP();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nIa.c(this);
            }
            this.nHY.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nHZ.a(this.nIa);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nHY.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nHY.isUnsubscribed()) {
                return rx.subscriptions.e.dQU();
            }
            ScheduledAction b = this.nIa.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nHY.add(b);
            b.addParent(this.nHY);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nqg;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nqg = 0L;
        }

        public long dKT() {
            return this.nqg;
        }

        public void gg(long j) {
            this.nqg = j;
        }
    }
}
