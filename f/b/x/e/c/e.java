package f.b.x.e.c;

import f.b.o;
import io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver;
import io.reactivex.internal.operators.observable.ObservableGroupBy$State;
/* loaded from: classes7.dex */
public final class e<K, T> extends f.b.y.b<K, T> {

    /* renamed from: f  reason: collision with root package name */
    public final ObservableGroupBy$State<T, K> f68504f;

    public e(K k, ObservableGroupBy$State<T, K> observableGroupBy$State) {
        super(k);
        this.f68504f = observableGroupBy$State;
    }

    public static <T, K> e<K, T> c(K k, int i, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, boolean z) {
        return new e<>(k, new ObservableGroupBy$State(i, observableGroupBy$GroupByObserver, k, z));
    }

    @Override // f.b.l
    public void b(o<? super T> oVar) {
        this.f68504f.subscribe(oVar);
    }

    public void onComplete() {
        this.f68504f.onComplete();
    }

    public void onError(Throwable th) {
        this.f68504f.onError(th);
    }

    public void onNext(T t) {
        this.f68504f.onNext(t);
    }
}
