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
/* loaded from: classes4.dex */
public final class d extends v {
    static final a mWA;
    static final RxThreadFactory mWw;
    static final RxThreadFactory mWx;
    private static final TimeUnit mWy = TimeUnit.SECONDS;
    static final c mWz = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    final ThreadFactory aME;
    final AtomicReference<a> mWe;

    static {
        mWz.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        mWw = new RxThreadFactory("RxCachedThreadScheduler", max);
        mWx = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        mWA = new a(0L, null, mWw);
        mWA.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        private final ThreadFactory aME;
        private final long mWB;
        private final ConcurrentLinkedQueue<c> mWC;
        final io.reactivex.disposables.a mWD;
        private final ScheduledExecutorService mWE;
        private final Future<?> mWF;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.mWB = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.mWC = new ConcurrentLinkedQueue<>();
            this.mWD = new io.reactivex.disposables.a();
            this.aME = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.mWx);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.mWB, this.mWB, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.mWE = scheduledExecutorService;
            this.mWF = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dEg();
        }

        c dEf() {
            if (this.mWD.isDisposed()) {
                return d.mWz;
            }
            while (!this.mWC.isEmpty()) {
                c poll = this.mWC.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aME);
            this.mWD.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gT(now() + this.mWB);
            this.mWC.offer(cVar);
        }

        void dEg() {
            if (!this.mWC.isEmpty()) {
                long now = now();
                Iterator<c> it = this.mWC.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dEh() <= now) {
                        if (this.mWC.remove(next)) {
                            this.mWD.b(next);
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
            this.mWD.dispose();
            if (this.mWF != null) {
                this.mWF.cancel(true);
            }
            if (this.mWE != null) {
                this.mWE.shutdownNow();
            }
        }
    }

    public d() {
        this(mWw);
    }

    public d(ThreadFactory threadFactory) {
        this.aME = threadFactory;
        this.mWe = new AtomicReference<>(mWA);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, mWy, this.aME);
        if (!this.mWe.compareAndSet(mWA, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dDP() {
        return new b(this.mWe.get());
    }

    /* loaded from: classes4.dex */
    static final class b extends v.c {
        private final a mWG;
        private final c mWH;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a mWo = new io.reactivex.disposables.a();

        b(a aVar) {
            this.mWG = aVar;
            this.mWH = aVar.dEf();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.mWo.dispose();
                this.mWG.a(this.mWH);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.mWo.isDisposed() ? EmptyDisposable.INSTANCE : this.mWH.a(runnable, j, timeUnit, this.mWo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c extends f {
        private long mWI;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.mWI = 0L;
        }

        public long dEh() {
            return this.mWI;
        }

        public void gT(long j) {
            this.mWI = j;
        }
    }
}
