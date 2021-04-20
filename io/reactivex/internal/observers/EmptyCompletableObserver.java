package io.reactivex.internal.observers;

import f.b.a0.a;
import f.b.t.b;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class EmptyCompletableObserver extends AtomicReference<b> implements f.b.b, b {
    public static final long serialVersionUID = -7545121636549663526L;

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.b
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // f.b.b
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        a.f(new OnErrorNotImplementedException(th));
    }

    @Override // f.b.b
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
