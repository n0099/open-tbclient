package io.reactivex.internal.observers;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class EmptyCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, io.reactivex.disposables.b {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.c
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        io.reactivex.e.a.onError(new OnErrorNotImplementedException(th));
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public boolean hasCustomOnError() {
        return false;
    }
}
