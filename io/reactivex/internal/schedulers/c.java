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
    static final FutureTask<Void> qll = new FutureTask<>(Functions.qhX, null);
    final Runnable bSW;
    final ExecutorService qlk;
    Thread runner;
    final AtomicReference<Future<?>> qlj = new AtomicReference<>();
    final AtomicReference<Future<?>> qli = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bSW = runnable;
        this.qlk = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bSW.run();
            c(this.qlk.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.qlj.getAndSet(qll);
        if (andSet != null && andSet != qll) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.qli.getAndSet(qll);
        if (andSet2 != null && andSet2 != qll) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qlj.get() == qll;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qlj.get();
            if (future2 == qll) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qlj.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qli.get();
            if (future2 == qll) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qli.compareAndSet(future2, future));
    }
}
