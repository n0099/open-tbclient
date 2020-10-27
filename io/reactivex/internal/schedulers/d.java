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
    static final RxThreadFactory pGo;
    static final RxThreadFactory pGp;
    private static final TimeUnit pGq = TimeUnit.SECONDS;
    static final c pGr = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a pGs;
    final ThreadFactory pFV;
    final AtomicReference<a> pFW;

    static {
        pGr.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        pGo = new RxThreadFactory("RxCachedThreadScheduler", max);
        pGp = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        pGs = new a(0L, null, pGo);
        pGs.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class a implements Runnable {
        private final ThreadFactory pFV;
        private final long pGt;
        private final ConcurrentLinkedQueue<c> pGu;
        final io.reactivex.disposables.a pGv;
        private final ScheduledExecutorService pGw;
        private final Future<?> pGx;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pGt = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pGu = new ConcurrentLinkedQueue<>();
            this.pGv = new io.reactivex.disposables.a();
            this.pFV = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.pGp);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.pGt, this.pGt, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pGw = scheduledExecutorService;
            this.pGx = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            exg();
        }

        c exf() {
            if (this.pGv.isDisposed()) {
                return d.pGr;
            }
            while (!this.pGu.isEmpty()) {
                c poll = this.pGu.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pFV);
            this.pGv.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hJ(now() + this.pGt);
            this.pGu.offer(cVar);
        }

        void exg() {
            if (!this.pGu.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pGu.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.exh() <= now) {
                        if (this.pGu.remove(next)) {
                            this.pGv.b(next);
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
            this.pGv.dispose();
            if (this.pGx != null) {
                this.pGx.cancel(true);
            }
            if (this.pGw != null) {
                this.pGw.shutdownNow();
            }
        }
    }

    public d() {
        this(pGo);
    }

    public d(ThreadFactory threadFactory) {
        this.pFV = threadFactory;
        this.pFW = new AtomicReference<>(pGs);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, pGq, this.pFV);
        if (!this.pFW.compareAndSet(pGs, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c ewL() {
        return new b(this.pFW.get());
    }

    /* loaded from: classes17.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a pGh = new io.reactivex.disposables.a();
        private final a pGy;
        private final c pGz;

        b(a aVar) {
            this.pGy = aVar;
            this.pGz = aVar.exf();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.pGh.dispose();
                this.pGy.a(this.pGz);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.pGh.isDisposed() ? EmptyDisposable.INSTANCE : this.pGz.a(runnable, j, timeUnit, this.pGh);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class c extends f {
        private long pGA;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pGA = 0L;
        }

        public long exh() {
            return this.pGA;
        }

        public void hJ(long j) {
            this.pGA = j;
        }
    }
}
