package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class d<T> implements y<T> {
    final y<? super T> actual;
    final AtomicReference<io.reactivex.disposables.b> nmM;

    public d(AtomicReference<io.reactivex.disposables.b> atomicReference, y<? super T> yVar) {
        this.nmM = atomicReference;
        this.actual = yVar;
    }

    @Override // io.reactivex.y
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.replace(this.nmM, bVar);
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
