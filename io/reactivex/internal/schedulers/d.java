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
    static final RxThreadFactory nVD;
    static final RxThreadFactory nVE;
    private static final TimeUnit nVF = TimeUnit.SECONDS;
    static final c nVG = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nVH;
    final ThreadFactory nVk;
    final AtomicReference<a> nVl;

    static {
        nVG.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nVD = new RxThreadFactory("RxCachedThreadScheduler", max);
        nVE = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nVH = new a(0L, null, nVD);
        nVH.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final long nVI;
        private final ConcurrentLinkedQueue<c> nVJ;
        final io.reactivex.disposables.a nVK;
        private final ScheduledExecutorService nVL;
        private final Future<?> nVM;
        private final ThreadFactory nVk;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nVI = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nVJ = new ConcurrentLinkedQueue<>();
            this.nVK = new io.reactivex.disposables.a();
            this.nVk = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nVE);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nVI, this.nVI, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nVL = scheduledExecutorService;
            this.nVM = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dTm();
        }

        c dTl() {
            if (this.nVK.isDisposed()) {
                return d.nVG;
            }
            while (!this.nVJ.isEmpty()) {
                c poll = this.nVJ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.nVk);
            this.nVK.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gy(now() + this.nVI);
            this.nVJ.offer(cVar);
        }

        void dTm() {
            if (!this.nVJ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nVJ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dTn() <= now) {
                        if (this.nVJ.remove(next)) {
                            this.nVK.b(next);
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
            this.nVK.dispose();
            if (this.nVM != null) {
                this.nVM.cancel(true);
            }
            if (this.nVL != null) {
                this.nVL.shutdownNow();
            }
        }
    }

    public d() {
        this(nVD);
    }

    public d(ThreadFactory threadFactory) {
        this.nVk = threadFactory;
        this.nVl = new AtomicReference<>(nVH);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nVF, this.nVk);
        if (!this.nVl.compareAndSet(nVH, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dSR() {
        return new b(this.nVl.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nVN;
        private final c nVO;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nVw = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nVN = aVar;
            this.nVO = aVar.dTl();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nVw.dispose();
                this.nVN.a(this.nVO);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nVw.isDisposed() ? EmptyDisposable.INSTANCE : this.nVO.a(runnable, j, timeUnit, this.nVw);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nVP;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nVP = 0L;
        }

        public long dTn() {
            return this.nVP;
        }

        public void gy(long j) {
            this.nVP = j;
        }
    }
}
