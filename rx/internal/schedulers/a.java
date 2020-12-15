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
/* loaded from: classes12.dex */
public final class a extends rx.g implements h {
    private static final long pTf;
    static final C1073a pTh;
    final ThreadFactory pHI;
    final AtomicReference<C1073a> pHJ = new AtomicReference<>(pTh);
    private static final TimeUnit pId = TimeUnit.SECONDS;
    static final c pTg = new c(RxThreadFactory.NONE);

    static {
        pTg.unsubscribe();
        pTh = new C1073a(null, 0L, null);
        pTh.shutdown();
        pTf = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C1073a {
        private final ThreadFactory pHI;
        private final long pIg;
        private final ConcurrentLinkedQueue<c> pIh;
        private final ScheduledExecutorService pIj;
        private final Future<?> pIk;
        private final rx.subscriptions.b pTi;

        C1073a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pHI = threadFactory;
            this.pIg = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pIh = new ConcurrentLinkedQueue<>();
            this.pTi = new rx.subscriptions.b();
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
                        C1073a.this.eDo();
                    }
                }, this.pIg, this.pIg, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pIj = scheduledExecutorService;
            this.pIk = scheduledFuture;
        }

        c eFU() {
            if (this.pTi.isUnsubscribed()) {
                return a.pTg;
            }
            while (!this.pIh.isEmpty()) {
                c poll = this.pIh.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pHI);
            this.pTi.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.iH(now() + this.pIg);
            this.pIh.offer(cVar);
        }

        void eDo() {
            if (!this.pIh.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pIh.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eDp() <= now) {
                        if (this.pIh.remove(next)) {
                            this.pTi.a(next);
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
                if (this.pIk != null) {
                    this.pIk.cancel(true);
                }
                if (this.pIj != null) {
                    this.pIj.shutdownNow();
                }
            } finally {
                this.pTi.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.pHI = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1073a c1073a = new C1073a(this.pHI, pTf, pId);
        if (!this.pHJ.compareAndSet(pTh, c1073a)) {
            c1073a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1073a c1073a;
        do {
            c1073a = this.pHJ.get();
            if (c1073a == pTh) {
                return;
            }
        } while (!this.pHJ.compareAndSet(c1073a, pTh));
        c1073a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.pHJ.get());
    }

    /* loaded from: classes12.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1073a pTm;
        private final c pTn;
        private final rx.subscriptions.b pTl = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1073a c1073a) {
            this.pTm = c1073a;
            this.pTn = c1073a.eFU();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.pTn.c(this);
            }
            this.pTl.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.pTm.a(this.pTn);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pTl.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.pTl.isUnsubscribed()) {
                return rx.subscriptions.e.eHb();
            }
            ScheduledAction b = this.pTn.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.pTl.add(b);
            b.addParent(this.pTl);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class c extends g {
        private long pIn;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pIn = 0L;
        }

        public long eDp() {
            return this.pIn;
        }

        public void iH(long j) {
            this.pIn = j;
        }
    }
}
