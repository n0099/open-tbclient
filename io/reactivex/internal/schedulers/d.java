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
    static final RxThreadFactory qqP;
    static final RxThreadFactory qqQ;
    private static final TimeUnit qqR = TimeUnit.SECONDS;
    static final c qqS = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a qqT;
    final ThreadFactory qqw;
    final AtomicReference<a> qqx;

    static {
        qqS.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        qqP = new RxThreadFactory("RxCachedThreadScheduler", max);
        qqQ = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qqT = new a(0L, null, qqP);
        qqT.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final long qqU;
        private final ConcurrentLinkedQueue<c> qqV;
        final io.reactivex.disposables.a qqW;
        private final ScheduledExecutorService qqX;
        private final Future<?> qqY;
        private final ThreadFactory qqw;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qqU = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qqV = new ConcurrentLinkedQueue<>();
            this.qqW = new io.reactivex.disposables.a();
            this.qqw = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.qqQ);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.qqU, this.qqU, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qqX = scheduledExecutorService;
            this.qqY = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eKA();
        }

        c eKz() {
            if (this.qqW.isDisposed()) {
                return d.qqS;
            }
            while (!this.qqV.isEmpty()) {
                c poll = this.qqV.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qqw);
            this.qqW.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jx(now() + this.qqU);
            this.qqV.offer(cVar);
        }

        void eKA() {
            if (!this.qqV.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qqV.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eKB() <= now) {
                        if (this.qqV.remove(next)) {
                            this.qqW.b(next);
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
            this.qqW.dispose();
            if (this.qqY != null) {
                this.qqY.cancel(true);
            }
            if (this.qqX != null) {
                this.qqX.shutdownNow();
            }
        }
    }

    public d() {
        this(qqP);
    }

    public d(ThreadFactory threadFactory) {
        this.qqw = threadFactory;
        this.qqx = new AtomicReference<>(qqT);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, qqR, this.qqw);
        if (!this.qqx.compareAndSet(qqT, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eKi() {
        return new b(this.qqx.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a qqI = new io.reactivex.disposables.a();
        private final a qqZ;
        private final c qra;

        b(a aVar) {
            this.qqZ = aVar;
            this.qra = aVar.eKz();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.qqI.dispose();
                this.qqZ.a(this.qra);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.qqI.isDisposed() ? EmptyDisposable.INSTANCE : this.qra.a(runnable, j, timeUnit, this.qqI);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        private long qrb;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qrb = 0L;
        }

        public long eKB() {
            return this.qrb;
        }

        public void jx(long j) {
            this.qrb = j;
        }
    }
}
