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
    static final FutureTask<Void> mUN = new FutureTask<>(Functions.mRo, null);
    final Runnable aZG;
    final ExecutorService mUM;
    Thread runner;
    final AtomicReference<Future<?>> mUL = new AtomicReference<>();
    final AtomicReference<Future<?>> mUK = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.aZG = runnable;
        this.mUM = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.aZG.run();
            b(this.mUM.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.mUL.getAndSet(mUN);
        if (andSet != null && andSet != mUN) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.mUK.getAndSet(mUN);
        if (andSet2 != null && andSet2 != mUN) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.mUL.get() == mUN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.mUL.get();
            if (future2 == mUN) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.mUL.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.mUK.get();
            if (future2 == mUN) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.mUK.compareAndSet(future2, future));
    }
}
