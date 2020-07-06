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
/* loaded from: classes7.dex */
public final class j extends v {
    static final RxThreadFactory nNx;
    static final ScheduledExecutorService nNy = Executors.newScheduledThreadPool(0);
    final ThreadFactory bAJ;
    final AtomicReference<ScheduledExecutorService> nNw;

    static {
        nNy.shutdown();
        nNx = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(nNx);
    }

    public j(ThreadFactory threadFactory) {
        this.nNw = new AtomicReference<>();
        this.bAJ = threadFactory;
        this.nNw.lazySet(b(threadFactory));
    }

    static ScheduledExecutorService b(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override // io.reactivex.v
    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.nNw.get();
            if (scheduledExecutorService != nNy) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = b(this.bAJ);
            }
        } while (!this.nNw.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // io.reactivex.v
    public v.c dPv() {
        return new a(this.nNw.get());
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.e.a.M(runnable));
        try {
            if (j <= 0) {
                schedule = this.nNw.get().submit(scheduledDirectTask);
            } else {
                schedule = this.nNw.get().schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            io.reactivex.e.a.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable M = io.reactivex.e.a.M(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.nNw.get();
            c cVar = new c(M, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(cVar);
                } else {
                    schedule = scheduledExecutorService.schedule(cVar, j, timeUnit);
                }
                cVar.a(schedule);
                return cVar;
            } catch (RejectedExecutionException e) {
                io.reactivex.e.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(M);
        try {
            scheduledDirectPeriodicTask.setFuture(this.nNw.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.e.a.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* loaded from: classes7.dex */
    static final class a extends v.c {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final io.reactivex.disposables.a nMN = new io.reactivex.disposables.a();

        a(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.e.a.M(runnable), this.nMN);
            this.nMN.a(scheduledRunnable);
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
                io.reactivex.e.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nMN.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
