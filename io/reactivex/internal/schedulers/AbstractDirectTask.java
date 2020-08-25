package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;
    protected static final FutureTask<Void> FINISHED = new FutureTask<>(Functions.omg, null);
    protected static final FutureTask<Void> DISPOSED = new FutureTask<>(Functions.omg, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        Future<?> future = get();
        if (future != FINISHED && future != DISPOSED && compareAndSet(future, DISPOSED) && future != null) {
            future.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == FINISHED || future == DISPOSED;
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 != FINISHED) {
                if (future2 == DISPOSED) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }
}
