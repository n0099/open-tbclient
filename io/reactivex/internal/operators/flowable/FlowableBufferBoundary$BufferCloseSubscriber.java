package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.t.b;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableBufferBoundary$BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<d> implements g<Object>, b {
    public static final long serialVersionUID = -8498650778633225126L;
    public final long index;
    public final FlowableBufferBoundary$BufferBoundarySubscriber<T, C, ?, ?> parent;

    public FlowableBufferBoundary$BufferCloseSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<T, C, ?, ?> flowableBufferBoundary$BufferBoundarySubscriber, long j) {
        this.parent = flowableBufferBoundary$BufferBoundarySubscriber;
        this.index = j;
    }

    @Override // f.b.t.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // g.d.c
    public void onComplete() {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.close(this, this.index);
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            this.parent.boundaryError(this, th);
            return;
        }
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            dVar.cancel();
            this.parent.close(this, this.index);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
