package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T> {
    private static final long serialVersionUID = 4943102778943297569L;
    final io.reactivex.c.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(io.reactivex.c.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    @Override // io.reactivex.y
    public void onError(Throwable th) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.j(null, th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.I(th2);
            io.reactivex.e.a.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.y
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.y
    public void onSuccess(T t) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.j(t, null);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.I(th);
            io.reactivex.e.a.onError(th);
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }
}
