package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class d<T> implements y<T> {
    final y<? super T> actual;
    final AtomicReference<io.reactivex.disposables.b> nnW;

    public d(AtomicReference<io.reactivex.disposables.b> atomicReference, y<? super T> yVar) {
        this.nnW = atomicReference;
        this.actual = yVar;
    }

    @Override // io.reactivex.y
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.replace(this.nnW, bVar);
    }

    @Override // io.reactivex.y
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }

    @Override // io.reactivex.y
    public void onError(Throwable th) {
        this.actual.onError(th);
    }
}
