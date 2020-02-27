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
    static final RxThreadFactory nzm;
    static final RxThreadFactory nzn;
    private static final TimeUnit nzo = TimeUnit.SECONDS;
    static final c nzp = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nzq;
    final ThreadFactory aRV;
    final AtomicReference<a> nyU;

    static {
        nzp.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nzm = new RxThreadFactory("RxCachedThreadScheduler", max);
        nzn = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nzq = new a(0L, null, nzm);
        nzq.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory aRV;
        private final long nzr;
        private final ConcurrentLinkedQueue<c> nzs;
        final io.reactivex.disposables.a nzt;
        private final ScheduledExecutorService nzu;
        private final Future<?> nzv;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nzr = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nzs = new ConcurrentLinkedQueue<>();
            this.nzt = new io.reactivex.disposables.a();
            this.aRV = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nzn);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nzr, this.nzr, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nzu = scheduledExecutorService;
            this.nzv = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dJz();
        }

        c dJy() {
            if (this.nzt.isDisposed()) {
                return d.nzp;
            }
            while (!this.nzs.isEmpty()) {
                c poll = this.nzs.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aRV);
            this.nzt.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hd(now() + this.nzr);
            this.nzs.offer(cVar);
        }

        void dJz() {
            if (!this.nzs.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nzs.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dJA() <= now) {
                        if (this.nzs.remove(next)) {
                            this.nzt.b(next);
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
            this.nzt.dispose();
            if (this.nzv != null) {
                this.nzv.cancel(true);
            }
            if (this.nzu != null) {
                this.nzu.shutdownNow();
            }
        }
    }

    public d() {
        this(nzm);
    }

    public d(ThreadFactory threadFactory) {
        this.aRV = threadFactory;
        this.nyU = new AtomicReference<>(nzq);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nzo, this.aRV);
        if (!this.nyU.compareAndSet(nzq, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dJf() {
        return new b(this.nyU.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nzw;
        private final c nzx;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nze = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nzw = aVar;
            this.nzx = aVar.dJy();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nze.dispose();
                this.nzw.a(this.nzx);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nze.isDisposed() ? EmptyDisposable.INSTANCE : this.nzx.a(runnable, j, timeUnit, this.nze);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nzy;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nzy = 0L;
        }

        public long dJA() {
            return this.nzy;
        }

        public void hd(long j) {
            this.nzy = j;
        }
    }
}
