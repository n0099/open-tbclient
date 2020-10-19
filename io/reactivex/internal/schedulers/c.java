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
    static final FutureTask<Void> oOQ = new FutureTask<>(Functions.oLy, null);
    final Runnable bCj;
    final ExecutorService oOP;
    Thread runner;
    final AtomicReference<Future<?>> oOO = new AtomicReference<>();
    final AtomicReference<Future<?>> oON = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bCj = runnable;
        this.oOP = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bCj.run();
            b(this.oOP.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.oOO.getAndSet(oOQ);
        if (andSet != null && andSet != oOQ) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.oON.getAndSet(oOQ);
        if (andSet2 != null && andSet2 != oOQ) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.oOO.get() == oOQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.oOO.get();
            if (future2 == oOQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.oOO.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.oON.get();
            if (future2 == oOQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.oON.compareAndSet(future2, future));
    }
}
