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
    static final FutureTask<Void> pGn = new FutureTask<>(Functions.pCV, null);
    final Runnable bFf;
    final ExecutorService pGm;
    Thread runner;
    final AtomicReference<Future<?>> pGl = new AtomicReference<>();
    final AtomicReference<Future<?>> pGk = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bFf = runnable;
        this.pGm = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bFf.run();
            b(this.pGm.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.pGl.getAndSet(pGn);
        if (andSet != null && andSet != pGn) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.pGk.getAndSet(pGn);
        if (andSet2 != null && andSet2 != pGn) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.pGl.get() == pGn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pGl.get();
            if (future2 == pGn) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pGl.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.pGk.get();
            if (future2 == pGn) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.pGk.compareAndSet(future2, future));
    }
}
