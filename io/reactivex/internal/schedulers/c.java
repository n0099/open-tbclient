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
    static final FutureTask<Void> mUQ = new FutureTask<>(Functions.mRr, null);
    final Runnable aZL;
    final ExecutorService mUP;
    Thread runner;
    final AtomicReference<Future<?>> mUO = new AtomicReference<>();
    final AtomicReference<Future<?>> mUN = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.aZL = runnable;
        this.mUP = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.runner = Thread.currentThread();
            this.aZL.run();
            b(this.mUP.submit(this));
            return null;
        } finally {
            this.runner = null;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.mUO.getAndSet(mUQ);
        if (andSet != null && andSet != mUQ) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.mUN.getAndSet(mUQ);
        if (andSet2 != null && andSet2 != mUQ) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.mUO.get() == mUQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.mUO.get();
            if (future2 == mUQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.mUO.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.mUN.get();
            if (future2 == mUQ) {
                future.cancel(this.runner != Thread.currentThread());
            }
        } while (!this.mUN.compareAndSet(future2, future));
    }
}
