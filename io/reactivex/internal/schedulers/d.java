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
    static final RxThreadFactory mUO;
    static final RxThreadFactory mUP;
    private static final TimeUnit mUQ = TimeUnit.SECONDS;
    static final c mUR = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a mUS;
    final ThreadFactory bon;
    final AtomicReference<a> mUw;

    static {
        mUR.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        mUO = new RxThreadFactory("RxCachedThreadScheduler", max);
        mUP = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        mUS = new a(0L, null, mUO);
        mUS.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory bon;
        private final long mUT;
        private final ConcurrentLinkedQueue<c> mUU;
        final io.reactivex.disposables.a mUV;
        private final ScheduledExecutorService mUW;
        private final Future<?> mUX;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.mUT = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.mUU = new ConcurrentLinkedQueue<>();
            this.mUV = new io.reactivex.disposables.a();
            this.bon = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.mUP);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.mUT, this.mUT, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.mUW = scheduledExecutorService;
            this.mUX = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dDb();
        }

        c dDa() {
            if (this.mUV.isDisposed()) {
                return d.mUR;
            }
            while (!this.mUU.isEmpty()) {
                c poll = this.mUU.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bon);
            this.mUV.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gf(now() + this.mUT);
            this.mUU.offer(cVar);
        }

        void dDb() {
            if (!this.mUU.isEmpty()) {
                long now = now();
                Iterator<c> it = this.mUU.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dDc() <= now) {
                        if (this.mUU.remove(next)) {
                            this.mUV.b(next);
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
            this.mUV.dispose();
            if (this.mUX != null) {
                this.mUX.cancel(true);
            }
            if (this.mUW != null) {
                this.mUW.shutdownNow();
            }
        }
    }

    public d() {
        this(mUO);
    }

    public d(ThreadFactory threadFactory) {
        this.bon = threadFactory;
        this.mUw = new AtomicReference<>(mUS);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, mUQ, this.bon);
        if (!this.mUw.compareAndSet(mUS, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dCG() {
        return new b(this.mUw.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a mUY;
        private final c mUZ;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a mUH = new io.reactivex.disposables.a();

        b(a aVar) {
            this.mUY = aVar;
            this.mUZ = aVar.dDa();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.mUH.dispose();
                this.mUY.a(this.mUZ);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.mUH.isDisposed() ? EmptyDisposable.INSTANCE : this.mUZ.a(runnable, j, timeUnit, this.mUH);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long mVa;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.mVa = 0L;
        }

        public long dDc() {
            return this.mVa;
        }

        public void gf(long j) {
            this.mVa = j;
        }
    }
}
