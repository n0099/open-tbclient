package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> nBl = new FutureTask<>(Functions.nxW, null);
    final Runnable nBh;
    final ExecutorService nBk;
    Thread runner;
    final AtomicReference<Future<?>> nBj = new AtomicReference<>();
    final AtomicReference<Future<?>> nBi = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.nBh = runnable;
        this.nBk = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.nBh.run();
            b(this.nBk.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.e.a.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nBj.getAndSet(nBl);
        if (andSet != null && andSet != nBl) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nBi.getAndSet(nBl);
        if (andSet2 != null && andSet2 != nBl) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nBj.get() == nBl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nBj.get();
            if (future2 == nBl) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nBj.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nBi.get();
            if (future2 == nBl) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nBi.compareAndSet(future2, future));
    }
}
