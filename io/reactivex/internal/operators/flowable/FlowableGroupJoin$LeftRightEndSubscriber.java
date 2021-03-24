package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.t.b;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableGroupJoin$LeftRightEndSubscriber extends AtomicReference<d> implements g<Object>, b {
    public static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final f.a.x.e.a.g parent;

    public FlowableGroupJoin$LeftRightEndSubscriber(f.a.x.e.a.g gVar, boolean z, int i) {
        this.parent = gVar;
        this.isLeft = z;
        this.index = i;
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

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
