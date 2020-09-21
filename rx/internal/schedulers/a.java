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
/* loaded from: classes7.dex */
public final class a extends rx.g implements h {
    private static final long oRv;
    static final C0996a oRx;
    final ThreadFactory ozj;
    final AtomicReference<C0996a> ozk = new AtomicReference<>(oRx);
    private static final TimeUnit ozE = TimeUnit.SECONDS;
    static final c oRw = new c(RxThreadFactory.NONE);

    static {
        oRw.unsubscribe();
        oRx = new C0996a(null, 0L, null);
        oRx.shutdown();
        oRv = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0996a {
        private final rx.subscriptions.b oRy;
        private final long ozH;
        private final ConcurrentLinkedQueue<c> ozI;
        private final ScheduledExecutorService ozK;
        private final Future<?> ozL;
        private final ThreadFactory ozj;

        C0996a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.ozj = threadFactory;
            this.ozH = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.ozI = new ConcurrentLinkedQueue<>();
            this.oRy = new rx.subscriptions.b();
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
                        C0996a.this.ejv();
                    }
                }, this.ozH, this.ozH, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.ozK = scheduledExecutorService;
            this.ozL = scheduledFuture;
        }

        c eov() {
            if (this.oRy.isUnsubscribed()) {
                return a.oRw;
            }
            while (!this.ozI.isEmpty()) {
                c poll = this.ozI.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.ozj);
            this.oRy.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hb(now() + this.ozH);
            this.ozI.offer(cVar);
        }

        void ejv() {
            if (!this.ozI.isEmpty()) {
                long now = now();
                Iterator<c> it = this.ozI.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.ejw() <= now) {
                        if (this.ozI.remove(next)) {
                            this.oRy.a(next);
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
                if (this.ozL != null) {
                    this.ozL.cancel(true);
                }
                if (this.ozK != null) {
                    this.ozK.shutdownNow();
                }
            } finally {
                this.oRy.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.ozj = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0996a c0996a = new C0996a(this.ozj, oRv, ozE);
        if (!this.ozk.compareAndSet(oRx, c0996a)) {
            c0996a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0996a c0996a;
        do {
            c0996a = this.ozk.get();
            if (c0996a == oRx) {
                return;
            }
        } while (!this.ozk.compareAndSet(c0996a, oRx));
        c0996a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.ozk.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0996a oRC;
        private final c oRD;
        private final rx.subscriptions.b oRB = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0996a c0996a) {
            this.oRC = c0996a;
            this.oRD = c0996a.eov();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.oRD.c(this);
            }
            this.oRB.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.oRC.a(this.oRD);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oRB.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.oRB.isUnsubscribed()) {
                return rx.subscriptions.e.epA();
            }
            ScheduledAction b = this.oRD.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.oRB.add(b);
            b.addParent(this.oRB);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends g {
        private long ozO;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.ozO = 0L;
        }

        public long ejw() {
            return this.ozO;
        }

        public void hb(long j) {
            this.ozO = j;
        }
    }
}
