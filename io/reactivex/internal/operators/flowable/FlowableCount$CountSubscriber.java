package io.reactivex.internal.operators.flowable;

import f.a.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableCount$CountSubscriber extends DeferredScalarSubscription<Long> implements g<Object> {
    public static final long serialVersionUID = 4973004223787171406L;
    public long count;
    public d s;

    public FlowableCount$CountSubscriber(c<? super Long> cVar) {
        super(cVar);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        complete(Long.valueOf(this.count));
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        this.count++;
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
