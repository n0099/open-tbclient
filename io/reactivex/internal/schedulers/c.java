package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> qjD = new FutureTask<>(Functions.qgp, null);
    final Runnable bSW;
    final ExecutorService qjC;
    Thread runner;
    final AtomicReference<Future<?>> qjB = new AtomicReference<>();
    final AtomicReference<Future<?>> qjA = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bSW = runnable;
        this.qjC = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bSW.run();
            c(this.qjC.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.qjB.getAndSet(qjD);
        if (andSet != null && andSet != qjD) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.qjA.getAndSet(qjD);
        if (andSet2 != null && andSet2 != qjD) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qjB.get() == qjD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qjB.get();
            if (future2 == qjD) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qjB.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qjA.get();
            if (future2 == qjD) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qjA.compareAndSet(future2, future));
    }
}
