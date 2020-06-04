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
    static final RxThreadFactory nre;
    static final RxThreadFactory nrf;
    private static final TimeUnit nrg = TimeUnit.SECONDS;
    static final c nrh = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nri;
    final ThreadFactory bvS;
    final AtomicReference<a> nqM;

    static {
        nrh.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nre = new RxThreadFactory("RxCachedThreadScheduler", max);
        nrf = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nri = new a(0L, null, nre);
        nri.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory bvS;
        private final long nrj;
        private final ConcurrentLinkedQueue<c> nrk;
        final io.reactivex.disposables.a nrl;
        private final ScheduledExecutorService nrm;
        private final Future<?> nrn;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nrj = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nrk = new ConcurrentLinkedQueue<>();
            this.nrl = new io.reactivex.disposables.a();
            this.bvS = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nrf);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nrj, this.nrj, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nrm = scheduledExecutorService;
            this.nrn = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dLg();
        }

        c dLf() {
            if (this.nrl.isDisposed()) {
                return d.nrh;
            }
            while (!this.nrk.isEmpty()) {
                c poll = this.nrk.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bvS);
            this.nrl.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gg(now() + this.nrj);
            this.nrk.offer(cVar);
        }

        void dLg() {
            if (!this.nrk.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nrk.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dLh() <= now) {
                        if (this.nrk.remove(next)) {
                            this.nrl.b(next);
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
            this.nrl.dispose();
            if (this.nrn != null) {
                this.nrn.cancel(true);
            }
            if (this.nrm != null) {
                this.nrm.shutdownNow();
            }
        }
    }

    public d() {
        this(nre);
    }

    public d(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
        this.nqM = new AtomicReference<>(nri);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nrg, this.bvS);
        if (!this.nqM.compareAndSet(nri, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dKL() {
        return new b(this.nqM.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nro;
        private final c nrp;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nqX = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nro = aVar;
            this.nrp = aVar.dLf();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nqX.dispose();
                this.nro.a(this.nrp);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nqX.isDisposed() ? EmptyDisposable.INSTANCE : this.nrp.a(runnable, j, timeUnit, this.nqX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nrq;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nrq = 0L;
        }

        public long dLh() {
            return this.nrq;
        }

        public void gg(long j) {
            this.nrq = j;
        }
    }
}
