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
    static final FutureTask<Void> opT = new FutureTask<>(Functions.omy, null);
    final Runnable bsr;
    final ExecutorService opS;
    Thread runner;
    final AtomicReference<Future<?>> opR = new AtomicReference<>();
    final AtomicReference<Future<?>> opQ = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bsr = runnable;
        this.opS = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bsr.run();
            b(this.opS.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.opR.getAndSet(opT);
        if (andSet != null && andSet != opT) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.opQ.getAndSet(opT);
        if (andSet2 != null && andSet2 != opT) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.opR.get() == opT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.opR.get();
            if (future2 == opT) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.opR.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.opQ.get();
            if (future2 == opT) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.opQ.compareAndSet(future2, future));
    }
}
