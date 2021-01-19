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
    static final RxThreadFactory qgL;
    static final RxThreadFactory qgM;
    private static final TimeUnit qgN = TimeUnit.SECONDS;
    static final c qgO = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a qgP;
    final ThreadFactory qgs;
    final AtomicReference<a> qgt;

    static {
        qgO.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        qgL = new RxThreadFactory("RxCachedThreadScheduler", max);
        qgM = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qgP = new a(0L, null, qgL);
        qgP.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final long qgQ;
        private final ConcurrentLinkedQueue<c> qgR;
        final io.reactivex.disposables.a qgS;
        private final ScheduledExecutorService qgT;
        private final Future<?> qgU;
        private final ThreadFactory qgs;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qgQ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qgR = new ConcurrentLinkedQueue<>();
            this.qgS = new io.reactivex.disposables.a();
            this.qgs = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.qgM);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.qgQ, this.qgQ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qgT = scheduledExecutorService;
            this.qgU = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eIk();
        }

        c eIj() {
            if (this.qgS.isDisposed()) {
                return d.qgO;
            }
            while (!this.qgR.isEmpty()) {
                c poll = this.qgR.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qgs);
            this.qgS.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ju(now() + this.qgQ);
            this.qgR.offer(cVar);
        }

        void eIk() {
            if (!this.qgR.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qgR.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eIl() <= now) {
                        if (this.qgR.remove(next)) {
                            this.qgS.b(next);
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
            this.qgS.dispose();
            if (this.qgU != null) {
                this.qgU.cancel(true);
            }
            if (this.qgT != null) {
                this.qgT.shutdownNow();
            }
        }
    }

    public d() {
        this(qgL);
    }

    public d(ThreadFactory threadFactory) {
        this.qgs = threadFactory;
        this.qgt = new AtomicReference<>(qgP);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, qgN, this.qgs);
        if (!this.qgt.compareAndSet(qgP, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eHS() {
        return new b(this.qgt.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a qgE = new io.reactivex.disposables.a();
        private final a qgV;
        private final c qgW;

        b(a aVar) {
            this.qgV = aVar;
            this.qgW = aVar.eIj();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.qgE.dispose();
                this.qgV.a(this.qgW);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.qgE.isDisposed() ? EmptyDisposable.INSTANCE : this.qgW.a(runnable, j, timeUnit, this.qgE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        private long qgX;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qgX = 0L;
        }

        public long eIl() {
            return this.qgX;
        }

        public void ju(long j) {
            this.qgX = j;
        }
    }
}
