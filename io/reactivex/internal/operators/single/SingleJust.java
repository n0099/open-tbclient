package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;
/* loaded from: classes7.dex */
public final class SingleJust<T> extends Single<T> {
    public final T value;

    public SingleJust(T t) {
        this.value = t;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: T, ? super T */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.disposed());
        singleObserver.onSuccess((T) this.value);
    }
}
