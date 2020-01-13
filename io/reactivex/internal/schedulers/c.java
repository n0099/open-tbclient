package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> nyE = new FutureTask<>(Functions.nvp, null);
    final Runnable nyA;
    final ExecutorService nyD;
    Thread runner;
    final AtomicReference<Future<?>> nyC = new AtomicReference<>();
    final AtomicReference<Future<?>> nyB = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.nyA = runnable;
        this.nyD = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.nyA.run();
            b(this.nyD.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.e.a.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nyC.getAndSet(nyE);
        if (andSet != null && andSet != nyE) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nyB.getAndSet(nyE);
        if (andSet2 != null && andSet2 != nyE) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nyC.get() == nyE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nyC.get();
            if (future2 == nyE) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nyC.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nyB.get();
            if (future2 == nyE) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nyB.compareAndSet(future2, future));
    }
}
