package io.reactivex.internal.schedulers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
final class b implements Future<Object> {
    final io.reactivex.disposables.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(io.reactivex.disposables.b bVar) {
        this.d = bVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.d.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
