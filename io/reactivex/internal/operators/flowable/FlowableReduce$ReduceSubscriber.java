package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.w.c;
import g.d.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableReduce$ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements g<T> {
    public static final long serialVersionUID = -4663883003264602070L;
    public final c<T, T, T> reducer;
    public d s;

    public FlowableReduce$ReduceSubscriber(g.d.c<? super T> cVar, c<T, T, T> cVar2) {
        super(cVar);
        this.reducer = cVar2;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
        this.s = SubscriptionHelper.CANCELLED;
    }

    @Override // g.d.c
    public void onComplete() {
        d dVar = this.s;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar == subscriptionHelper) {
            return;
        }
        this.s = subscriptionHelper;
        T t = this.value;
        if (t != null) {
            complete(t);
        } else {
            this.actual.onComplete();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        d dVar = this.s;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar == subscriptionHelper) {
            a.f(th);
            return;
        }
        this.s = subscriptionHelper;
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.s == SubscriptionHelper.CANCELLED) {
            return;
        }
        T t2 = this.value;
        if (t2 == null) {
            this.value = t;
            return;
        }
        try {
            T apply = this.reducer.apply(t2, t);
            f.a.x.b.a.b(apply, "The reducer returned a null value");
            this.value = apply;
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
