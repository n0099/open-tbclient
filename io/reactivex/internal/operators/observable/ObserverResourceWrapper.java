package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<b> implements o<T>, b {
    public static final long serialVersionUID = -8612022020200669122L;
    public final o<? super T> actual;
    public final AtomicReference<b> subscription = new AtomicReference<>();

    public ObserverResourceWrapper(o<? super T> oVar) {
        this.actual = oVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.subscription.get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.o
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this.subscription, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
