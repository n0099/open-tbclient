package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes7.dex */
public final class CompletableError extends Completable {
    public final Throwable error;

    public CompletableError(Throwable th) {
        this.error = th;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.error, completableObserver);
    }
}
