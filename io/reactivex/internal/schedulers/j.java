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
    static final RxThreadFactory nqx;
    static final ScheduledExecutorService nqy = Executors.newScheduledThreadPool(0);
    final ThreadFactory bvS;
    final AtomicReference<ScheduledExecutorService> nqw;

    static {
        nqy.shutdown();
        nqx = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(nqx);
    }

    public j(ThreadFactory threadFactory) {
        this.nqw = new AtomicReference<>();
        this.bvS = threadFactory;
        this.nqw.lazySet(b(threadFactory));
    }

    static ScheduledExecutorService b(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override // io.reactivex.v
    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.nqw.get();
            if (scheduledExecutorService != nqy) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = b(this.bvS);
            }
        } while (!this.nqw.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // io.reactivex.v
    public v.c dKx() {
        return new a(this.nqw.get());
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.e.a.M(runnable));
        try {
            if (j <= 0) {
                schedule = this.nqw.get().submit(scheduledDirectTask);
            } else {
                schedule = this.nqw.get().schedule(scheduledDirectTask, j, timeUnit);
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
            ScheduledExecutorService scheduledExecutorService = this.nqw.get();
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
            scheduledDirectPeriodicTask.setFuture(this.nqw.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
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
        final io.reactivex.disposables.a npN = new io.reactivex.disposables.a();

        a(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.e.a.M(runnable), this.npN);
            this.npN.a(scheduledRunnable);
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
                this.npN.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
