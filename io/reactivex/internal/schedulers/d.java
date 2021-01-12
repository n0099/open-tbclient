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
    static final RxThreadFactory qgK;
    static final RxThreadFactory qgL;
    private static final TimeUnit qgM = TimeUnit.SECONDS;
    static final c qgN = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a qgO;
    final ThreadFactory qgr;
    final AtomicReference<a> qgs;

    static {
        qgN.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        qgK = new RxThreadFactory("RxCachedThreadScheduler", max);
        qgL = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qgO = new a(0L, null, qgK);
        qgO.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final long qgP;
        private final ConcurrentLinkedQueue<c> qgQ;
        final io.reactivex.disposables.a qgR;
        private final ScheduledExecutorService qgS;
        private final Future<?> qgT;
        private final ThreadFactory qgr;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qgP = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qgQ = new ConcurrentLinkedQueue<>();
            this.qgR = new io.reactivex.disposables.a();
            this.qgr = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.qgL);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.qgP, this.qgP, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qgS = scheduledExecutorService;
            this.qgT = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eIk();
        }

        c eIj() {
            if (this.qgR.isDisposed()) {
                return d.qgN;
            }
            while (!this.qgQ.isEmpty()) {
                c poll = this.qgQ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qgr);
            this.qgR.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ju(now() + this.qgP);
            this.qgQ.offer(cVar);
        }

        void eIk() {
            if (!this.qgQ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qgQ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eIl() <= now) {
                        if (this.qgQ.remove(next)) {
                            this.qgR.b(next);
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
            this.qgR.dispose();
            if (this.qgT != null) {
                this.qgT.cancel(true);
            }
            if (this.qgS != null) {
                this.qgS.shutdownNow();
            }
        }
    }

    public d() {
        this(qgK);
    }

    public d(ThreadFactory threadFactory) {
        this.qgr = threadFactory;
        this.qgs = new AtomicReference<>(qgO);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, qgM, this.qgr);
        if (!this.qgs.compareAndSet(qgO, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eHS() {
        return new b(this.qgs.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a qgD = new io.reactivex.disposables.a();
        private final a qgU;
        private final c qgV;

        b(a aVar) {
            this.qgU = aVar;
            this.qgV = aVar.eIj();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.qgD.dispose();
                this.qgU.a(this.qgV);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.qgD.isDisposed() ? EmptyDisposable.INSTANCE : this.qgV.a(runnable, j, timeUnit, this.qgD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        private long qgW;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qgW = 0L;
        }

        public long eIl() {
            return this.qgW;
        }

        public void ju(long j) {
            this.qgW = j;
        }
    }
}
