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
/* loaded from: classes14.dex */
public final class a extends rx.g implements h {
    private static final long qjc;
    static final C1109a qje;
    final ThreadFactory pQS;
    final AtomicReference<C1109a> pQT = new AtomicReference<>(qje);
    private static final TimeUnit pRn = TimeUnit.SECONDS;
    static final c qjd = new c(RxThreadFactory.NONE);

    static {
        qjd.unsubscribe();
        qje = new C1109a(null, 0L, null);
        qje.shutdown();
        qjc = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1109a {
        private final ThreadFactory pQS;
        private final long pRq;
        private final ConcurrentLinkedQueue<c> pRr;
        private final ScheduledExecutorService pRt;
        private final Future<?> pRu;
        private final rx.subscriptions.b qjf;

        C1109a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pQS = threadFactory;
            this.pRq = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pRr = new ConcurrentLinkedQueue<>();
            this.qjf = new rx.subscriptions.b();
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
                        C1109a.this.eAW();
                    }
                }, this.pRq, this.pRq, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pRt = scheduledExecutorService;
            this.pRu = scheduledFuture;
        }

        c eFU() {
            if (this.qjf.isUnsubscribed()) {
                return a.qjd;
            }
            while (!this.pRr.isEmpty()) {
                c poll = this.pRr.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pQS);
            this.qjf.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ii(now() + this.pRq);
            this.pRr.offer(cVar);
        }

        void eAW() {
            if (!this.pRr.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pRr.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eAX() <= now) {
                        if (this.pRr.remove(next)) {
                            this.qjf.a(next);
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
                if (this.pRu != null) {
                    this.pRu.cancel(true);
                }
                if (this.pRt != null) {
                    this.pRt.shutdownNow();
                }
            } finally {
                this.qjf.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.pQS = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1109a c1109a = new C1109a(this.pQS, qjc, pRn);
        if (!this.pQT.compareAndSet(qje, c1109a)) {
            c1109a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1109a c1109a;
        do {
            c1109a = this.pQT.get();
            if (c1109a == qje) {
                return;
            }
        } while (!this.pQT.compareAndSet(c1109a, qje));
        c1109a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.pQT.get());
    }

    /* loaded from: classes14.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1109a qjj;
        private final c qjk;
        private final rx.subscriptions.b qji = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1109a c1109a) {
            this.qjj = c1109a;
            this.qjk = c1109a.eFU();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qjk.c(this);
            }
            this.qji.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qjj.a(this.qjk);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qji.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qji.isUnsubscribed()) {
                return rx.subscriptions.e.eGZ();
            }
            ScheduledAction b = this.qjk.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qji.add(b);
            b.addParent(this.qji);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class c extends g {
        private long pRx;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pRx = 0L;
        }

        public long eAX() {
            return this.pRx;
        }

        public void ii(long j) {
            this.pRx = j;
        }
    }
}
