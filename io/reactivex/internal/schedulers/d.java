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
    static final RxThreadFactory nzA;
    private static final TimeUnit nzB = TimeUnit.SECONDS;
    static final c nzC = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nzD;
    static final RxThreadFactory nzz;
    final ThreadFactory aRX;
    final AtomicReference<a> nzh;

    static {
        nzC.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nzz = new RxThreadFactory("RxCachedThreadScheduler", max);
        nzA = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nzD = new a(0L, null, nzz);
        nzD.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory aRX;
        private final long nzE;
        private final ConcurrentLinkedQueue<c> nzF;
        final io.reactivex.disposables.a nzG;
        private final ScheduledExecutorService nzH;
        private final Future<?> nzI;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nzE = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nzF = new ConcurrentLinkedQueue<>();
            this.nzG = new io.reactivex.disposables.a();
            this.aRX = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nzA);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nzE, this.nzE, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nzH = scheduledExecutorService;
            this.nzI = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dJC();
        }

        c dJB() {
            if (this.nzG.isDisposed()) {
                return d.nzC;
            }
            while (!this.nzF.isEmpty()) {
                c poll = this.nzF.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aRX);
            this.nzG.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hd(now() + this.nzE);
            this.nzF.offer(cVar);
        }

        void dJC() {
            if (!this.nzF.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nzF.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dJD() <= now) {
                        if (this.nzF.remove(next)) {
                            this.nzG.b(next);
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
            this.nzG.dispose();
            if (this.nzI != null) {
                this.nzI.cancel(true);
            }
            if (this.nzH != null) {
                this.nzH.shutdownNow();
            }
        }
    }

    public d() {
        this(nzz);
    }

    public d(ThreadFactory threadFactory) {
        this.aRX = threadFactory;
        this.nzh = new AtomicReference<>(nzD);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nzB, this.aRX);
        if (!this.nzh.compareAndSet(nzD, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dJi() {
        return new b(this.nzh.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nzJ;
        private final c nzK;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nzr = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nzJ = aVar;
            this.nzK = aVar.dJB();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nzr.dispose();
                this.nzJ.a(this.nzK);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nzr.isDisposed() ? EmptyDisposable.INSTANCE : this.nzK.a(runnable, j, timeUnit, this.nzr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nzL;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nzL = 0L;
        }

        public long dJD() {
            return this.nzL;
        }

        public void hd(long j) {
            this.nzL = j;
        }
    }
}
