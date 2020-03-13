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
    static final FutureTask<Void> nzy = new FutureTask<>(Functions.nwj, null);
    final Runnable nzu;
    final ExecutorService nzx;
    Thread runner;
    final AtomicReference<Future<?>> nzw = new AtomicReference<>();
    final AtomicReference<Future<?>> nzv = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.nzu = runnable;
        this.nzx = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.nzu.run();
            b(this.nzx.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.e.a.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nzw.getAndSet(nzy);
        if (andSet != null && andSet != nzy) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nzv.getAndSet(nzy);
        if (andSet2 != null && andSet2 != nzy) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nzw.get() == nzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nzw.get();
            if (future2 == nzy) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nzw.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nzv.get();
            if (future2 == nzy) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.nzv.compareAndSet(future2, future));
    }
}
