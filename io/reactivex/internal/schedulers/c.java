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
    static final FutureTask<Void> qgK = new FutureTask<>(Functions.qdx, null);
    final Runnable bOk;
    final ExecutorService qgJ;
    Thread runner;
    final AtomicReference<Future<?>> qgI = new AtomicReference<>();
    final AtomicReference<Future<?>> qgH = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bOk = runnable;
        this.qgJ = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bOk.run();
            c(this.qgJ.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.qgI.getAndSet(qgK);
        if (andSet != null && andSet != qgK) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.qgH.getAndSet(qgK);
        if (andSet2 != null && andSet2 != qgK) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qgI.get() == qgK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qgI.get();
            if (future2 == qgK) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qgI.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qgH.get();
            if (future2 == qgK) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qgH.compareAndSet(future2, future));
    }
}
