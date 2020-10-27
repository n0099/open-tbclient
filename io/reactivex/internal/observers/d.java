package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class d<T> implements y<T> {
    final y<? super T> actual;
    final AtomicReference<io.reactivex.disposables.b> pDi;

    public d(AtomicReference<io.reactivex.disposables.b> atomicReference, y<? super T> yVar) {
        this.pDi = atomicReference;
        this.actual = yVar;
    }

    @Override // io.reactivex.y
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.replace(this.pDi, bVar);
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
