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
/* loaded from: classes5.dex */
public final class d extends v {
    static final RxThreadFactory qrp;
    static final RxThreadFactory qrq;
    private static final TimeUnit qrr = TimeUnit.SECONDS;
    static final c qrs = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a qrt;
    final ThreadFactory qqW;
    final AtomicReference<a> qqX;

    static {
        qrs.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        qrp = new RxThreadFactory("RxCachedThreadScheduler", max);
        qrq = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qrt = new a(0L, null, qrp);
        qrt.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final ThreadFactory qqW;
        private final long qru;
        private final ConcurrentLinkedQueue<c> qrv;
        final io.reactivex.disposables.a qrw;
        private final ScheduledExecutorService qrx;
        private final Future<?> qry;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qru = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qrv = new ConcurrentLinkedQueue<>();
            this.qrw = new io.reactivex.disposables.a();
            this.qqW = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.qrq);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.qru, this.qru, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qrx = scheduledExecutorService;
            this.qry = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eKI();
        }

        c eKH() {
            if (this.qrw.isDisposed()) {
                return d.qrs;
            }
            while (!this.qrv.isEmpty()) {
                c poll = this.qrv.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qqW);
            this.qrw.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jx(now() + this.qru);
            this.qrv.offer(cVar);
        }

        void eKI() {
            if (!this.qrv.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qrv.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eKJ() <= now) {
                        if (this.qrv.remove(next)) {
                            this.qrw.b(next);
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
            this.qrw.dispose();
            if (this.qry != null) {
                this.qry.cancel(true);
            }
            if (this.qrx != null) {
                this.qrx.shutdownNow();
            }
        }
    }

    public d() {
        this(qrp);
    }

    public d(ThreadFactory threadFactory) {
        this.qqW = threadFactory;
        this.qqX = new AtomicReference<>(qrt);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, qrr, this.qqW);
        if (!this.qqX.compareAndSet(qrt, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eKq() {
        return new b(this.qqX.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        private final c qrA;
        private final a qrz;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a qri = new io.reactivex.disposables.a();

        b(a aVar) {
            this.qrz = aVar;
            this.qrA = aVar.eKH();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.qri.dispose();
                this.qrz.a(this.qrA);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.qri.isDisposed() ? EmptyDisposable.INSTANCE : this.qrA.a(runnable, j, timeUnit, this.qri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        private long qrB;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qrB = 0L;
        }

        public long eKJ() {
            return this.qrB;
        }

        public void jx(long j) {
            this.qrB = j;
        }
    }
}
