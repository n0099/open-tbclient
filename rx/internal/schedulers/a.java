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
    private static final long pTd;
    static final C1073a pTf;
    final ThreadFactory pHG;
    final AtomicReference<C1073a> pHH = new AtomicReference<>(pTf);
    private static final TimeUnit pIb = TimeUnit.SECONDS;
    static final c pTe = new c(RxThreadFactory.NONE);

    static {
        pTe.unsubscribe();
        pTf = new C1073a(null, 0L, null);
        pTf.shutdown();
        pTd = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C1073a {
        private final ThreadFactory pHG;
        private final long pIe;
        private final ConcurrentLinkedQueue<c> pIf;
        private final ScheduledExecutorService pIh;
        private final Future<?> pIi;
        private final rx.subscriptions.b pTg;

        C1073a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pHG = threadFactory;
            this.pIe = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pIf = new ConcurrentLinkedQueue<>();
            this.pTg = new rx.subscriptions.b();
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
                        C1073a.this.eDn();
                    }
                }, this.pIe, this.pIe, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pIh = scheduledExecutorService;
            this.pIi = scheduledFuture;
        }

        c eFT() {
            if (this.pTg.isUnsubscribed()) {
                return a.pTe;
            }
            while (!this.pIf.isEmpty()) {
                c poll = this.pIf.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pHG);
            this.pTg.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.iH(now() + this.pIe);
            this.pIf.offer(cVar);
        }

        void eDn() {
            if (!this.pIf.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pIf.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eDo() <= now) {
                        if (this.pIf.remove(next)) {
                            this.pTg.a(next);
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
                if (this.pIi != null) {
                    this.pIi.cancel(true);
                }
                if (this.pIh != null) {
                    this.pIh.shutdownNow();
                }
            } finally {
                this.pTg.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.pHG = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1073a c1073a = new C1073a(this.pHG, pTd, pIb);
        if (!this.pHH.compareAndSet(pTf, c1073a)) {
            c1073a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1073a c1073a;
        do {
            c1073a = this.pHH.get();
            if (c1073a == pTf) {
                return;
            }
        } while (!this.pHH.compareAndSet(c1073a, pTf));
        c1073a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.pHH.get());
    }

    /* loaded from: classes12.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1073a pTk;
        private final c pTl;
        private final rx.subscriptions.b pTj = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1073a c1073a) {
            this.pTk = c1073a;
            this.pTl = c1073a.eFT();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.pTl.c(this);
            }
            this.pTj.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.pTk.a(this.pTl);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pTj.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.pTj.isUnsubscribed()) {
                return rx.subscriptions.e.eHa();
            }
            ScheduledAction b = this.pTl.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.pTj.add(b);
            b.addParent(this.pTj);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class c extends g {
        private long pIl;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pIl = 0L;
        }

        public long eDo() {
            return this.pIl;
        }

        public void iH(long j) {
            this.pIl = j;
        }
    }
}
