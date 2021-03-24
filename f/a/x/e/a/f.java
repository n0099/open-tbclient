package f.a.x.e.a;

import io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$State;
/* loaded from: classes7.dex */
public final class f<K, T> extends f.a.v.b<K, T> {

    /* renamed from: g  reason: collision with root package name */
    public final FlowableGroupBy$State<T, K> f67480g;

    public f(K k, FlowableGroupBy$State<T, K> flowableGroupBy$State) {
        super(k);
        this.f67480g = flowableGroupBy$State;
    }

    public static <T, K> f<K, T> d(K k, int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z) {
        return new f<>(k, new FlowableGroupBy$State(i, flowableGroupBy$GroupBySubscriber, k, z));
    }

    @Override // f.a.e
    public void c(g.d.c<? super T> cVar) {
        this.f67480g.subscribe(cVar);
    }

    public void onComplete() {
        this.f67480g.onComplete();
    }

    public void onError(Throwable th) {
        this.f67480g.onError(th);
    }

    public void onNext(T t) {
        this.f67480g.onNext(t);
    }
}
