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
    static final RxThreadFactory opC;
    static final RxThreadFactory opD;
    private static final TimeUnit opE = TimeUnit.SECONDS;
    static final c opF = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a opG;
    final ThreadFactory opi;
    final AtomicReference<a> opj;

    static {
        opF.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        opC = new RxThreadFactory("RxCachedThreadScheduler", max);
        opD = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        opG = new a(0L, null, opC);
        opG.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final long opH;
        private final ConcurrentLinkedQueue<c> opI;
        final io.reactivex.disposables.a opJ;
        private final ScheduledExecutorService opK;
        private final Future<?> opL;
        private final ThreadFactory opi;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.opH = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.opI = new ConcurrentLinkedQueue<>();
            this.opJ = new io.reactivex.disposables.a();
            this.opi = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.opD);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.opH, this.opH, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.opK = scheduledExecutorService;
            this.opL = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            efp();
        }

        c efo() {
            if (this.opJ.isDisposed()) {
                return d.opF;
            }
            while (!this.opI.isEmpty()) {
                c poll = this.opI.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.opi);
            this.opJ.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gL(now() + this.opH);
            this.opI.offer(cVar);
        }

        void efp() {
            if (!this.opI.isEmpty()) {
                long now = now();
                Iterator<c> it = this.opI.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.efq() <= now) {
                        if (this.opI.remove(next)) {
                            this.opJ.b(next);
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
            this.opJ.dispose();
            if (this.opL != null) {
                this.opL.cancel(true);
            }
            if (this.opK != null) {
                this.opK.shutdownNow();
            }
        }
    }

    public d() {
        this(opC);
    }

    public d(ThreadFactory threadFactory) {
        this.opi = threadFactory;
        this.opj = new AtomicReference<>(opG);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, opE, this.opi);
        if (!this.opj.compareAndSet(opG, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eeU() {
        return new b(this.opj.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a opM;
        private final c opN;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a opv = new io.reactivex.disposables.a();

        b(a aVar) {
            this.opM = aVar;
            this.opN = aVar.efo();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.opv.dispose();
                this.opM.a(this.opN);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.opv.isDisposed() ? EmptyDisposable.INSTANCE : this.opN.a(runnable, j, timeUnit, this.opv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long opO;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.opO = 0L;
        }

        public long efq() {
            return this.opO;
        }

        public void gL(long j) {
            this.opO = j;
        }
    }
}
