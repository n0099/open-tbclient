package io.reactivex.internal.observers;

import f.b.r;
import f.b.t.b;
import f.b.u.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<b> implements r<T>, b {
    public static final long serialVersionUID = 4943102778943297569L;
    public final f.b.w.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(f.b.w.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.a(null, th);
        } catch (Throwable th2) {
            a.a(th2);
            f.b.a0.a.f(new CompositeException(th, th2));
        }
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.a(t, null);
        } catch (Throwable th) {
            a.a(th);
            f.b.a0.a.f(th);
        }
    }
}
