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
    private static final long jYK;
    private static final TimeUnit jYL = TimeUnit.SECONDS;
    static final c jYM = new c(RxThreadFactory.NONE);
    static final C0489a jYN;
    final ThreadFactory agM;
    final AtomicReference<C0489a> jYO = new AtomicReference<>(jYN);

    static {
        jYM.unsubscribe();
        jYN = new C0489a(null, 0L, null);
        jYN.shutdown();
        jYK = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0489a {
        private final ThreadFactory agM;
        private final long jYP;
        private final ConcurrentLinkedQueue<c> jYQ;
        private final rx.subscriptions.b jYR;
        private final ScheduledExecutorService jYS;
        private final Future<?> jYT;

        C0489a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agM = threadFactory;
            this.jYP = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.jYQ = new ConcurrentLinkedQueue<>();
            this.jYR = new rx.subscriptions.b();
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
                }, this.jYP, this.jYP, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.jYS = scheduledExecutorService;
            this.jYT = scheduledFuture;
        }

        c cEi() {
            if (this.jYR.isUnsubscribed()) {
                return a.jYM;
            }
            while (!this.jYQ.isEmpty()) {
                c poll = this.jYQ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agM);
            this.jYR.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.en(now() + this.jYP);
            this.jYQ.offer(cVar);
        }

        void cEj() {
            if (!this.jYQ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.jYQ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cEk() <= now) {
                        if (this.jYQ.remove(next)) {
                            this.jYR.a(next);
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
                if (this.jYT != null) {
                    this.jYT.cancel(true);
                }
                if (this.jYS != null) {
                    this.jYS.shutdownNow();
                }
            } finally {
                this.jYR.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agM = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0489a c0489a = new C0489a(this.agM, jYK, jYL);
        if (!this.jYO.compareAndSet(jYN, c0489a)) {
            c0489a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0489a c0489a;
        do {
            c0489a = this.jYO.get();
            if (c0489a == jYN) {
                return;
            }
        } while (!this.jYO.compareAndSet(c0489a, jYN));
        c0489a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.jYO.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0489a jYX;
        private final c jYY;
        private final rx.subscriptions.b jYW = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0489a c0489a) {
            this.jYX = c0489a;
            this.jYY = c0489a.cEi();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.jYY.c(this);
            }
            this.jYW.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.jYX.a(this.jYY);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jYW.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.jYW.isUnsubscribed()) {
                return rx.subscriptions.e.cFv();
            }
            ScheduledAction b = this.jYY.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.jYW.add(b);
            b.addParent(this.jYW);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long jZb;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.jZb = 0L;
        }

        public long cEk() {
            return this.jZb;
        }

        public void en(long j) {
            this.jZb = j;
        }
    }
}
