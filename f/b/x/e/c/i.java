package f.b.x.e.c;

import f.b.o;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver;
/* loaded from: classes7.dex */
public final class i<T> implements o<Object> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSampleWithObservable$SampleMainObserver<T> f68509e;

    public i(ObservableSampleWithObservable$SampleMainObserver<T> observableSampleWithObservable$SampleMainObserver) {
        this.f68509e = observableSampleWithObservable$SampleMainObserver;
    }

    @Override // f.b.o
    public void onComplete() {
        this.f68509e.complete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.f68509e.error(th);
    }

    @Override // f.b.o
    public void onNext(Object obj) {
        this.f68509e.run();
    }

    @Override // f.b.o
    public void onSubscribe(f.b.t.b bVar) {
        this.f68509e.setOther(bVar);
    }
}
