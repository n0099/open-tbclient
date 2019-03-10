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
    private static final TimeUnit jZA = TimeUnit.SECONDS;
    static final c jZB = new c(RxThreadFactory.NONE);
    static final C0394a jZC;
    private static final long jZz;
    final ThreadFactory agF;
    final AtomicReference<C0394a> jZD = new AtomicReference<>(jZC);

    static {
        jZB.unsubscribe();
        jZC = new C0394a(null, 0L, null);
        jZC.shutdown();
        jZz = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0394a {
        private final ThreadFactory agF;
        private final long jZE;
        private final ConcurrentLinkedQueue<c> jZF;
        private final rx.subscriptions.b jZG;
        private final ScheduledExecutorService jZH;
        private final Future<?> jZI;

        C0394a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agF = threadFactory;
            this.jZE = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.jZF = new ConcurrentLinkedQueue<>();
            this.jZG = new rx.subscriptions.b();
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
                        C0394a.this.cEr();
                    }
                }, this.jZE, this.jZE, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.jZH = scheduledExecutorService;
            this.jZI = scheduledFuture;
        }

        c cEq() {
            if (this.jZG.isUnsubscribed()) {
                return a.jZB;
            }
            while (!this.jZF.isEmpty()) {
                c poll = this.jZF.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agF);
            this.jZG.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eo(now() + this.jZE);
            this.jZF.offer(cVar);
        }

        void cEr() {
            if (!this.jZF.isEmpty()) {
                long now = now();
                Iterator<c> it = this.jZF.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cEs() <= now) {
                        if (this.jZF.remove(next)) {
                            this.jZG.a(next);
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
                if (this.jZI != null) {
                    this.jZI.cancel(true);
                }
                if (this.jZH != null) {
                    this.jZH.shutdownNow();
                }
            } finally {
                this.jZG.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agF = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0394a c0394a = new C0394a(this.agF, jZz, jZA);
        if (!this.jZD.compareAndSet(jZC, c0394a)) {
            c0394a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0394a c0394a;
        do {
            c0394a = this.jZD.get();
            if (c0394a == jZC) {
                return;
            }
        } while (!this.jZD.compareAndSet(c0394a, jZC));
        c0394a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.jZD.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0394a jZM;
        private final c jZN;
        private final rx.subscriptions.b jZL = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0394a c0394a) {
            this.jZM = c0394a;
            this.jZN = c0394a.cEq();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.jZN.c(this);
            }
            this.jZL.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.jZM.a(this.jZN);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZL.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.jZL.isUnsubscribed()) {
                return rx.subscriptions.e.cFD();
            }
            ScheduledAction b = this.jZN.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.jZL.add(b);
            b.addParent(this.jZL);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long jZQ;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.jZQ = 0L;
        }

        public long cEs() {
            return this.jZQ;
        }

        public void eo(long j) {
            this.jZQ = j;
        }
    }
}
