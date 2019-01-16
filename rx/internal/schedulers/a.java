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
/* loaded from: classes2.dex */
public final class a extends rx.g implements h {
    private static final long iOK;
    private static final TimeUnit iOL = TimeUnit.SECONDS;
    static final c iOM = new c(RxThreadFactory.NONE);
    static final C0422a iON;
    final ThreadFactory aib;
    final AtomicReference<C0422a> iOO = new AtomicReference<>(iON);

    static {
        iOM.unsubscribe();
        iON = new C0422a(null, 0L, null);
        iON.shutdown();
        iOK = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0422a {
        private final ThreadFactory aib;
        private final long iOP;
        private final ConcurrentLinkedQueue<c> iOQ;
        private final rx.subscriptions.b iOR;
        private final ScheduledExecutorService iOS;
        private final Future<?> iOT;

        C0422a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aib = threadFactory;
            this.iOP = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.iOQ = new ConcurrentLinkedQueue<>();
            this.iOR = new rx.subscriptions.b();
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
                        C0422a.this.cfE();
                    }
                }, this.iOP, this.iOP, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.iOS = scheduledExecutorService;
            this.iOT = scheduledFuture;
        }

        c cfD() {
            if (this.iOR.isUnsubscribed()) {
                return a.iOM;
            }
            while (!this.iOQ.isEmpty()) {
                c poll = this.iOQ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aib);
            this.iOR.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.dR(now() + this.iOP);
            this.iOQ.offer(cVar);
        }

        void cfE() {
            if (!this.iOQ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.iOQ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cfF() <= now) {
                        if (this.iOQ.remove(next)) {
                            this.iOR.b(next);
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
                if (this.iOT != null) {
                    this.iOT.cancel(true);
                }
                if (this.iOS != null) {
                    this.iOS.shutdownNow();
                }
            } finally {
                this.iOR.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aib = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0422a c0422a = new C0422a(this.aib, iOK, iOL);
        if (!this.iOO.compareAndSet(iON, c0422a)) {
            c0422a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0422a c0422a;
        do {
            c0422a = this.iOO.get();
            if (c0422a == iON) {
                return;
            }
        } while (!this.iOO.compareAndSet(c0422a, iON));
        c0422a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.iOO.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0422a iOX;
        private final c iOY;
        private final rx.subscriptions.b iOW = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0422a c0422a) {
            this.iOX = c0422a;
            this.iOY = c0422a.cfD();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.iOY.a(this);
            }
            this.iOW.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.iOX.a(this.iOY);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iOW.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.iOW.isUnsubscribed()) {
                return rx.subscriptions.e.cgS();
            }
            ScheduledAction b = this.iOY.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.iOW.add(b);
            b.addParent(this.iOW);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long iPa;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.iPa = 0L;
        }

        public long cfF() {
            return this.iPa;
        }

        public void dR(long j) {
            this.iPa = j;
        }
    }
}
