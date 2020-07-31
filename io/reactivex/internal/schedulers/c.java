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
    static final FutureTask<Void> nVC = new FutureTask<>(Functions.nSj, null);
    final Runnable bmJ;
    final ExecutorService nVB;
    Thread runner;
    final AtomicReference<Future<?>> nVA = new AtomicReference<>();
    final AtomicReference<Future<?>> nVz = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.bmJ = runnable;
        this.nVB = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.bmJ.run();
            b(this.nVB.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.nVA.getAndSet(nVC);
        if (andSet != null && andSet != nVC) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.nVz.getAndSet(nVC);
        if (andSet2 != null && andSet2 != nVC) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.nVA.get() == nVC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nVA.get();
            if (future2 == nVC) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nVA.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.nVz.get();
            if (future2 == nVC) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.nVz.compareAndSet(future2, future));
    }
}
