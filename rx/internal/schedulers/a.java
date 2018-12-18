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
    private static final long iKt;
    private static final TimeUnit iKu = TimeUnit.SECONDS;
    static final c iKv = new c(RxThreadFactory.NONE);
    static final C0423a iKw;
    final ThreadFactory ahS;
    final AtomicReference<C0423a> iKx = new AtomicReference<>(iKw);

    static {
        iKv.unsubscribe();
        iKw = new C0423a(null, 0L, null);
        iKw.shutdown();
        iKt = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0423a {
        private final ThreadFactory ahS;
        private final rx.subscriptions.b iKA;
        private final ScheduledExecutorService iKB;
        private final Future<?> iKC;
        private final long iKy;
        private final ConcurrentLinkedQueue<c> iKz;

        C0423a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.ahS = threadFactory;
            this.iKy = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.iKz = new ConcurrentLinkedQueue<>();
            this.iKA = new rx.subscriptions.b();
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
                        C0423a.this.cef();
                    }
                }, this.iKy, this.iKy, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.iKB = scheduledExecutorService;
            this.iKC = scheduledFuture;
        }

        c cee() {
            if (this.iKA.isUnsubscribed()) {
                return a.iKv;
            }
            while (!this.iKz.isEmpty()) {
                c poll = this.iKz.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.ahS);
            this.iKA.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.dM(now() + this.iKy);
            this.iKz.offer(cVar);
        }

        void cef() {
            if (!this.iKz.isEmpty()) {
                long now = now();
                Iterator<c> it = this.iKz.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.ceg() <= now) {
                        if (this.iKz.remove(next)) {
                            this.iKA.b(next);
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
                if (this.iKC != null) {
                    this.iKC.cancel(true);
                }
                if (this.iKB != null) {
                    this.iKB.shutdownNow();
                }
            } finally {
                this.iKA.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.ahS = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0423a c0423a = new C0423a(this.ahS, iKt, iKu);
        if (!this.iKx.compareAndSet(iKw, c0423a)) {
            c0423a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0423a c0423a;
        do {
            c0423a = this.iKx.get();
            if (c0423a == iKw) {
                return;
            }
        } while (!this.iKx.compareAndSet(c0423a, iKw));
        c0423a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.iKx.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0423a iKG;
        private final c iKH;
        private final rx.subscriptions.b iKF = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0423a c0423a) {
            this.iKG = c0423a;
            this.iKH = c0423a.cee();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.iKH.a(this);
            }
            this.iKF.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.iKG.a(this.iKH);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iKF.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.iKF.isUnsubscribed()) {
                return rx.subscriptions.e.cft();
            }
            ScheduledAction b = this.iKH.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.iKF.add(b);
            b.addParent(this.iKF);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long iKJ;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.iKJ = 0L;
        }

        public long ceg() {
            return this.iKJ;
        }

        public void dM(long j) {
            this.iKJ = j;
        }
    }
}
