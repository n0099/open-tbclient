package io.reactivex.internal.operators.single;

import f.b.g;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleTakeUntil$TakeUntilOtherSubscriber extends AtomicReference<d> implements g<Object> {
    public static final long serialVersionUID = 5170026210238877381L;
    public final SingleTakeUntil$TakeUntilMainObserver<?> parent;

    public SingleTakeUntil$TakeUntilOtherSubscriber(SingleTakeUntil$TakeUntilMainObserver<?> singleTakeUntil$TakeUntilMainObserver) {
        this.parent = singleTakeUntil$TakeUntilMainObserver;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // g.d.c
    public void onComplete() {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.otherError(new CancellationException());
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.otherError(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            this.parent.otherError(new CancellationException());
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
