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
/* loaded from: classes6.dex */
public final class d extends v {
    static final RxThreadFactory qrR;
    static final RxThreadFactory qrS;
    private static final TimeUnit qrT = TimeUnit.SECONDS;
    static final c qrU = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a qrV;
    final ThreadFactory qry;
    final AtomicReference<a> qrz;

    static {
        qrU.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        qrR = new RxThreadFactory("RxCachedThreadScheduler", max);
        qrS = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qrV = new a(0L, null, qrR);
        qrV.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements Runnable {
        private final long qrW;
        private final ConcurrentLinkedQueue<c> qrX;
        final io.reactivex.disposables.a qrY;
        private final ScheduledExecutorService qrZ;
        private final ThreadFactory qry;
        private final Future<?> qsa;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qrW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qrX = new ConcurrentLinkedQueue<>();
            this.qrY = new io.reactivex.disposables.a();
            this.qry = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.qrS);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.qrW, this.qrW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qrZ = scheduledExecutorService;
            this.qsa = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eKq();
        }

        c eKp() {
            if (this.qrY.isDisposed()) {
                return d.qrU;
            }
            while (!this.qrX.isEmpty()) {
                c poll = this.qrX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qry);
            this.qrY.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jw(now() + this.qrW);
            this.qrX.offer(cVar);
        }

        void eKq() {
            if (!this.qrX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qrX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eKr() <= now) {
                        if (this.qrX.remove(next)) {
                            this.qrY.b(next);
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
            this.qrY.dispose();
            if (this.qsa != null) {
                this.qsa.cancel(true);
            }
            if (this.qrZ != null) {
                this.qrZ.shutdownNow();
            }
        }
    }

    public d() {
        this(qrR);
    }

    public d(ThreadFactory threadFactory) {
        this.qry = threadFactory;
        this.qrz = new AtomicReference<>(qrV);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, qrT, this.qry);
        if (!this.qrz.compareAndSet(qrV, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eJY() {
        return new b(this.qrz.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a qrK = new io.reactivex.disposables.a();
        private final a qsb;
        private final c qsc;

        b(a aVar) {
            this.qsb = aVar;
            this.qsc = aVar.eKp();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.qrK.dispose();
                this.qsb.a(this.qsc);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.qrK.isDisposed() ? EmptyDisposable.INSTANCE : this.qsc.a(runnable, j, timeUnit, this.qrK);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends f {
        private long qsd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qsd = 0L;
        }

        public long eKr() {
            return this.qsd;
        }

        public void jw(long j) {
            this.qsd = j;
        }
    }
}
