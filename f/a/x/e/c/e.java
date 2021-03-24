package f.a.x.e.c;

import f.a.o;
import io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver;
import io.reactivex.internal.operators.observable.ObservableGroupBy$State;
/* loaded from: classes7.dex */
public final class e<K, T> extends f.a.y.b<K, T> {

    /* renamed from: f  reason: collision with root package name */
    public final ObservableGroupBy$State<T, K> f67493f;

    public e(K k, ObservableGroupBy$State<T, K> observableGroupBy$State) {
        super(k);
        this.f67493f = observableGroupBy$State;
    }

    public static <T, K> e<K, T> c(K k, int i, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, boolean z) {
        return new e<>(k, new ObservableGroupBy$State(i, observableGroupBy$GroupByObserver, k, z));
    }

    @Override // f.a.l
    public void b(o<? super T> oVar) {
        this.f67493f.subscribe(oVar);
    }

    public void onComplete() {
        this.f67493f.onComplete();
    }

    public void onError(Throwable th) {
        this.f67493f.onError(th);
    }

    public void onNext(T t) {
        this.f67493f.onNext(t);
    }
}
