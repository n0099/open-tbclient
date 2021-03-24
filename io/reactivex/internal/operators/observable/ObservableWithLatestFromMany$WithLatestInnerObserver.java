package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableWithLatestFromMany$WithLatestInnerObserver extends AtomicReference<b> implements o<Object> {
    public static final long serialVersionUID = 3256684027868224024L;
    public boolean hasValue;
    public final int index;
    public final ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> parent;

    public ObservableWithLatestFromMany$WithLatestInnerObserver(ObservableWithLatestFromMany$WithLatestFromObserver<?, ?> observableWithLatestFromMany$WithLatestFromObserver, int i) {
        this.parent = observableWithLatestFromMany$WithLatestFromObserver;
        this.index = i;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.o
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.parent.innerError(this.index, th);
    }

    @Override // f.a.o
    public void onNext(Object obj) {
        if (!this.hasValue) {
            this.hasValue = true;
        }
        this.parent.innerNext(this.index, obj);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
