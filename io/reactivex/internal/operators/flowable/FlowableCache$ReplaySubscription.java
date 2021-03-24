package io.reactivex.internal.operators.flowable;

import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableCache$ReplaySubscription<T> extends AtomicInteger implements d {
    public static final long serialVersionUID = -2557562030197141021L;
    public final c<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public int index;
    public final AtomicLong requested = new AtomicLong();
    public final f.a.x.e.a.c<T> state;

    public FlowableCache$ReplaySubscription(c<? super T> cVar, f.a.x.e.a.c<T> cVar2) {
        this.child = cVar;
        this.state = cVar2;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.requested.getAndSet(-1L) == -1) {
            return;
        }
        this.state.b(this);
        throw null;
    }

    public void replay() {
        if (getAndIncrement() == 0 && this.requested.get() >= 0) {
            this.state.a();
            throw null;
        }
    }

    @Override // g.d.d
    public void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = this.requested.get();
                if (j2 == -1) {
                    return;
                }
            } while (!this.requested.compareAndSet(j2, b.c(j2, j)));
            replay();
        }
    }
}
