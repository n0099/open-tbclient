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
    private static final long iOL;
    private static final TimeUnit iOM = TimeUnit.SECONDS;
    static final c iON = new c(RxThreadFactory.NONE);
    static final C0422a iOO;
    final ThreadFactory aib;
    final AtomicReference<C0422a> iOP = new AtomicReference<>(iOO);

    static {
        iON.unsubscribe();
        iOO = new C0422a(null, 0L, null);
        iOO.shutdown();
        iOL = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0422a {
        private final ThreadFactory aib;
        private final long iOQ;
        private final ConcurrentLinkedQueue<c> iOR;
        private final rx.subscriptions.b iOS;
        private final ScheduledExecutorService iOT;
        private final Future<?> iOU;

        C0422a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aib = threadFactory;
            this.iOQ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.iOR = new ConcurrentLinkedQueue<>();
            this.iOS = new rx.subscriptions.b();
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
                }, this.iOQ, this.iOQ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.iOT = scheduledExecutorService;
            this.iOU = scheduledFuture;
        }

        c cfD() {
            if (this.iOS.isUnsubscribed()) {
                return a.iON;
            }
            while (!this.iOR.isEmpty()) {
                c poll = this.iOR.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aib);
            this.iOS.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.dR(now() + this.iOQ);
            this.iOR.offer(cVar);
        }

        void cfE() {
            if (!this.iOR.isEmpty()) {
                long now = now();
                Iterator<c> it = this.iOR.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cfF() <= now) {
                        if (this.iOR.remove(next)) {
                            this.iOS.b(next);
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
                if (this.iOU != null) {
                    this.iOU.cancel(true);
                }
                if (this.iOT != null) {
                    this.iOT.shutdownNow();
                }
            } finally {
                this.iOS.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aib = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0422a c0422a = new C0422a(this.aib, iOL, iOM);
        if (!this.iOP.compareAndSet(iOO, c0422a)) {
            c0422a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0422a c0422a;
        do {
            c0422a = this.iOP.get();
            if (c0422a == iOO) {
                return;
            }
        } while (!this.iOP.compareAndSet(c0422a, iOO));
        c0422a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.iOP.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0422a iOY;
        private final c iOZ;
        private final rx.subscriptions.b iOX = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0422a c0422a) {
            this.iOY = c0422a;
            this.iOZ = c0422a.cfD();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.iOZ.a(this);
            }
            this.iOX.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.iOY.a(this.iOZ);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iOX.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.iOX.isUnsubscribed()) {
                return rx.subscriptions.e.cgS();
            }
            ScheduledAction b = this.iOZ.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.iOX.add(b);
            b.addParent(this.iOX);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long iPb;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.iPb = 0L;
        }

        public long cfF() {
            return this.iPb;
        }

        public void dR(long j) {
            this.iPb = j;
        }
    }
}
