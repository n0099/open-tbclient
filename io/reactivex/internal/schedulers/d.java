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
    static final RxThreadFactory nyK;
    static final RxThreadFactory nyL;
    private static final TimeUnit nyM = TimeUnit.SECONDS;
    static final c nyN = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a nyO;
    final ThreadFactory aNw;
    final AtomicReference<a> nys;

    static {
        nyN.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        nyK = new RxThreadFactory("RxCachedThreadScheduler", max);
        nyL = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        nyO = new a(0L, null, nyK);
        nyO.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final ThreadFactory aNw;
        private final long nyP;
        private final ConcurrentLinkedQueue<c> nyQ;
        final io.reactivex.disposables.a nyR;
        private final ScheduledExecutorService nyS;
        private final Future<?> nyT;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nyP = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nyQ = new ConcurrentLinkedQueue<>();
            this.nyR = new io.reactivex.disposables.a();
            this.aNw = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.nyL);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.nyP, this.nyP, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nyS = scheduledExecutorService;
            this.nyT = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dIs();
        }

        c dIr() {
            if (this.nyR.isDisposed()) {
                return d.nyN;
            }
            while (!this.nyQ.isEmpty()) {
                c poll = this.nyQ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aNw);
            this.nyR.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hf(now() + this.nyP);
            this.nyQ.offer(cVar);
        }

        void dIs() {
            if (!this.nyQ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nyQ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dIt() <= now) {
                        if (this.nyQ.remove(next)) {
                            this.nyR.b(next);
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
            this.nyR.dispose();
            if (this.nyT != null) {
                this.nyT.cancel(true);
            }
            if (this.nyS != null) {
                this.nyS.shutdownNow();
            }
        }
    }

    public d() {
        this(nyK);
    }

    public d(ThreadFactory threadFactory) {
        this.aNw = threadFactory;
        this.nys = new AtomicReference<>(nyO);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, nyM, this.aNw);
        if (!this.nys.compareAndSet(nyO, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dHY() {
        return new b(this.nys.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        private final a nyU;
        private final c nyV;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a nyC = new io.reactivex.disposables.a();

        b(a aVar) {
            this.nyU = aVar;
            this.nyV = aVar.dIr();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.nyC.dispose();
                this.nyU.a(this.nyV);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.nyC.isDisposed() ? EmptyDisposable.INSTANCE : this.nyV.a(runnable, j, timeUnit, this.nyC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        private long nyW;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nyW = 0L;
        }

        public long dIt() {
            return this.nyW;
        }

        public void hf(long j) {
            this.nyW = j;
        }
    }
}
