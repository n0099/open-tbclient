package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> pPH = new FutureTask<>(Functions.pMp, null);
    final Runnable bKL;
    final ExecutorService pPG;
    Thread runner;
    final AtomicReference<Future<?>> pPF = new AtomicReference<>();
    final AtomicReference<Future<?>> pPE = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bKL = runnable;
        this.pPG = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bKL.run();
            b(this.pPG.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.pPF.getAndSet(pPH);
        if (andSet != null && andSet != pPH) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.pPE.getAndSet(pPH);
        if (andSet2 != null && andSet2 != pPH) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pPF.get() == pPH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pPF.get();
            if (future2 == pPH) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pPF.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pPE.get();
            if (future2 == pPH) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pPE.compareAndSet(future2, future));
    }
}
