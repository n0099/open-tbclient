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
/* loaded from: classes12.dex */
public class f<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    private final FutureTask<V> lHz;
    private final Handler mHandler;

    public f(Handler handler, Callable<V> callable) {
        this.mHandler = handler;
        this.lHz = new FutureTask<>(callable);
    }

    public f(Handler handler, Runnable runnable, @Nullable V v) {
        this.mHandler = handler;
        this.lHz = new FutureTask<>(runnable, v);
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
        this.lHz.run();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.lHz.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.lHz.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.lHz.isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.lHz.get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.lHz.get(j, timeUnit);
    }
}
