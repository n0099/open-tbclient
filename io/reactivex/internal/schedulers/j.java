package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class j extends v {
    static final RxThreadFactory qrS;
    static final ScheduledExecutorService qrT = Executors.newScheduledThreadPool(0);
    final ThreadFactory qqW;
    final AtomicReference<ScheduledExecutorService> qrR;

    static {
        qrT.shutdown();
        qrS = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(qrS);
    }

    public j(ThreadFactory threadFactory) {
        this.qrR = new AtomicReference<>();
        this.qqW = threadFactory;
        this.qrR.lazySet(b(threadFactory));
    }

    static ScheduledExecutorService b(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override // io.reactivex.v
    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.qrR.get();
            if (scheduledExecutorService != qrT) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = b(this.qqW);
            }
        } while (!this.qrR.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // io.reactivex.v
    public v.c eKq() {
        return new a(this.qrR.get());
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.d.a.G(runnable));
        try {
            if (j <= 0) {
                schedule = this.qrR.get().submit(scheduledDirectTask);
            } else {
                schedule = this.qrR.get().schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            io.reactivex.d.a.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable G = io.reactivex.d.a.G(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.qrR.get();
            c cVar = new c(G, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(cVar);
                } else {
                    schedule = scheduledExecutorService.schedule(cVar, j, timeUnit);
                }
                cVar.b(schedule);
                return cVar;
            } catch (RejectedExecutionException e) {
                io.reactivex.d.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(G);
        try {
            scheduledDirectPeriodicTask.setFuture(this.qrR.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.d.a.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* loaded from: classes5.dex */
    static final class a extends v.c {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final io.reactivex.disposables.a qri = new io.reactivex.disposables.a();

        a(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.d.a.G(runnable), this.qri);
            this.qri.a(scheduledRunnable);
            try {
                if (j <= 0) {
                    schedule = this.executor.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.executor.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
                return scheduledRunnable;
            } catch (RejectedExecutionException e) {
                dispose();
                io.reactivex.d.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qri.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
