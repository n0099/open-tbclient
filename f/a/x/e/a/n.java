package f.a.x.e.a;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
/* loaded from: classes7.dex */
public final class n<T> implements f.a.g<T> {

    /* renamed from: e  reason: collision with root package name */
    public final g.d.c<? super T> f67483e;

    /* renamed from: f  reason: collision with root package name */
    public final SubscriptionArbiter f67484f;

    public n(g.d.c<? super T> cVar, SubscriptionArbiter subscriptionArbiter) {
        this.f67483e = cVar;
        this.f67484f = subscriptionArbiter;
    }

    @Override // g.d.c
    public void onComplete() {
        this.f67483e.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.f67483e.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.f67483e.onNext(t);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(g.d.d dVar) {
        this.f67484f.setSubscription(dVar);
    }
}
