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
    private static final long jYJ;
    private static final TimeUnit jYK = TimeUnit.SECONDS;
    static final c jYL = new c(RxThreadFactory.NONE);
    static final C0489a jYM;
    final ThreadFactory agL;
    final AtomicReference<C0489a> jYN = new AtomicReference<>(jYM);

    static {
        jYL.unsubscribe();
        jYM = new C0489a(null, 0L, null);
        jYM.shutdown();
        jYJ = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0489a {
        private final ThreadFactory agL;
        private final long jYO;
        private final ConcurrentLinkedQueue<c> jYP;
        private final rx.subscriptions.b jYQ;
        private final ScheduledExecutorService jYR;
        private final Future<?> jYS;

        C0489a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agL = threadFactory;
            this.jYO = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.jYP = new ConcurrentLinkedQueue<>();
            this.jYQ = new rx.subscriptions.b();
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
                        C0489a.this.cEj();
                    }
                }, this.jYO, this.jYO, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.jYR = scheduledExecutorService;
            this.jYS = scheduledFuture;
        }

        c cEi() {
            if (this.jYQ.isUnsubscribed()) {
                return a.jYL;
            }
            while (!this.jYP.isEmpty()) {
                c poll = this.jYP.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agL);
            this.jYQ.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.en(now() + this.jYO);
            this.jYP.offer(cVar);
        }

        void cEj() {
            if (!this.jYP.isEmpty()) {
                long now = now();
                Iterator<c> it = this.jYP.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cEk() <= now) {
                        if (this.jYP.remove(next)) {
                            this.jYQ.a(next);
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
                if (this.jYS != null) {
                    this.jYS.cancel(true);
                }
                if (this.jYR != null) {
                    this.jYR.shutdownNow();
                }
            } finally {
                this.jYQ.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agL = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0489a c0489a = new C0489a(this.agL, jYJ, jYK);
        if (!this.jYN.compareAndSet(jYM, c0489a)) {
            c0489a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0489a c0489a;
        do {
            c0489a = this.jYN.get();
            if (c0489a == jYM) {
                return;
            }
        } while (!this.jYN.compareAndSet(c0489a, jYM));
        c0489a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.jYN.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0489a jYW;
        private final c jYX;
        private final rx.subscriptions.b jYV = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0489a c0489a) {
            this.jYW = c0489a;
            this.jYX = c0489a.cEi();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.jYX.c(this);
            }
            this.jYV.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.jYW.a(this.jYX);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jYV.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.jYV.isUnsubscribed()) {
                return rx.subscriptions.e.cFv();
            }
            ScheduledAction b = this.jYX.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.jYV.add(b);
            b.addParent(this.jYV);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long jZa;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.jZa = 0L;
        }

        public long cEk() {
            return this.jZa;
        }

        public void en(long j) {
            this.jZa = j;
        }
    }
}
