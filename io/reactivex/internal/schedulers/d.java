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
    static final RxThreadFactory nyF;
    static final RxThreadFactory nyG;
    private static final TimeUnit nyH = TimeUnit.SECONDS;
    static final c nyI = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nyJ;
    final ThreadFactory aNw;
    final AtomicReference<a> nyn;

    static {
        nyI.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nyF = new RxThreadFactory("RxCachedThreadScheduler", max);
        nyG = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nyJ = new a(0L, null, nyF);
        nyJ.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final ThreadFactory aNw;
        private final long nyK;
        private final ConcurrentLinkedQueue<c> nyL;
        final io.reactivex.disposables.a nyM;
        private final ScheduledExecutorService nyN;
        private final Future<?> nyO;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nyK = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nyL = new ConcurrentLinkedQueue<>();
            this.nyM = new io.reactivex.disposables.a();
            this.aNw = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nyG);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nyK, this.nyK, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nyN = scheduledExecutorService;
            this.nyO = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dIq();
        }

        c dIp() {
            if (this.nyM.isDisposed()) {
                return d.nyI;
            }
            while (!this.nyL.isEmpty()) {
                c poll = this.nyL.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aNw);
            this.nyM.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hf(now() + this.nyK);
            this.nyL.offer(cVar);
        }

        void dIq() {
            if (!this.nyL.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nyL.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dIr() <= now) {
                        if (this.nyL.remove(next)) {
                            this.nyM.b(next);
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
            this.nyM.dispose();
            if (this.nyO != null) {
                this.nyO.cancel(true);
            }
            if (this.nyN != null) {
                this.nyN.shutdownNow();
            }
        }
    }

    public d() {
        this(nyF);
    }

    public d(ThreadFactory threadFactory) {
        this.aNw = threadFactory;
        this.nyn = new AtomicReference<>(nyJ);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nyH, this.aNw);
        if (!this.nyn.compareAndSet(nyJ, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dHW() {
        return new b(this.nyn.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        private final a nyP;
        private final c nyQ;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nyx = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nyP = aVar;
            this.nyQ = aVar.dIp();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nyx.dispose();
                this.nyP.a(this.nyQ);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nyx.isDisposed() ? EmptyDisposable.INSTANCE : this.nyQ.a(runnable, j, timeUnit, this.nyx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        private long nyR;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nyR = 0L;
        }

        public long dIr() {
            return this.nyR;
        }

        public void hf(long j) {
            this.nyR = j;
        }
    }
}
