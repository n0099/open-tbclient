package io.reactivex.internal.operators.flowable;

import f.b.g;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableWithLatestFromMany$WithLatestInnerSubscriber extends AtomicReference<d> implements g<Object> {
    public static final long serialVersionUID = 3256684027868224024L;
    public boolean hasValue;
    public final int index;
    public final FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> parent;

    public FlowableWithLatestFromMany$WithLatestInnerSubscriber(FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> flowableWithLatestFromMany$WithLatestFromSubscriber, int i) {
        this.parent = flowableWithLatestFromMany$WithLatestFromSubscriber;
        this.index = i;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // g.d.c
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.innerError(this.index, th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        if (!this.hasValue) {
            this.hasValue = true;
        }
        this.parent.innerNext(this.index, obj);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
