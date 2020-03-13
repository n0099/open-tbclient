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
    private static final long nRv;
    static final C0798a nRx;
    final ThreadFactory aRX;
    final AtomicReference<C0798a> nzh = new AtomicReference<>(nRx);
    private static final TimeUnit nzB = TimeUnit.SECONDS;
    static final c nRw = new c(RxThreadFactory.NONE);

    static {
        nRw.unsubscribe();
        nRx = new C0798a(null, 0L, null);
        nRx.shutdown();
        nRv = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0798a {
        private final ThreadFactory aRX;
        private final rx.subscriptions.b nRy;
        private final long nzE;
        private final ConcurrentLinkedQueue<c> nzF;
        private final ScheduledExecutorService nzH;
        private final Future<?> nzI;

        C0798a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aRX = threadFactory;
            this.nzE = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nzF = new ConcurrentLinkedQueue<>();
            this.nRy = new rx.subscriptions.b();
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
                        C0798a.this.dJC();
                    }
                }, this.nzE, this.nzE, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nzH = scheduledExecutorService;
            this.nzI = scheduledFuture;
        }

        c dOy() {
            if (this.nRy.isUnsubscribed()) {
                return a.nRw;
            }
            while (!this.nzF.isEmpty()) {
                c poll = this.nzF.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aRX);
            this.nRy.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hd(now() + this.nzE);
            this.nzF.offer(cVar);
        }

        void dJC() {
            if (!this.nzF.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nzF.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dJD() <= now) {
                        if (this.nzF.remove(next)) {
                            this.nRy.a(next);
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
                if (this.nzI != null) {
                    this.nzI.cancel(true);
                }
                if (this.nzH != null) {
                    this.nzH.shutdownNow();
                }
            } finally {
                this.nRy.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aRX = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0798a c0798a = new C0798a(this.aRX, nRv, nzB);
        if (!this.nzh.compareAndSet(nRx, c0798a)) {
            c0798a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0798a c0798a;
        do {
            c0798a = this.nzh.get();
            if (c0798a == nRx) {
                return;
            }
        } while (!this.nzh.compareAndSet(c0798a, nRx));
        c0798a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nzh.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0798a nRC;
        private final c nRD;
        private final rx.subscriptions.b nRB = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0798a c0798a) {
            this.nRC = c0798a;
            this.nRD = c0798a.dOy();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nRD.c(this);
            }
            this.nRB.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nRC.a(this.nRD);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nRB.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nRB.isUnsubscribed()) {
                return rx.subscriptions.e.dPD();
            }
            ScheduledAction b = this.nRD.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nRB.add(b);
            b.addParent(this.nRB);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nzL;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nzL = 0L;
        }

        public long dJD() {
            return this.nzL;
        }

        public void hd(long j) {
            this.nzL = j;
        }
    }
}
