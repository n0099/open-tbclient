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
    static final FutureTask<Void> nyJ = new FutureTask<>(Functions.nvu, null);
    final Runnable nyF;
    final ExecutorService nyI;
    Thread runner;
    final AtomicReference<Future<?>> nyH = new AtomicReference<>();
    final AtomicReference<Future<?>> nyG = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.nyF = runnable;
        this.nyI = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.nyF.run();
            b(this.nyI.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.e.a.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nyH.getAndSet(nyJ);
        if (andSet != null && andSet != nyJ) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nyG.getAndSet(nyJ);
        if (andSet2 != null && andSet2 != nyJ) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nyH.get() == nyJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nyH.get();
            if (future2 == nyJ) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nyH.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nyG.get();
            if (future2 == nyJ) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nyG.compareAndSet(future2, future));
    }
}
