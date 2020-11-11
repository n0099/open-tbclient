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
/* loaded from: classes17.dex */
public final class d extends v {
    static final RxThreadFactory pPI;
    static final RxThreadFactory pPJ;
    private static final TimeUnit pPK = TimeUnit.SECONDS;
    static final c pPL = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a pPM;
    final ThreadFactory pPp;
    final AtomicReference<a> pPq;

    static {
        pPL.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        pPI = new RxThreadFactory("RxCachedThreadScheduler", max);
        pPJ = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        pPM = new a(0L, null, pPI);
        pPM.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class a implements Runnable {
        private final long pPN;
        private final ConcurrentLinkedQueue<c> pPO;
        final io.reactivex.disposables.a pPP;
        private final ScheduledExecutorService pPQ;
        private final Future<?> pPR;
        private final ThreadFactory pPp;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pPN = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pPO = new ConcurrentLinkedQueue<>();
            this.pPP = new io.reactivex.disposables.a();
            this.pPp = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.pPJ);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.pPN, this.pPN, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pPQ = scheduledExecutorService;
            this.pPR = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eAV();
        }

        c eAU() {
            if (this.pPP.isDisposed()) {
                return d.pPL;
            }
            while (!this.pPO.isEmpty()) {
                c poll = this.pPO.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pPp);
            this.pPP.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.m591if(now() + this.pPN);
            this.pPO.offer(cVar);
        }

        void eAV() {
            if (!this.pPO.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pPO.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eAW() <= now) {
                        if (this.pPO.remove(next)) {
                            this.pPP.b(next);
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
            this.pPP.dispose();
            if (this.pPR != null) {
                this.pPR.cancel(true);
            }
            if (this.pPQ != null) {
                this.pPQ.shutdownNow();
            }
        }
    }

    public d() {
        this(pPI);
    }

    public d(ThreadFactory threadFactory) {
        this.pPp = threadFactory;
        this.pPq = new AtomicReference<>(pPM);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, pPK, this.pPp);
        if (!this.pPq.compareAndSet(pPM, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eAA() {
        return new b(this.pPq.get());
    }

    /* loaded from: classes17.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a pPB = new io.reactivex.disposables.a();
        private final a pPS;
        private final c pPT;

        b(a aVar) {
            this.pPS = aVar;
            this.pPT = aVar.eAU();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.pPB.dispose();
                this.pPS.a(this.pPT);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.pPB.isDisposed() ? EmptyDisposable.INSTANCE : this.pPT.a(runnable, j, timeUnit, this.pPB);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class c extends f {
        private long pPU;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pPU = 0L;
        }

        public long eAW() {
            return this.pPU;
        }

        /* renamed from: if  reason: not valid java name */
        public void m591if(long j) {
            this.pPU = j;
        }
    }
}
