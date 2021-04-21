package f.b.x.e.a;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
/* loaded from: classes7.dex */
public final class n<T> implements f.b.g<T> {

    /* renamed from: e  reason: collision with root package name */
    public final g.d.c<? super T> f68641e;

    /* renamed from: f  reason: collision with root package name */
    public final SubscriptionArbiter f68642f;

    public n(g.d.c<? super T> cVar, SubscriptionArbiter subscriptionArbiter) {
        this.f68641e = cVar;
        this.f68642f = subscriptionArbiter;
    }

    @Override // g.d.c
    public void onComplete() {
        this.f68641e.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.f68641e.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.f68641e.onNext(t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(g.d.d dVar) {
        this.f68642f.setSubscription(dVar);
    }
}
