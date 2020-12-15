package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> pIa = new FutureTask<>(Functions.pEN, null);
    final Runnable bOi;
    final ExecutorService pHZ;
    Thread runner;
    final AtomicReference<Future<?>> pHY = new AtomicReference<>();
    final AtomicReference<Future<?>> pHX = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bOi = runnable;
        this.pHZ = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bOi.run();
            b(this.pHZ.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.pHY.getAndSet(pIa);
        if (andSet != null && andSet != pIa) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.pHX.getAndSet(pIa);
        if (andSet2 != null && andSet2 != pIa) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pHY.get() == pIa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pHY.get();
            if (future2 == pIa) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pHY.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pHX.get();
            if (future2 == pIa) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pHX.compareAndSet(future2, future));
    }
}
