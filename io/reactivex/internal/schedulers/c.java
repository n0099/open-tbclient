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
    static final FutureTask<Void> npT = new FutureTask<>(Functions.nmz, null);
    final Runnable bhi;
    final ExecutorService npS;
    Thread runner;
    final AtomicReference<Future<?>> npR = new AtomicReference<>();
    final AtomicReference<Future<?>> npQ = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bhi = runnable;
        this.npS = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bhi.run();
            b(this.npS.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.npR.getAndSet(npT);
        if (andSet != null && andSet != npT) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.npQ.getAndSet(npT);
        if (andSet2 != null && andSet2 != npT) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.npR.get() == npT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.npR.get();
            if (future2 == npT) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.npR.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.npQ.get();
            if (future2 == npT) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.npQ.compareAndSet(future2, future));
    }
}
