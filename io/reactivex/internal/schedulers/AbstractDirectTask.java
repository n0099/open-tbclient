package io.reactivex.internal.schedulers;

import f.a.t.b;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements b {
    public static final long serialVersionUID = 1811839108042568751L;
    public final Runnable runnable;
    public Thread runner;
    public static final FutureTask<Void> FINISHED = new FutureTask<>(Functions.f68026a, null);
    public static final FutureTask<Void> DISPOSED = new FutureTask<>(Functions.f68026a, null);

    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // f.a.t.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == FINISHED || future == (futureTask = DISPOSED) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.runner != Thread.currentThread());
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // f.a.t.b
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == FINISHED || future == DISPOSED;
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == FINISHED) {
                return;
            }
            if (future2 == DISPOSED) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
