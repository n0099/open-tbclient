package f.a.x.e.c;

import f.a.o;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver;
/* loaded from: classes7.dex */
public final class i<T> implements o<Object> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSampleWithObservable$SampleMainObserver<T> f67498e;

    public i(ObservableSampleWithObservable$SampleMainObserver<T> observableSampleWithObservable$SampleMainObserver) {
        this.f67498e = observableSampleWithObservable$SampleMainObserver;
    }

    @Override // f.a.o
    public void onComplete() {
        this.f67498e.complete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.f67498e.error(th);
    }

    @Override // f.a.o
    public void onNext(Object obj) {
        this.f67498e.run();
    }

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        this.f67498e.setOther(bVar);
    }
}
