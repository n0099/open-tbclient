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
/* loaded from: classes4.dex */
public final class a extends rx.g implements h {
    private static final long qCS;
    static final C1309a qCU;
    final ThreadFactory qry;
    final AtomicReference<C1309a> qrz = new AtomicReference<>(qCU);
    private static final TimeUnit qrT = TimeUnit.SECONDS;
    static final c qCT = new c(RxThreadFactory.NONE);

    static {
        qCT.unsubscribe();
        qCU = new C1309a(null, 0L, null);
        qCU.shutdown();
        qCS = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1309a {
        private final rx.subscriptions.b qCV;
        private final long qrW;
        private final ConcurrentLinkedQueue<c> qrX;
        private final ScheduledExecutorService qrZ;
        private final ThreadFactory qry;
        private final Future<?> qsa;

        C1309a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qry = threadFactory;
            this.qrW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qrX = new ConcurrentLinkedQueue<>();
            this.qCV = new rx.subscriptions.b();
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
                        C1309a.this.eKq();
                    }
                }, this.qrW, this.qrW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qrZ = scheduledExecutorService;
            this.qsa = scheduledFuture;
        }

        c eMW() {
            if (this.qCV.isUnsubscribed()) {
                return a.qCT;
            }
            while (!this.qrX.isEmpty()) {
                c poll = this.qrX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qry);
            this.qCV.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jw(now() + this.qrW);
            this.qrX.offer(cVar);
        }

        void eKq() {
            if (!this.qrX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qrX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eKr() <= now) {
                        if (this.qrX.remove(next)) {
                            this.qCV.a(next);
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
                if (this.qsa != null) {
                    this.qsa.cancel(true);
                }
                if (this.qrZ != null) {
                    this.qrZ.shutdownNow();
                }
            } finally {
                this.qCV.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.qry = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1309a c1309a = new C1309a(this.qry, qCS, qrT);
        if (!this.qrz.compareAndSet(qCU, c1309a)) {
            c1309a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1309a c1309a;
        do {
            c1309a = this.qrz.get();
            if (c1309a == qCU) {
                return;
            }
        } while (!this.qrz.compareAndSet(c1309a, qCU));
        c1309a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.qrz.get());
    }

    /* loaded from: classes4.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1309a qCZ;
        private final c qDa;
        private final rx.subscriptions.b qCY = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1309a c1309a) {
            this.qCZ = c1309a;
            this.qDa = c1309a.eMW();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qDa.c(this);
            }
            this.qCY.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qCZ.a(this.qDa);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qCY.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qCY.isUnsubscribed()) {
                return rx.subscriptions.e.eOd();
            }
            ScheduledAction b = this.qDa.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qCY.add(b);
            b.addParent(this.qCY);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c extends g {
        private long qsd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qsd = 0L;
        }

        public long eKr() {
            return this.qsd;
        }

        public void jw(long j) {
            this.qsd = j;
        }
    }
}
