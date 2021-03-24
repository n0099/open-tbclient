package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
/* loaded from: classes7.dex */
public final class ObservableSampleWithObservable$SampleMainNoLast<T> extends ObservableSampleWithObservable$SampleMainObserver<T> {
    public static final long serialVersionUID = -3029755663834015785L;

    public ObservableSampleWithObservable$SampleMainNoLast(o<? super T> oVar, n<?> nVar) {
        super(oVar, nVar);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void completeMain() {
        this.actual.onComplete();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void completeOther() {
        this.actual.onComplete();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void run() {
        emit();
    }
}
