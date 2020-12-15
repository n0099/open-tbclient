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
/* loaded from: classes9.dex */
public final class d extends v {
    static final RxThreadFactory pIb;
    static final RxThreadFactory pIc;
    private static final TimeUnit pId = TimeUnit.SECONDS;
    static final c pIe = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a pIf;
    final ThreadFactory pHI;
    final AtomicReference<a> pHJ;

    static {
        pIe.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        pIb = new RxThreadFactory("RxCachedThreadScheduler", max);
        pIc = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        pIf = new a(0L, null, pIb);
        pIf.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class a implements Runnable {
        private final ThreadFactory pHI;
        private final long pIg;
        private final ConcurrentLinkedQueue<c> pIh;
        final io.reactivex.disposables.a pIi;
        private final ScheduledExecutorService pIj;
        private final Future<?> pIk;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pIg = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pIh = new ConcurrentLinkedQueue<>();
            this.pIi = new io.reactivex.disposables.a();
            this.pHI = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.pIc);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.pIg, this.pIg, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pIj = scheduledExecutorService;
            this.pIk = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eDo();
        }

        c eDn() {
            if (this.pIi.isDisposed()) {
                return d.pIe;
            }
            while (!this.pIh.isEmpty()) {
                c poll = this.pIh.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pHI);
            this.pIi.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.iH(now() + this.pIg);
            this.pIh.offer(cVar);
        }

        void eDo() {
            if (!this.pIh.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pIh.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eDp() <= now) {
                        if (this.pIh.remove(next)) {
                            this.pIi.b(next);
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
            this.pIi.dispose();
            if (this.pIk != null) {
                this.pIk.cancel(true);
            }
            if (this.pIj != null) {
                this.pIj.shutdownNow();
            }
        }
    }

    public d() {
        this(pIb);
    }

    public d(ThreadFactory threadFactory) {
        this.pHI = threadFactory;
        this.pHJ = new AtomicReference<>(pIf);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, pId, this.pHI);
        if (!this.pHJ.compareAndSet(pIf, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eCW() {
        return new b(this.pHJ.get());
    }

    /* loaded from: classes9.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a pHU = new io.reactivex.disposables.a();
        private final a pIl;
        private final c pIm;

        b(a aVar) {
            this.pIl = aVar;
            this.pIm = aVar.eDn();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.pHU.dispose();
                this.pIl.a(this.pIm);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.pHU.isDisposed() ? EmptyDisposable.INSTANCE : this.pIm.a(runnable, j, timeUnit, this.pHU);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class c extends f {
        private long pIn;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pIn = 0L;
        }

        public long eDp() {
            return this.pIn;
        }

        public void iH(long j) {
            this.pIn = j;
        }
    }
}
