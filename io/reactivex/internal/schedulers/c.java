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
    static final FutureTask<Void> qro = new FutureTask<>(Functions.qob, null);
    final Runnable bSa;
    final ExecutorService qrn;
    Thread runner;
    final AtomicReference<Future<?>> qrm = new AtomicReference<>();
    final AtomicReference<Future<?>> qrl = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bSa = runnable;
        this.qrn = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bSa.run();
            c(this.qrn.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.qrm.getAndSet(qro);
        if (andSet != null && andSet != qro) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.qrl.getAndSet(qro);
        if (andSet2 != null && andSet2 != qro) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qrm.get() == qro;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qrm.get();
            if (future2 == qro) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qrm.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qrl.get();
            if (future2 == qro) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qrl.compareAndSet(future2, future));
    }
}
