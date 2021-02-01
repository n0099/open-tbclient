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
    static final FutureTask<Void> qqO = new FutureTask<>(Functions.qnB, null);
    final Runnable bSa;
    final ExecutorService qqN;
    Thread runner;
    final AtomicReference<Future<?>> qqM = new AtomicReference<>();
    final AtomicReference<Future<?>> qqL = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bSa = runnable;
        this.qqN = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bSa.run();
            c(this.qqN.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.qqM.getAndSet(qqO);
        if (andSet != null && andSet != qqO) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.qqL.getAndSet(qqO);
        if (andSet2 != null && andSet2 != qqO) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.qqM.get() == qqO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qqM.get();
            if (future2 == qqO) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qqM.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.qqL.get();
            if (future2 == qqO) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.qqL.compareAndSet(future2, future));
    }
}
