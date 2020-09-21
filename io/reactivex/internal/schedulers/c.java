package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> ozB = new FutureTask<>(Functions.owj, null);
    final Runnable bvG;
    final ExecutorService ozA;
    Thread runner;
    final AtomicReference<Future<?>> ozz = new AtomicReference<>();
    final AtomicReference<Future<?>> ozy = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bvG = runnable;
        this.ozA = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bvG.run();
            b(this.ozA.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.ozz.getAndSet(ozB);
        if (andSet != null && andSet != ozB) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.ozy.getAndSet(ozB);
        if (andSet2 != null && andSet2 != ozB) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.ozz.get() == ozB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.ozz.get();
            if (future2 == ozB) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.ozz.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.ozy.get();
            if (future2 == ozB) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.ozy.compareAndSet(future2, future));
    }
}
