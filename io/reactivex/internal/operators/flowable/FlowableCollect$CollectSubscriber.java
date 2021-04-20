package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.w.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableCollect$CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements g<T> {
    public static final long serialVersionUID = -3589550218733891694L;
    public final b<? super U, ? super T> collector;
    public boolean done;
    public d s;
    public final U u;

    public FlowableCollect$CollectSubscriber(c<? super U> cVar, U u, b<? super U, ? super T> bVar) {
        super(cVar);
        this.collector = bVar;
        this.u = u;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        complete(this.u);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: U, ? super U */
    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            this.collector.a((U) this.u, t);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
