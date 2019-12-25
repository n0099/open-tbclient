package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c implements io.reactivex.disposables.b, Callable<Void> {
    static final FutureTask<Void> mWv = new FutureTask<>(Functions.mTh, null);
    final Runnable mWr;
    final ExecutorService mWu;
    Thread runner;
    final AtomicReference<Future<?>> mWt = new AtomicReference<>();
    final AtomicReference<Future<?>> mWs = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.mWr = runnable;
        this.mWu = executorService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.mWr.run();
            b(this.mWu.submit(this));
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            io.reactivex.d.a.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.mWt.getAndSet(mWv);
        if (andSet != null && andSet != mWv) {
            andSet.cancel(this.runner != Thread.currentThread());
        }
        Future<?> andSet2 = this.mWs.getAndSet(mWv);
        if (andSet2 != null && andSet2 != mWv) {
            andSet2.cancel(this.runner != Thread.currentThread());
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.mWt.get() == mWv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.mWt.get();
            if (future2 == mWv) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.mWt.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.mWs.get();
            if (future2 == mWv) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!this.mWs.compareAndSet(future2, future));
    }
}
