package com.facebook.common.b;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
/* loaded from: classes19.dex */
public class f<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    private final Handler mHandler;
    private final FutureTask<V> pbM;

    public f(Handler handler, Callable<V> callable) {
        this.mHandler = handler;
        this.pbM = new FutureTask<>(callable);
    }

    public f(Handler handler, Runnable runnable, @Nullable V v) {
        this.mHandler = handler;
        this.pbM = new FutureTask<>(runnable, v);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Delayed delayed) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.pbM.run();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.pbM.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.pbM.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.pbM.isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.pbM.get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.pbM.get(j, timeUnit);
    }
}
