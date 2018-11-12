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
    private static final long iDl;
    private static final TimeUnit iDm = TimeUnit.SECONDS;
    static final c iDn = new c(RxThreadFactory.NONE);
    static final C0409a iDo;
    final ThreadFactory iDp;
    final AtomicReference<C0409a> iDq = new AtomicReference<>(iDo);

    static {
        iDn.unsubscribe();
        iDo = new C0409a(null, 0L, null);
        iDo.shutdown();
        iDl = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0409a {
        private final ThreadFactory iDp;
        private final long iDr;
        private final ConcurrentLinkedQueue<c> iDs;
        private final rx.subscriptions.b iDt;
        private final ScheduledExecutorService iDu;
        private final Future<?> iDv;

        C0409a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.iDp = threadFactory;
            this.iDr = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.iDs = new ConcurrentLinkedQueue<>();
            this.iDt = new rx.subscriptions.b();
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
                        C0409a.this.ccd();
                    }
                }, this.iDr, this.iDr, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.iDu = scheduledExecutorService;
            this.iDv = scheduledFuture;
        }

        c ccc() {
            if (this.iDt.isUnsubscribed()) {
                return a.iDn;
            }
            while (!this.iDs.isEmpty()) {
                c poll = this.iDs.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.iDp);
            this.iDt.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.dF(now() + this.iDr);
            this.iDs.offer(cVar);
        }

        void ccd() {
            if (!this.iDs.isEmpty()) {
                long now = now();
                Iterator<c> it = this.iDs.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cce() <= now) {
                        if (this.iDs.remove(next)) {
                            this.iDt.b(next);
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
                if (this.iDv != null) {
                    this.iDv.cancel(true);
                }
                if (this.iDu != null) {
                    this.iDu.shutdownNow();
                }
            } finally {
                this.iDt.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.iDp = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0409a c0409a = new C0409a(this.iDp, iDl, iDm);
        if (!this.iDq.compareAndSet(iDo, c0409a)) {
            c0409a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0409a c0409a;
        do {
            c0409a = this.iDq.get();
            if (c0409a == iDo) {
                return;
            }
        } while (!this.iDq.compareAndSet(c0409a, iDo));
        c0409a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.iDq.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final c iDA;
        private final C0409a iDz;
        private final rx.subscriptions.b iDy = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0409a c0409a) {
            this.iDz = c0409a;
            this.iDA = c0409a.ccc();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.iDA.a(this);
            }
            this.iDy.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.iDz.a(this.iDA);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iDy.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.iDy.isUnsubscribed()) {
                return rx.subscriptions.e.cdr();
            }
            ScheduledAction b = this.iDA.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.iDy.add(b);
            b.addParent(this.iDy);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long iDC;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.iDC = 0L;
        }

        public long cce() {
            return this.iDC;
        }

        public void dF(long j) {
            this.iDC = j;
        }
    }
}
