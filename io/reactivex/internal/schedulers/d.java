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
/* loaded from: classes7.dex */
public final class d extends v {
    static final RxThreadFactory nMU;
    static final RxThreadFactory nMV;
    private static final TimeUnit nMW = TimeUnit.SECONDS;
    static final c nMX = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nMY;
    final ThreadFactory bAJ;
    final AtomicReference<a> nMC;

    static {
        nMX.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nMU = new RxThreadFactory("RxCachedThreadScheduler", max);
        nMV = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nMY = new a(0L, null, nMU);
        nMY.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory bAJ;
        private final long nMZ;
        private final ConcurrentLinkedQueue<c> nNa;
        final io.reactivex.disposables.a nNb;
        private final ScheduledExecutorService nNc;
        private final Future<?> nNd;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nMZ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nNa = new ConcurrentLinkedQueue<>();
            this.nNb = new io.reactivex.disposables.a();
            this.bAJ = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nMV);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nMZ, this.nMZ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nNc = scheduledExecutorService;
            this.nNd = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dPQ();
        }

        c dPP() {
            if (this.nNb.isDisposed()) {
                return d.nMX;
            }
            while (!this.nNa.isEmpty()) {
                c poll = this.nNa.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bAJ);
            this.nNb.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gl(now() + this.nMZ);
            this.nNa.offer(cVar);
        }

        void dPQ() {
            if (!this.nNa.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nNa.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dPR() <= now) {
                        if (this.nNa.remove(next)) {
                            this.nNb.b(next);
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
            this.nNb.dispose();
            if (this.nNd != null) {
                this.nNd.cancel(true);
            }
            if (this.nNc != null) {
                this.nNc.shutdownNow();
            }
        }
    }

    public d() {
        this(nMU);
    }

    public d(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
        this.nMC = new AtomicReference<>(nMY);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nMW, this.bAJ);
        if (!this.nMC.compareAndSet(nMY, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dPv() {
        return new b(this.nMC.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nNe;
        private final c nNf;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nMN = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nNe = aVar;
            this.nNf = aVar.dPP();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nMN.dispose();
                this.nNe.a(this.nNf);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nMN.isDisposed() ? EmptyDisposable.INSTANCE : this.nNf.a(runnable, j, timeUnit, this.nMN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nNg;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nNg = 0L;
        }

        public long dPR() {
            return this.nNg;
        }

        public void gl(long j) {
            this.nNg = j;
        }
    }
}
