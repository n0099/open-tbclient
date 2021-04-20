package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
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

    @Override // f.b.o
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.parent.innerError(this.index, th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.parent.innerNext(this.index, t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
