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
/* loaded from: classes3.dex */
public final class d extends v {
    static final RxThreadFactory qjE;
    static final RxThreadFactory qjF;
    private static final TimeUnit qjG = TimeUnit.SECONDS;
    static final c qjH = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a qjI;
    final ThreadFactory qjl;
    final AtomicReference<a> qjm;

    static {
        qjH.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        qjE = new RxThreadFactory("RxCachedThreadScheduler", max);
        qjF = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qjI = new a(0L, null, qjE);
        qjI.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a implements Runnable {
        private final long qjJ;
        private final ConcurrentLinkedQueue<c> qjK;
        final io.reactivex.disposables.a qjL;
        private final ScheduledExecutorService qjM;
        private final Future<?> qjN;
        private final ThreadFactory qjl;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qjJ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qjK = new ConcurrentLinkedQueue<>();
            this.qjL = new io.reactivex.disposables.a();
            this.qjl = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.qjF);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.qjJ, this.qjJ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qjM = scheduledExecutorService;
            this.qjN = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eLw();
        }

        c eLv() {
            if (this.qjL.isDisposed()) {
                return d.qjH;
            }
            while (!this.qjK.isEmpty()) {
                c poll = this.qjK.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qjl);
            this.qjL.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jr(now() + this.qjJ);
            this.qjK.offer(cVar);
        }

        void eLw() {
            if (!this.qjK.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qjK.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eLx() <= now) {
                        if (this.qjK.remove(next)) {
                            this.qjL.b(next);
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
            this.qjL.dispose();
            if (this.qjN != null) {
                this.qjN.cancel(true);
            }
            if (this.qjM != null) {
                this.qjM.shutdownNow();
            }
        }
    }

    public d() {
        this(qjE);
    }

    public d(ThreadFactory threadFactory) {
        this.qjl = threadFactory;
        this.qjm = new AtomicReference<>(qjI);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, qjG, this.qjl);
        if (!this.qjm.compareAndSet(qjI, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eLe() {
        return new b(this.qjm.get());
    }

    /* loaded from: classes3.dex */
    static final class b extends v.c {
        private final a qjO;
        private final c qjP;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a qjx = new io.reactivex.disposables.a();

        b(a aVar) {
            this.qjO = aVar;
            this.qjP = aVar.eLv();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.qjx.dispose();
                this.qjO.a(this.qjP);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.qjx.isDisposed() ? EmptyDisposable.INSTANCE : this.qjP.a(runnable, j, timeUnit, this.qjx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class c extends f {
        private long qjQ;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qjQ = 0L;
        }

        public long eLx() {
            return this.qjQ;
        }

        public void jr(long j) {
            this.qjQ = j;
        }
    }
}
