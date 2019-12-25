package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
    private static final long serialVersionUID = -8612022020200669122L;
    final u<? super T> actual;
    final AtomicReference<io.reactivex.disposables.b> subscription = new AtomicReference<>();

    public ObserverResourceWrapper(u<? super T> uVar) {
        this.actual = uVar;
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.setOnce(this.subscription, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // io.reactivex.u
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.subscription.get() == DisposableHelper.DISPOSED;
    }

    public void setResource(io.reactivex.disposables.b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
