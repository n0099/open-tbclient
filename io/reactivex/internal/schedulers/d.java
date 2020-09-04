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
    static final RxThreadFactory opU;
    static final RxThreadFactory opV;
    private static final TimeUnit opW = TimeUnit.SECONDS;
    static final c opX = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a opY;
    final ThreadFactory opB;
    final AtomicReference<a> opC;

    static {
        opX.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        opU = new RxThreadFactory("RxCachedThreadScheduler", max);
        opV = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        opY = new a(0L, null, opU);
        opY.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory opB;
        private final long opZ;
        private final ConcurrentLinkedQueue<c> oqa;
        final io.reactivex.disposables.a oqb;
        private final ScheduledExecutorService oqc;
        private final Future<?> oqd;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.opZ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.oqa = new ConcurrentLinkedQueue<>();
            this.oqb = new io.reactivex.disposables.a();
            this.opB = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.opV);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.opZ, this.opZ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.oqc = scheduledExecutorService;
            this.oqd = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            efy();
        }

        c efx() {
            if (this.oqb.isDisposed()) {
                return d.opX;
            }
            while (!this.oqa.isEmpty()) {
                c poll = this.oqa.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.opB);
            this.oqb.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gN(now() + this.opZ);
            this.oqa.offer(cVar);
        }

        void efy() {
            if (!this.oqa.isEmpty()) {
                long now = now();
                Iterator<c> it = this.oqa.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.efz() <= now) {
                        if (this.oqa.remove(next)) {
                            this.oqb.b(next);
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
            this.oqb.dispose();
            if (this.oqd != null) {
                this.oqd.cancel(true);
            }
            if (this.oqc != null) {
                this.oqc.shutdownNow();
            }
        }
    }

    public d() {
        this(opU);
    }

    public d(ThreadFactory threadFactory) {
        this.opB = threadFactory;
        this.opC = new AtomicReference<>(opY);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, opW, this.opB);
        if (!this.opC.compareAndSet(opY, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c efd() {
        return new b(this.opC.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a opN = new io.reactivex.disposables.a();
        private final a oqe;
        private final c oqf;

        b(a aVar) {
            this.oqe = aVar;
            this.oqf = aVar.efx();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.opN.dispose();
                this.oqe.a(this.oqf);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.opN.isDisposed() ? EmptyDisposable.INSTANCE : this.oqf.a(runnable, j, timeUnit, this.opN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long oqg;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.oqg = 0L;
        }

        public long efz() {
            return this.oqg;
        }

        public void gN(long j) {
            this.oqg = j;
        }
    }
}
