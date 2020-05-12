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
    static final RxThreadFactory mUR;
    static final RxThreadFactory mUS;
    private static final TimeUnit mUT = TimeUnit.SECONDS;
    static final c mUU = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a mUV;
    final ThreadFactory bos;
    final AtomicReference<a> mUz;

    static {
        mUU.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        mUR = new RxThreadFactory("RxCachedThreadScheduler", max);
        mUS = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        mUV = new a(0L, null, mUR);
        mUV.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final ThreadFactory bos;
        private final long mUW;
        private final ConcurrentLinkedQueue<c> mUX;
        final io.reactivex.disposables.a mUY;
        private final ScheduledExecutorService mUZ;
        private final Future<?> mVa;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.mUW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.mUX = new ConcurrentLinkedQueue<>();
            this.mUY = new io.reactivex.disposables.a();
            this.bos = threadFactory;
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, d.mUS);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(this, this.mUW, this.mUW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.mUZ = scheduledExecutorService;
            this.mVa = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            dCY();
        }

        c dCX() {
            if (this.mUY.isDisposed()) {
                return d.mUU;
            }
            while (!this.mUX.isEmpty()) {
                c poll = this.mUX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bos);
            this.mUY.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gf(now() + this.mUW);
            this.mUX.offer(cVar);
        }

        void dCY() {
            if (!this.mUX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.mUX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dCZ() <= now) {
                        if (this.mUX.remove(next)) {
                            this.mUY.b(next);
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
            this.mUY.dispose();
            if (this.mVa != null) {
                this.mVa.cancel(true);
            }
            if (this.mUZ != null) {
                this.mUZ.shutdownNow();
            }
        }
    }

    public d() {
        this(mUR);
    }

    public d(ThreadFactory threadFactory) {
        this.bos = threadFactory;
        this.mUz = new AtomicReference<>(mUV);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, mUT, this.bos);
        if (!this.mUz.compareAndSet(mUV, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c dCD() {
        return new b(this.mUz.get());
    }

    /* loaded from: classes7.dex */
    static final class b extends v.c {
        private final a mVb;
        private final c mVc;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a mUK = new io.reactivex.disposables.a();

        b(a aVar) {
            this.mVb = aVar;
            this.mVc = aVar.dCX();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.mUK.dispose();
                this.mVb.a(this.mVc);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.mUK.isDisposed() ? EmptyDisposable.INSTANCE : this.mVc.a(runnable, j, timeUnit, this.mUK);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        private long mVd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.mVd = 0L;
        }

        public long dCZ() {
            return this.mVd;
        }

        public void gf(long j) {
            this.mVd = j;
        }
    }
}
