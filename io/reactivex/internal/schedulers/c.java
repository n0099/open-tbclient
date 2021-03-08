package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> qrQ = new FutureTask<>(Functions.qoD, null);
    final Runnable bTA;
    final ExecutorService qrP;
    Thread runner;
    final AtomicReference<Future<?>> qrO = new AtomicReference<>();
    final AtomicReference<Future<?>> qrN = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bTA = runnable;
        this.qrP = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bTA.run();
            c(this.qrP.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.qrO.getAndSet(qrQ);
        if (andSet != null && andSet != qrQ) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.qrN.getAndSet(qrQ);
        if (andSet2 != null && andSet2 != qrQ) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qrO.get() == qrQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qrO.get();
            if (future2 == qrQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qrO.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qrN.get();
            if (future2 == qrQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qrN.compareAndSet(future2, future));
    }
}
