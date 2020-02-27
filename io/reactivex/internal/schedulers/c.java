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
    static final FutureTask<Void> nzl = new FutureTask<>(Functions.nvW, null);
    final Runnable nzh;
    final ExecutorService nzk;
    Thread runner;
    final AtomicReference<Future<?>> nzj = new AtomicReference<>();
    final AtomicReference<Future<?>> nzi = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.nzh = runnable;
        this.nzk = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.nzh.run();
            b(this.nzk.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.e.a.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nzj.getAndSet(nzl);
        if (andSet != null && andSet != nzl) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nzi.getAndSet(nzl);
        if (andSet2 != null && andSet2 != nzl) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nzj.get() == nzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nzj.get();
            if (future2 == nzl) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nzj.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nzi.get();
            if (future2 == nzl) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nzi.compareAndSet(future2, future));
    }
}
