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
    static final FutureTask<Void> pHY = new FutureTask<>(Functions.pEL, null);
    final Runnable bOi;
    final ExecutorService pHX;
    Thread runner;
    final AtomicReference<Future<?>> pHW = new AtomicReference<>();
    final AtomicReference<Future<?>> pHV = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bOi = runnable;
        this.pHX = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bOi.run();
            b(this.pHX.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.pHW.getAndSet(pHY);
        if (andSet != null && andSet != pHY) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.pHV.getAndSet(pHY);
        if (andSet2 != null && andSet2 != pHY) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pHW.get() == pHY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pHW.get();
            if (future2 == pHY) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pHW.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pHV.get();
            if (future2 == pHY) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pHV.compareAndSet(future2, future));
    }
}
