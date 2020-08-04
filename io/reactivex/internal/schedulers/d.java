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
    static final RxThreadFactory nVF;
    static final RxThreadFactory nVG;
    private static final TimeUnit nVH = TimeUnit.SECONDS;
    static final c nVI = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nVJ;
    final ThreadFactory nVm;
    final AtomicReference<a> nVn;

    static {
        nVI.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nVF = new RxThreadFactory("RxCachedThreadScheduler", max);
        nVG = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nVJ = new a(0L, null, nVF);
        nVJ.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final long nVK;
        private final ConcurrentLinkedQueue<c> nVL;
        final io.reactivex.disposables.a nVM;
        private final ScheduledExecutorService nVN;
        private final Future<?> nVO;
        private final ThreadFactory nVm;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nVK = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nVL = new ConcurrentLinkedQueue<>();
            this.nVM = new io.reactivex.disposables.a();
            this.nVm = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nVG);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nVK, this.nVK, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nVN = scheduledExecutorService;
            this.nVO = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dTn();
        }

        c dTm() {
            if (this.nVM.isDisposed()) {
                return d.nVI;
            }
            while (!this.nVL.isEmpty()) {
                c poll = this.nVL.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.nVm);
            this.nVM.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gy(now() + this.nVK);
            this.nVL.offer(cVar);
        }

        void dTn() {
            if (!this.nVL.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nVL.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dTo() <= now) {
                        if (this.nVL.remove(next)) {
                            this.nVM.b(next);
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
            this.nVM.dispose();
            if (this.nVO != null) {
                this.nVO.cancel(true);
            }
            if (this.nVN != null) {
                this.nVN.shutdownNow();
            }
        }
    }

    public d() {
        this(nVF);
    }

    public d(ThreadFactory threadFactory) {
        this.nVm = threadFactory;
        this.nVn = new AtomicReference<>(nVJ);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nVH, this.nVm);
        if (!this.nVn.compareAndSet(nVJ, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dSS() {
        return new b(this.nVn.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nVP;
        private final c nVQ;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nVy = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nVP = aVar;
            this.nVQ = aVar.dTm();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nVy.dispose();
                this.nVP.a(this.nVQ);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nVy.isDisposed() ? EmptyDisposable.INSTANCE : this.nVQ.a(runnable, j, timeUnit, this.nVy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nVR;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nVR = 0L;
        }

        public long dTo() {
            return this.nVR;
        }

        public void gy(long j) {
            this.nVR = j;
        }
    }
}
