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
    static final RxThreadFactory qlm;
    static final RxThreadFactory qln;
    private static final TimeUnit qlo = TimeUnit.SECONDS;
    static final c qlp = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    static final a qlq;
    final ThreadFactory qkT;
    final AtomicReference<a> qkU;

    static {
        qlp.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        qlm = new RxThreadFactory("RxCachedThreadScheduler", max);
        qln = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        qlq = new a(0L, null, qlm);
        qlq.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final ThreadFactory qkT;
        private final long qlr;
        private final ConcurrentLinkedQueue<c> qls;
        final io.reactivex.disposables.a qlt;
        private final ScheduledExecutorService qlu;
        private final Future<?> qlv;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qlr = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qls = new ConcurrentLinkedQueue<>();
            this.qlt = new io.reactivex.disposables.a();
            this.qkT = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.qln);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, this.qlr, this.qlr, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qlu = scheduledExecutorService;
            this.qlv = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            eMa();
        }

        c eLZ() {
            if (this.qlt.isDisposed()) {
                return d.qlp;
            }
            while (!this.qls.isEmpty()) {
                c poll = this.qls.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qkT);
            this.qlt.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ju(now() + this.qlr);
            this.qls.offer(cVar);
        }

        void eMa() {
            if (!this.qls.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qls.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eMb() <= now) {
                        if (this.qls.remove(next)) {
                            this.qlt.b(next);
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
            this.qlt.dispose();
            if (this.qlv != null) {
                this.qlv.cancel(true);
            }
            if (this.qlu != null) {
                this.qlu.shutdownNow();
            }
        }
    }

    public d() {
        this(qlm);
    }

    public d(ThreadFactory threadFactory) {
        this.qkT = threadFactory;
        this.qkU = new AtomicReference<>(qlq);
        start();
    }

    @Override // io.reactivex.v
    public void start() {
        a aVar = new a(60L, qlo, this.qkT);
        if (!this.qkU.compareAndSet(qlq, aVar)) {
            aVar.shutdown();
        }
    }

    @Override // io.reactivex.v
    public v.c eLI() {
        return new b(this.qkU.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends v.c {
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.disposables.a qlf = new io.reactivex.disposables.a();
        private final a qlw;
        private final c qlx;

        b(a aVar) {
            this.qlw = aVar;
            this.qlx = aVar.eLZ();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.qlf.dispose();
                this.qlw.a(this.qlx);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.qlf.isDisposed() ? EmptyDisposable.INSTANCE : this.qlx.a(runnable, j, timeUnit, this.qlf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        private long qly;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qly = 0L;
        }

        public long eMb() {
            return this.qly;
        }

        public void ju(long j) {
            this.qly = j;
        }
    }
}
