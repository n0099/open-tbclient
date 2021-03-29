package f.a.x.e.c;

import f.a.o;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver;
/* loaded from: classes7.dex */
public final class i<T> implements o<Object> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSampleWithObservable$SampleMainObserver<T> f67503e;

    public i(ObservableSampleWithObservable$SampleMainObserver<T> observableSampleWithObservable$SampleMainObserver) {
        this.f67503e = observableSampleWithObservable$SampleMainObserver;
    }

    @Override // f.a.o
    public void onComplete() {
        this.f67503e.complete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.f67503e.error(th);
    }

    @Override // f.a.o
    public void onNext(Object obj) {
        this.f67503e.run();
    }

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        this.f67503e.setOther(bVar);
    }
}
