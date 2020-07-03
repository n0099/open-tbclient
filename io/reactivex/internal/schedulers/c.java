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
    static final FutureTask<Void> nMQ = new FutureTask<>(Functions.nJy, null);
    final Runnable bmo;
    final ExecutorService nMP;
    Thread runner;
    final AtomicReference<Future<?>> nMO = new AtomicReference<>();
    final AtomicReference<Future<?>> nMN = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bmo = runnable;
        this.nMP = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bmo.run();
            b(this.nMP.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nMO.getAndSet(nMQ);
        if (andSet != null && andSet != nMQ) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nMN.getAndSet(nMQ);
        if (andSet2 != null && andSet2 != nMQ) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nMO.get() == nMQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nMO.get();
            if (future2 == nMQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nMO.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nMN.get();
            if (future2 == nMQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nMN.compareAndSet(future2, future));
    }
}
