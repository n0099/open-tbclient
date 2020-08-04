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
    static final FutureTask<Void> nVE = new FutureTask<>(Functions.nSl, null);
    final Runnable bmJ;
    final ExecutorService nVD;
    Thread runner;
    final AtomicReference<Future<?>> nVC = new AtomicReference<>();
    final AtomicReference<Future<?>> nVB = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bmJ = runnable;
        this.nVD = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bmJ.run();
            b(this.nVD.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nVC.getAndSet(nVE);
        if (andSet != null && andSet != nVE) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nVB.getAndSet(nVE);
        if (andSet2 != null && andSet2 != nVE) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nVC.get() == nVE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nVC.get();
            if (future2 == nVE) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nVC.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nVB.get();
            if (future2 == nVE) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nVB.compareAndSet(future2, future));
    }
}
