package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
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
/* loaded from: classes5.dex */
public final class d extends v {
    static final RxThreadFactory pRl;
    static final RxThreadFactory pRm;
    private static final TimeUnit pRn = TimeUnit.SECONDS;
    static final c pRo = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a pRp;
    final ThreadFactory pQS;
    final AtomicReference<a> pQT;

    static {
        pRo.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        pRl = new RxThreadFactory("RxCachedThreadScheduler", max);
        pRm = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        pRp = new a(0L, null, pRl);
        pRp.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final ThreadFactory pQS;
        private final long pRq;
        private final ConcurrentLinkedQueue<c> pRr;
        final io.reactivex.disposables.a pRs;
        private final ScheduledExecutorService pRt;
        private final Future<?> pRu;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pRq = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pRr = new ConcurrentLinkedQueue<>();
            this.pRs = new io.reactivex.disposables.a();
            this.pQS = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.pRm);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.pRq, this.pRq, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pRt = scheduledExecutorService;
            this.pRu = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eAW();
        }

        c eAV() {
            if (this.pRs.isDisposed()) {
                return d.pRo;
            }
            while (!this.pRr.isEmpty()) {
                c poll = this.pRr.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pQS);
            this.pRs.a(cVar);
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
                            this.pRs.b(next);
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
            this.pRs.dispose();
            if (this.pRu != null) {
                this.pRu.cancel(true);
            }
            if (this.pRt != null) {
                this.pRt.shutdownNow();
            }
        }
    }

    public d() {
        this(pRl);
    }

    public d(ThreadFactory threadFactory) {
        this.pQS = threadFactory;
        this.pQT = new AtomicReference<>(pRp);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, pRn, this.pQS);
        if (!this.pQT.compareAndSet(pRp, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eAB() {
        return new b(this.pQT.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a pRe = new io.reactivex.disposables.a();
        private final a pRv;
        private final c pRw;

        b(a aVar) {
            this.pRv = aVar;
            this.pRw = aVar.eAV();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.pRe.dispose();
                this.pRv.a(this.pRw);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.pRe.isDisposed() ? EmptyDisposable.INSTANCE : this.pRw.a(runnable, j, timeUnit, this.pRe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
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
