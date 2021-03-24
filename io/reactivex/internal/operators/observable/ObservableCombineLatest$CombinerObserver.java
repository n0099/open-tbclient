package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableCombineLatest$CombinerObserver<T, R> extends AtomicReference<b> implements o<T> {
    public static final long serialVersionUID = -4823716997131257941L;
    public final int index;
    public final ObservableCombineLatest$LatestCoordinator<T, R> parent;

    public ObservableCombineLatest$CombinerObserver(ObservableCombineLatest$LatestCoordinator<T, R> observableCombineLatest$LatestCoordinator, int i) {
        this.parent = observableCombineLatest$LatestCoordinator;
        this.index = i;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.o
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.parent.innerError(this.index, th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.parent.innerNext(this.index, t);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
