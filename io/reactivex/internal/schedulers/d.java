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
    static final RxThreadFactory nBm;
    static final RxThreadFactory nBn;
    private static final TimeUnit nBo = TimeUnit.SECONDS;
    static final c nBp = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nBq;
    final ThreadFactory aSk;
    final AtomicReference<a> nAU;

    static {
        nBp.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nBm = new RxThreadFactory("RxCachedThreadScheduler", max);
        nBn = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nBq = new a(0L, null, nBm);
        nBq.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory aSk;
        private final long nBr;
        private final ConcurrentLinkedQueue<c> nBs;
        final io.reactivex.disposables.a nBt;
        private final ScheduledExecutorService nBu;
        private final Future<?> nBv;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nBr = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nBs = new ConcurrentLinkedQueue<>();
            this.nBt = new io.reactivex.disposables.a();
            this.aSk = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nBn);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nBr, this.nBr, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nBu = scheduledExecutorService;
            this.nBv = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dKc();
        }

        c dKb() {
            if (this.nBt.isDisposed()) {
                return d.nBp;
            }
            while (!this.nBs.isEmpty()) {
                c poll = this.nBs.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aSk);
            this.nBt.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.he(now() + this.nBr);
            this.nBs.offer(cVar);
        }

        void dKc() {
            if (!this.nBs.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nBs.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dKd() <= now) {
                        if (this.nBs.remove(next)) {
                            this.nBt.b(next);
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
            this.nBt.dispose();
            if (this.nBv != null) {
                this.nBv.cancel(true);
            }
            if (this.nBu != null) {
                this.nBu.shutdownNow();
            }
        }
    }

    public d() {
        this(nBm);
    }

    public d(ThreadFactory threadFactory) {
        this.aSk = threadFactory;
        this.nAU = new AtomicReference<>(nBq);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nBo, this.aSk);
        if (!this.nAU.compareAndSet(nBq, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dJI() {
        return new b(this.nAU.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nBw;
        private final c nBx;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nBe = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nBw = aVar;
            this.nBx = aVar.dKb();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nBe.dispose();
                this.nBw.a(this.nBx);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nBe.isDisposed() ? EmptyDisposable.INSTANCE : this.nBx.a(runnable, j, timeUnit, this.nBe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nBy;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nBy = 0L;
        }

        public long dKd() {
            return this.nBy;
        }

        public void he(long j) {
            this.nBy = j;
        }
    }
}
