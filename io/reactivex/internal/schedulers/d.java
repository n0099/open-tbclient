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
/* loaded from: classes25.dex */
public final class d extends v {
    static final RxThreadFactory ozC;
    static final RxThreadFactory ozD;
    private static final TimeUnit ozE = TimeUnit.SECONDS;
    static final c ozF = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a ozG;
    final ThreadFactory ozj;
    final AtomicReference<a> ozk;

    static {
        ozF.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        ozC = new RxThreadFactory("RxCachedThreadScheduler", max);
        ozD = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        ozG = new a(0L, null, ozC);
        ozG.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class a implements Runnable {
        private final long ozH;
        private final ConcurrentLinkedQueue<c> ozI;
        final io.reactivex.disposables.a ozJ;
        private final ScheduledExecutorService ozK;
        private final Future<?> ozL;
        private final ThreadFactory ozj;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.ozH = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.ozI = new ConcurrentLinkedQueue<>();
            this.ozJ = new io.reactivex.disposables.a();
            this.ozj = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.ozD);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.ozH, this.ozH, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.ozK = scheduledExecutorService;
            this.ozL = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            ejv();
        }

        c eju() {
            if (this.ozJ.isDisposed()) {
                return d.ozF;
            }
            while (!this.ozI.isEmpty()) {
                c poll = this.ozI.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.ozj);
            this.ozJ.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hb(now() + this.ozH);
            this.ozI.offer(cVar);
        }

        void ejv() {
            if (!this.ozI.isEmpty()) {
                long now = now();
                Iterator<c> it = this.ozI.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.ejw() <= now) {
                        if (this.ozI.remove(next)) {
                            this.ozJ.b(next);
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
            this.ozJ.dispose();
            if (this.ozL != null) {
                this.ozL.cancel(true);
            }
            if (this.ozK != null) {
                this.ozK.shutdownNow();
            }
        }
    }

    public d() {
        this(ozC);
    }

    public d(ThreadFactory threadFactory) {
        this.ozj = threadFactory;
        this.ozk = new AtomicReference<>(ozG);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, ozE, this.ozj);
        if (!this.ozk.compareAndSet(ozG, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eja() {
        return new b(this.ozk.get());
    }

    /* loaded from: classes25.dex */
    static final class b extends v.c {
        private final a ozM;
        private final c ozN;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a ozv = new io.reactivex.disposables.a();

        b(a aVar) {
            this.ozM = aVar;
            this.ozN = aVar.eju();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.ozv.dispose();
                this.ozM.a(this.ozN);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.ozv.isDisposed() ? EmptyDisposable.INSTANCE : this.ozN.a(runnable, j, timeUnit, this.ozv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class c extends f {
        private long ozO;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.ozO = 0L;
        }

        public long ejw() {
            return this.ozO;
        }

        public void hb(long j) {
            this.ozO = j;
        }
    }
}
