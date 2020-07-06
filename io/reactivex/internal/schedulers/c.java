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
    static final FutureTask<Void> nMT = new FutureTask<>(Functions.nJB, null);
    final Runnable bmo;
    final ExecutorService nMS;
    Thread runner;
    final AtomicReference<Future<?>> nMR = new AtomicReference<>();
    final AtomicReference<Future<?>> nMQ = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bmo = runnable;
        this.nMS = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bmo.run();
            b(this.nMS.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nMR.getAndSet(nMT);
        if (andSet != null && andSet != nMT) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nMQ.getAndSet(nMT);
        if (andSet2 != null && andSet2 != nMT) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nMR.get() == nMT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nMR.get();
            if (future2 == nMT) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nMR.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nMQ.get();
            if (future2 == nMT) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nMQ.compareAndSet(future2, future));
    }
}
