package io.reactivex.internal.operators.flowable;

import f.b.g;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableCombineLatest$CombineLatestInnerSubscriber<T> extends AtomicReference<d> implements g<T> {
    public static final long serialVersionUID = -8730235182291002949L;
    public final int index;
    public final int limit;
    public final FlowableCombineLatest$CombineLatestCoordinator<T, ?> parent;
    public final int prefetch;
    public int produced;

    public FlowableCombineLatest$CombineLatestInnerSubscriber(FlowableCombineLatest$CombineLatestCoordinator<T, ?> flowableCombineLatest$CombineLatestCoordinator, int i, int i2) {
        this.parent = flowableCombineLatest$CombineLatestCoordinator;
        this.index = i;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // g.d.c
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.innerError(this.index, th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.parent.innerValue(this.index, t);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(this.prefetch);
        }
    }

    public void requestOne() {
        int i = this.produced + 1;
        if (i == this.limit) {
            this.produced = 0;
            get().request(i);
            return;
        }
        this.produced = i;
    }
}
