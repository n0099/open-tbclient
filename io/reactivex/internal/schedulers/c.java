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
    static final FutureTask<Void> pRk = new FutureTask<>(Functions.pNS, null);
    final Runnable bJa;
    final ExecutorService pRj;
    Thread runner;
    final AtomicReference<Future<?>> pRi = new AtomicReference<>();
    final AtomicReference<Future<?>> pRh = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bJa = runnable;
        this.pRj = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bJa.run();
            b(this.pRj.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.pRi.getAndSet(pRk);
        if (andSet != null && andSet != pRk) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.pRh.getAndSet(pRk);
        if (andSet2 != null && andSet2 != pRk) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pRi.get() == pRk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pRi.get();
            if (future2 == pRk) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pRi.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pRh.get();
            if (future2 == pRk) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pRh.compareAndSet(future2, future));
    }
}
