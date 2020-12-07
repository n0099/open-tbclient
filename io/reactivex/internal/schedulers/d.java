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
    static final RxThreadFactory pHZ;
    static final RxThreadFactory pIa;
    private static final TimeUnit pIb = TimeUnit.SECONDS;
    static final c pIc = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a pId;
    final ThreadFactory pHG;
    final AtomicReference<a> pHH;

    static {
        pIc.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        pHZ = new RxThreadFactory("RxCachedThreadScheduler", max);
        pIa = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        pId = new a(0L, null, pHZ);
        pId.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class a implements Runnable {
        private final ThreadFactory pHG;
        private final long pIe;
        private final ConcurrentLinkedQueue<c> pIf;
        final io.reactivex.disposables.a pIg;
        private final ScheduledExecutorService pIh;
        private final Future<?> pIi;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.pIe = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.pIf = new ConcurrentLinkedQueue<>();
            this.pIg = new io.reactivex.disposables.a();
            this.pHG = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.pIa);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.pIe, this.pIe, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.pIh = scheduledExecutorService;
            this.pIi = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eDn();
        }

        c eDm() {
            if (this.pIg.isDisposed()) {
                return d.pIc;
            }
            while (!this.pIf.isEmpty()) {
                c poll = this.pIf.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.pHG);
            this.pIg.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.iH(now() + this.pIe);
            this.pIf.offer(cVar);
        }

        void eDn() {
            if (!this.pIf.isEmpty()) {
                long now = now();
                Iterator<c> it = this.pIf.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eDo() <= now) {
                        if (this.pIf.remove(next)) {
                            this.pIg.b(next);
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
            this.pIg.dispose();
            if (this.pIi != null) {
                this.pIi.cancel(true);
            }
            if (this.pIh != null) {
                this.pIh.shutdownNow();
            }
        }
    }

    public d() {
        this(pHZ);
    }

    public d(ThreadFactory threadFactory) {
        this.pHG = threadFactory;
        this.pHH = new AtomicReference<>(pId);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, pIb, this.pHG);
        if (!this.pHH.compareAndSet(pId, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eCV() {
        return new b(this.pHH.get());
    }

    /* loaded from: classes9.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a pHS = new io.reactivex.disposables.a();
        private final a pIj;
        private final c pIk;

        b(a aVar) {
            this.pIj = aVar;
            this.pIk = aVar.eDm();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.pHS.dispose();
                this.pIj.a(this.pIk);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.pHS.isDisposed() ? EmptyDisposable.INSTANCE : this.pIk.a(runnable, j, timeUnit, this.pHS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class c extends f {
        private long pIl;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.pIl = 0L;
        }

        public long eDo() {
            return this.pIl;
        }

        public void iH(long j) {
            this.pIl = j;
        }
    }
}
