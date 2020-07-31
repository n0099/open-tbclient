package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class f extends v.c implements io.reactivex.disposables.b {
    volatile boolean disposed;
    private final ScheduledExecutorService executor;

    public f(ThreadFactory threadFactory) {
        this.executor = i.a(threadFactory);
    }

    @Override // io.reactivex.v.c
    public io.reactivex.disposables.b J(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // io.reactivex.v.c
    public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.disposed ? EmptyDisposable.INSTANCE : a(runnable, j, timeUnit, (io.reactivex.internal.disposables.a) null);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.e.a.L(runnable));
        try {
            if (j <= 0) {
                schedule = this.executor.submit(scheduledDirectTask);
            } else {
                schedule = this.executor.schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            io.reactivex.e.a.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable L = io.reactivex.e.a.L(runnable);
        if (j2 <= 0) {
            c cVar = new c(L, this.executor);
            try {
                if (j <= 0) {
                    schedule = this.executor.submit(cVar);
                } else {
                    schedule = this.executor.schedule(cVar, j, timeUnit);
                }
                cVar.a(schedule);
                return cVar;
            } catch (RejectedExecutionException e) {
                io.reactivex.e.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(L);
        try {
            scheduledDirectPeriodicTask.setFuture(this.executor.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.e.a.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public ScheduledRunnable a(Runnable runnable, long j, TimeUnit timeUnit, io.reactivex.internal.disposables.a aVar) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.e.a.L(runnable), aVar);
        if (aVar == null || aVar.a(scheduledRunnable)) {
            try {
                if (j <= 0) {
                    schedule = this.executor.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.executor.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
            } catch (RejectedExecutionException e) {
                if (aVar != null) {
                    aVar.b(scheduledRunnable);
                }
                io.reactivex.e.a.onError(e);
            }
        }
        return scheduledRunnable;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.executor.shutdownNow();
        }
    }

    public void shutdown() {
        if (!this.disposed) {
            this.disposed = true;
            this.executor.shutdown();
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposed;
    }
}
