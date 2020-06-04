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
    static final FutureTask<Void> nrd = new FutureTask<>(Functions.nnJ, null);
    final Runnable bhi;
    final ExecutorService nrc;
    Thread runner;
    final AtomicReference<Future<?>> nrb = new AtomicReference<>();
    final AtomicReference<Future<?>> nra = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bhi = runnable;
        this.nrc = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bhi.run();
            b(this.nrc.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nrb.getAndSet(nrd);
        if (andSet != null && andSet != nrd) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nra.getAndSet(nrd);
        if (andSet2 != null && andSet2 != nrd) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nrb.get() == nrd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nrb.get();
            if (future2 == nrd) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nrb.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nra.get();
            if (future2 == nrd) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nra.compareAndSet(future2, future));
    }
}
