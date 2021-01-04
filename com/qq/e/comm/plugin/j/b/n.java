package com.qq.e.comm.plugin.j.b;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
class n<T> implements Future<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<T> f12476a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Callable<T> callable) {
        this.f12476a = callable;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException {
        try {
            return this.f12476a.call();
        } catch (Exception e) {
            throw new ExecutionException(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException {
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
