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
    static final FutureTask<Void> opB = new FutureTask<>(Functions.omg, null);
    final Runnable bso;
    final ExecutorService opA;
    Thread runner;
    final AtomicReference<Future<?>> opz = new AtomicReference<>();
    final AtomicReference<Future<?>> opy = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bso = runnable;
        this.opA = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bso.run();
            b(this.opA.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.opz.getAndSet(opB);
        if (andSet != null && andSet != opB) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.opy.getAndSet(opB);
        if (andSet2 != null && andSet2 != opB) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.opz.get() == opB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.opz.get();
            if (future2 == opB) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.opz.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.opy.get();
            if (future2 == opB) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.opy.compareAndSet(future2, future));
    }
}
