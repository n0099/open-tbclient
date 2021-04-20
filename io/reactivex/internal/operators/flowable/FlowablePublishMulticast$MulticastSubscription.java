package io.reactivex.internal.operators.flowable;

import f.b.x.e.a.i;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowablePublishMulticast$MulticastSubscription<T> extends AtomicLong implements d {
    public static final long serialVersionUID = 8664815189257569791L;
    public final c<? super T> actual;
    public final i<T> parent;

    public FlowablePublishMulticast$MulticastSubscription(c<? super T> cVar, i<T> iVar) {
        this.actual = cVar;
        this.parent = iVar;
    }

    @Override // g.d.d
    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.e(this);
            this.parent.d();
        }
    }

    public boolean isCancelled() {
        return get() == Long.MIN_VALUE;
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.b(this, j);
            this.parent.d();
        }
    }
}
