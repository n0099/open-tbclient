package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<b> implements o<T>, b {
    public static final long serialVersionUID = 8094547886072529208L;
    public final o<? super T> actual;
    public final AtomicReference<b> s = new AtomicReference<>();

    public ObservableSubscribeOn$SubscribeOnObserver(o<? super T> oVar) {
        this.actual = oVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this.s);
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.o
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.s, bVar);
    }

    public void setDisposable(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
