package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class ExecutorScheduler extends v {
    static final v oOG = io.reactivex.f.a.env();
    final Executor executor;

    public ExecutorScheduler(Executor executor) {
        this.executor = executor;
    }

    @Override // io.reactivex.v
    public v.c emL() {
        return new ExecutorWorker(this.executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.concurrent.Callable, io.reactivex.internal.schedulers.ScheduledDirectTask] */
    @Override // io.reactivex.v
    public io.reactivex.disposables.b F(Runnable runnable) {
        ExecutorWorker.BooleanRunnable booleanRunnable;
        Runnable I = io.reactivex.e.a.I(runnable);
        try {
            if (this.executor instanceof ExecutorService) {
                ?? scheduledDirectTask = new ScheduledDirectTask(I);
                scheduledDirectTask.setFuture(((ExecutorService) this.executor).submit((Callable) scheduledDirectTask));
                booleanRunnable = scheduledDirectTask;
            } else {
                booleanRunnable = new ExecutorWorker.BooleanRunnable(I);
                this.executor.execute(booleanRunnable);
            }
            return booleanRunnable;
        } catch (RejectedExecutionException e) {
            io.reactivex.e.a.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable I = io.reactivex.e.a.I(runnable);
        if (this.executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(I);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.executor).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e) {
                io.reactivex.e.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        DelayedRunnable delayedRunnable = new DelayedRunnable(I);
        delayedRunnable.timed.replace(oOG.b(new a(delayedRunnable), j, timeUnit));
        return delayedRunnable;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (this.executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(io.reactivex.e.a.I(runnable));
                scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.executor).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e) {
                io.reactivex.e.a.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        return super.a(runnable, j, j2, timeUnit);
    }

    /* loaded from: classes17.dex */
    public static final class ExecutorWorker extends v.c implements Runnable {
        volatile boolean disposed;
        final Executor executor;
        final AtomicInteger wip = new AtomicInteger();
        final io.reactivex.disposables.a oOK = new io.reactivex.disposables.a();
        final MpscLinkedQueue<Runnable> oOJ = new MpscLinkedQueue<>();

        public ExecutorWorker(Executor executor) {
            this.executor = executor;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            BooleanRunnable booleanRunnable = new BooleanRunnable(io.reactivex.e.a.I(runnable));
            this.oOJ.offer(booleanRunnable);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                    return booleanRunnable;
                } catch (RejectedExecutionException e) {
                    this.disposed = true;
                    this.oOJ.clear();
                    io.reactivex.e.a.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return G(runnable);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new a(sequentialDisposable2, io.reactivex.e.a.I(runnable)), this.oOK);
            this.oOK.a(scheduledRunnable);
            if (this.executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) this.executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.disposed = true;
                    io.reactivex.e.a.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new b(ExecutorScheduler.oOG.b(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.oOK.dispose();
                if (this.wip.getAndIncrement() == 0) {
                    this.oOJ.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
            if (r3.disposed == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
            r2.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
            r0 = r3.wip.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
            if (r0 == 0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i = 1;
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.oOJ;
            while (true) {
                int i2 = i;
                if (this.disposed) {
                    mpscLinkedQueue.clear();
                    return;
                }
                while (true) {
                    Runnable poll = mpscLinkedQueue.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.run();
                    if (this.disposed) {
                        mpscLinkedQueue.clear();
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes17.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements io.reactivex.disposables.b, Runnable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!get()) {
                    try {
                        this.actual.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get();
            }
        }

        /* loaded from: classes17.dex */
        final class a implements Runnable {
            private final Runnable decoratedRun;
            private final SequentialDisposable oOL;

            a(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.oOL = sequentialDisposable;
                this.decoratedRun = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.oOL.replace(ExecutorWorker.this.G(this.decoratedRun));
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class DelayedRunnable extends AtomicReference<Runnable> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public Runnable getWrappedRunnable() {
            Runnable runnable = get();
            return runnable != null ? runnable : Functions.oLy;
        }
    }

    /* loaded from: classes17.dex */
    final class a implements Runnable {
        private final DelayedRunnable oOH;

        a(DelayedRunnable delayedRunnable) {
            this.oOH = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.oOH.direct.replace(ExecutorScheduler.this.F(this.oOH));
        }
    }
}
