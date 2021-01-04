package com.facebook.common.b;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class c extends AbstractExecutorService implements b {
    private final Handler mHandler;

    public c(Handler handler) {
        this.mHandler = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    /* renamed from: a */
    public <T> d<T> newTaskFor(Runnable runnable, T t) {
        return new d<>(this.mHandler, runnable, t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    /* renamed from: b */
    public <T> d<T> newTaskFor(Callable<T> callable) {
        return new d<>(this.mHandler, callable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: A */
    public ScheduledFuture<?> submit(Runnable runnable) {
        return submit(runnable, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: b */
    public <T> ScheduledFuture<T> submit(Runnable runnable, @Nullable T t) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        d<T> newTaskFor = newTaskFor(runnable, t);
        execute(newTaskFor);
        return newTaskFor;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: c */
    public <T> ScheduledFuture<T> submit(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        d<T> newTaskFor = newTaskFor(callable);
        execute(newTaskFor);
        return newTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        d newTaskFor = newTaskFor(runnable, null);
        this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j));
        return newTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        d newTaskFor = newTaskFor(callable);
        this.mHandler.postDelayed(newTaskFor, timeUnit.toMillis(j));
        return newTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public boolean etP() {
        return Thread.currentThread() == this.mHandler.getLooper().getThread();
    }
}
