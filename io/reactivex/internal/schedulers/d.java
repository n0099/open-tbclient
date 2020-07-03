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
    static final RxThreadFactory nMR;
    static final RxThreadFactory nMS;
    private static final TimeUnit nMT = TimeUnit.SECONDS;
    static final c nMU = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nMV;
    final ThreadFactory bAJ;
    final AtomicReference<a> nMz;

    static {
        nMU.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nMR = new RxThreadFactory("RxCachedThreadScheduler", max);
        nMS = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nMV = new a(0L, null, nMR);
        nMV.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory bAJ;
        private final long nMW;
        private final ConcurrentLinkedQueue<c> nMX;
        final io.reactivex.disposables.a nMY;
        private final ScheduledExecutorService nMZ;
        private final Future<?> nNa;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nMW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nMX = new ConcurrentLinkedQueue<>();
            this.nMY = new io.reactivex.disposables.a();
            this.bAJ = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nMS);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nMW, this.nMW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nMZ = scheduledExecutorService;
            this.nNa = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dPM();
        }

        c dPL() {
            if (this.nMY.isDisposed()) {
                return d.nMU;
            }
            while (!this.nMX.isEmpty()) {
                c poll = this.nMX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bAJ);
            this.nMY.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gl(now() + this.nMW);
            this.nMX.offer(cVar);
        }

        void dPM() {
            if (!this.nMX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nMX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dPN() <= now) {
                        if (this.nMX.remove(next)) {
                            this.nMY.b(next);
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
            this.nMY.dispose();
            if (this.nNa != null) {
                this.nNa.cancel(true);
            }
            if (this.nMZ != null) {
                this.nMZ.shutdownNow();
            }
        }
    }

    public d() {
        this(nMR);
    }

    public d(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
        this.nMz = new AtomicReference<>(nMV);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nMT, this.bAJ);
        if (!this.nMz.compareAndSet(nMV, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dPr() {
        return new b(this.nMz.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nNb;
        private final c nNc;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nMK = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nNb = aVar;
            this.nNc = aVar.dPL();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nMK.dispose();
                this.nNb.a(this.nNc);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nMK.isDisposed() ? EmptyDisposable.INSTANCE : this.nNc.a(runnable, j, timeUnit, this.nMK);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nNd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nNd = 0L;
        }

        public long dPN() {
            return this.nNd;
        }

        public void gl(long j) {
            this.nNd = j;
        }
    }
}
