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
    static final RxThreadFactory oOR;
    static final RxThreadFactory oOS;
    private static final TimeUnit oOT = TimeUnit.SECONDS;
    static final c oOU = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a oOV;
    final ThreadFactory oOy;
    final AtomicReference<a> oOz;

    static {
        oOU.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        oOR = new RxThreadFactory("RxCachedThreadScheduler", max);
        oOS = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        oOV = new a(0L, null, oOR);
        oOV.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class a implements Runnable {
        private final long oOW;
        private final ConcurrentLinkedQueue<c> oOX;
        final io.reactivex.disposables.a oOY;
        private final ScheduledExecutorService oOZ;
        private final ThreadFactory oOy;
        private final Future<?> oPa;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.oOW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.oOX = new ConcurrentLinkedQueue<>();
            this.oOY = new io.reactivex.disposables.a();
            this.oOy = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.oOS);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.oOW, this.oOW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.oOZ = scheduledExecutorService;
            this.oPa = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            enh();
        }

        c eng() {
            if (this.oOY.isDisposed()) {
                return d.oOU;
            }
            while (!this.oOX.isEmpty()) {
                c poll = this.oOX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.oOy);
            this.oOY.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ht(now() + this.oOW);
            this.oOX.offer(cVar);
        }

        void enh() {
            if (!this.oOX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.oOX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eni() <= now) {
                        if (this.oOX.remove(next)) {
                            this.oOY.b(next);
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
            this.oOY.dispose();
            if (this.oPa != null) {
                this.oPa.cancel(true);
            }
            if (this.oOZ != null) {
                this.oOZ.shutdownNow();
            }
        }
    }

    public d() {
        this(oOR);
    }

    public d(ThreadFactory threadFactory) {
        this.oOy = threadFactory;
        this.oOz = new AtomicReference<>(oOV);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, oOT, this.oOy);
        if (!this.oOz.compareAndSet(oOV, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c emL() {
        return new b(this.oOz.get());
    }

    /* loaded from: classes17.dex */
    static final class b extends v.c {
        private final a oPb;
        private final c oPc;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a oOK = new io.reactivex.disposables.a();

        b(a aVar) {
            this.oPb = aVar;
            this.oPc = aVar.eng();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.oOK.dispose();
                this.oPb.a(this.oPc);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.oOK.isDisposed() ? EmptyDisposable.INSTANCE : this.oPc.a(runnable, j, timeUnit, this.oOK);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class c extends f {
        private long oPd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.oPd = 0L;
        }

        public long eni() {
            return this.oPd;
        }

        public void ht(long j) {
            this.oPd = j;
        }
    }
}
