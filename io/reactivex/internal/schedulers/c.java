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
    static final FutureTask<Void> nzn = new FutureTask<>(Functions.nvY, null);
    final Runnable nzj;
    final ExecutorService nzm;
    Thread runner;
    final AtomicReference<Future<?>> nzl = new AtomicReference<>();
    final AtomicReference<Future<?>> nzk = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.nzj = runnable;
        this.nzm = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.nzj.run();
            b(this.nzm.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.e.a.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nzl.getAndSet(nzn);
        if (andSet != null && andSet != nzn) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nzk.getAndSet(nzn);
        if (andSet2 != null && andSet2 != nzn) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nzl.get() == nzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nzl.get();
            if (future2 == nzn) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nzl.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nzk.get();
            if (future2 == nzn) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nzk.compareAndSet(future2, future));
    }
}
