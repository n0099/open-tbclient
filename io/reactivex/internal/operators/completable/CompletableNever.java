package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes7.dex */
public final class CompletableNever extends Completable {
    public static final Completable INSTANCE = new CompletableNever();

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
