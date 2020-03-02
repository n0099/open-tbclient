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
    static final RxThreadFactory nzo;
    static final RxThreadFactory nzp;
    private static final TimeUnit nzq = TimeUnit.SECONDS;
    static final c nzr = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nzs;
    final ThreadFactory aRW;
    final AtomicReference<a> nyW;

    static {
        nzr.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nzo = new RxThreadFactory("RxCachedThreadScheduler", max);
        nzp = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nzs = new a(0L, null, nzo);
        nzs.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory aRW;
        private final long nzt;
        private final ConcurrentLinkedQueue<c> nzu;
        final io.reactivex.disposables.a nzv;
        private final ScheduledExecutorService nzw;
        private final Future<?> nzx;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nzt = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nzu = new ConcurrentLinkedQueue<>();
            this.nzv = new io.reactivex.disposables.a();
            this.aRW = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nzp);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nzt, this.nzt, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nzw = scheduledExecutorService;
            this.nzx = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dJB();
        }

        c dJA() {
            if (this.nzv.isDisposed()) {
                return d.nzr;
            }
            while (!this.nzu.isEmpty()) {
                c poll = this.nzu.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aRW);
            this.nzv.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hd(now() + this.nzt);
            this.nzu.offer(cVar);
        }

        void dJB() {
            if (!this.nzu.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nzu.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dJC() <= now) {
                        if (this.nzu.remove(next)) {
                            this.nzv.b(next);
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
            this.nzv.dispose();
            if (this.nzx != null) {
                this.nzx.cancel(true);
            }
            if (this.nzw != null) {
                this.nzw.shutdownNow();
            }
        }
    }

    public d() {
        this(nzo);
    }

    public d(ThreadFactory threadFactory) {
        this.aRW = threadFactory;
        this.nyW = new AtomicReference<>(nzs);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nzq, this.aRW);
        if (!this.nyW.compareAndSet(nzs, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dJh() {
        return new b(this.nyW.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nzy;
        private final c nzz;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nzg = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nzy = aVar;
            this.nzz = aVar.dJA();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nzg.dispose();
                this.nzy.a(this.nzz);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nzg.isDisposed() ? EmptyDisposable.INSTANCE : this.nzz.a(runnable, j, timeUnit, this.nzg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nzA;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nzA = 0L;
        }

        public long dJC() {
            return this.nzA;
        }

        public void hd(long j) {
            this.nzA = j;
        }
    }
}
