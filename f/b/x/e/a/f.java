package f.b.x.e.a;

import io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$State;
/* loaded from: classes7.dex */
public final class f<K, T> extends f.b.v.b<K, T> {

    /* renamed from: g  reason: collision with root package name */
    public final FlowableGroupBy$State<T, K> f68491g;

    public f(K k, FlowableGroupBy$State<T, K> flowableGroupBy$State) {
        super(k);
        this.f68491g = flowableGroupBy$State;
    }

    public static <T, K> f<K, T> d(K k, int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z) {
        return new f<>(k, new FlowableGroupBy$State(i, flowableGroupBy$GroupBySubscriber, k, z));
    }

    @Override // f.b.e
    public void c(g.d.c<? super T> cVar) {
        this.f68491g.subscribe(cVar);
    }

    public void onComplete() {
        this.f68491g.onComplete();
    }

    public void onError(Throwable th) {
        this.f68491g.onError(th);
    }

    public void onNext(T t) {
        this.f68491g.onNext(t);
    }
}
