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
    static final RxThreadFactory npU;
    static final RxThreadFactory npV;
    private static final TimeUnit npW = TimeUnit.SECONDS;
    static final c npX = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a npY;
    final ThreadFactory bvS;
    final AtomicReference<a> npC;

    static {
        npX.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        npU = new RxThreadFactory("RxCachedThreadScheduler", max);
        npV = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        npY = new a(0L, null, npU);
        npY.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory bvS;
        private final long npZ;
        private final ConcurrentLinkedQueue<c> nqa;
        final io.reactivex.disposables.a nqb;
        private final ScheduledExecutorService nqc;
        private final Future<?> nqd;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.npZ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nqa = new ConcurrentLinkedQueue<>();
            this.nqb = new io.reactivex.disposables.a();
            this.bvS = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.npV);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.npZ, this.npZ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nqc = scheduledExecutorService;
            this.nqd = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dKS();
        }

        c dKR() {
            if (this.nqb.isDisposed()) {
                return d.npX;
            }
            while (!this.nqa.isEmpty()) {
                c poll = this.nqa.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bvS);
            this.nqb.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gg(now() + this.npZ);
            this.nqa.offer(cVar);
        }

        void dKS() {
            if (!this.nqa.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nqa.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dKT() <= now) {
                        if (this.nqa.remove(next)) {
                            this.nqb.b(next);
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
            this.nqb.dispose();
            if (this.nqd != null) {
                this.nqd.cancel(true);
            }
            if (this.nqc != null) {
                this.nqc.shutdownNow();
            }
        }
    }

    public d() {
        this(npU);
    }

    public d(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
        this.npC = new AtomicReference<>(npY);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, npW, this.bvS);
        if (!this.npC.compareAndSet(npY, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dKx() {
        return new b(this.npC.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a nqe;
        private final c nqf;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a npN = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nqe = aVar;
            this.nqf = aVar.dKR();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.npN.dispose();
                this.nqe.a(this.nqf);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.npN.isDisposed() ? EmptyDisposable.INSTANCE : this.nqf.a(runnable, j, timeUnit, this.npN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long nqg;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nqg = 0L;
        }

        public long dKT() {
            return this.nqg;
        }

        public void gg(long j) {
            this.nqg = j;
        }
    }
}
