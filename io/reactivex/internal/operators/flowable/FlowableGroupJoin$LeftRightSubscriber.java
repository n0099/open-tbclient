package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.t.b;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableGroupJoin$LeftRightSubscriber extends AtomicReference<d> implements g<Object>, b {
    public static final long serialVersionUID = 1883890389173668373L;
    public final boolean isLeft;
    public final f.b.x.e.a.g parent;

    public FlowableGroupJoin$LeftRightSubscriber(f.b.x.e.a.g gVar, boolean z) {
        this.parent = gVar;
        this.isLeft = z;
    }

    @Override // f.b.t.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(get());
    }

    @Override // g.d.c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.innerError(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        this.parent.innerValue(this.isLeft, obj);
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
