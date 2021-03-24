package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.t.b;
import f.a.x.e.a.m;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTimeout$TimeoutConsumer extends AtomicReference<d> implements g<Object>, b {
    public static final long serialVersionUID = 8708641127342403073L;
    public final long idx;
    public final m parent;

    public FlowableTimeout$TimeoutConsumer(long j, m mVar) {
        this.idx = j;
        this.parent = mVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(get());
    }

    @Override // g.d.c
    public void onComplete() {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.onTimeout(this.idx);
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.onTimeoutError(this.idx, th);
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        d dVar = get();
        if (dVar != SubscriptionHelper.CANCELLED) {
            dVar.cancel();
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.onTimeout(this.idx);
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
