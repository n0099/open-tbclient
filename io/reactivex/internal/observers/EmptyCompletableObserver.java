package io.reactivex.internal.observers;

import f.a.a0.a;
import f.a.t.b;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class EmptyCompletableObserver extends AtomicReference<b> implements f.a.b, b {
    public static final long serialVersionUID = -7545121636549663526L;

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.a.b
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        a.f(new OnErrorNotImplementedException(th));
    }

    @Override // f.a.b
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
