package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.t.b;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableGroupJoin$LeftRightEndSubscriber extends AtomicReference<d> implements g<Object>, b {
    public static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final f.b.x.e.a.g parent;

    public FlowableGroupJoin$LeftRightEndSubscriber(f.b.x.e.a.g gVar, boolean z, int i) {
        this.parent = gVar;
        this.isLeft = z;
        this.index = i;
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
        this.parent.innerClose(this.isLeft, this);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.parent.innerCloseError(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            this.parent.innerClose(this.isLeft, this);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
