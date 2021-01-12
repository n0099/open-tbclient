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
    static final FutureTask<Void> qgJ = new FutureTask<>(Functions.qdw, null);
    final Runnable bOk;
    final ExecutorService qgI;
    Thread runner;
    final AtomicReference<Future<?>> qgH = new AtomicReference<>();
    final AtomicReference<Future<?>> qgG = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bOk = runnable;
        this.qgI = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bOk.run();
            c(this.qgI.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.qgH.getAndSet(qgJ);
        if (andSet != null && andSet != qgJ) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.qgG.getAndSet(qgJ);
        if (andSet2 != null && andSet2 != qgJ) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qgH.get() == qgJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qgH.get();
            if (future2 == qgJ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qgH.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qgG.get();
            if (future2 == qgJ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qgG.compareAndSet(future2, future));
    }
}
