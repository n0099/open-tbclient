package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.x.e.a.d;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
/* loaded from: classes7.dex */
public final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements g<R> {
    public static final long serialVersionUID = 897683679971470653L;
    public final d<R> parent;
    public long produced;

    public FlowableConcatMap$ConcatMapInner(d<R> dVar) {
        this.parent = dVar;
    }

    @Override // g.d.c
    public void onComplete() {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.parent.innerComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.parent.innerError(th);
    }

    @Override // g.d.c
    public void onNext(R r) {
        this.produced++;
        this.parent.innerNext(r);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(g.d.d dVar) {
        setSubscription(dVar);
    }
}
