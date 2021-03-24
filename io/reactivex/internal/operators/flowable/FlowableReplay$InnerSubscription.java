package io.reactivex.internal.operators.flowable;

import f.a.t.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableReplay$InnerSubscription<T> extends AtomicLong implements d, b {
    public static final long CANCELLED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public final c<? super T> child;
    public boolean emitting;
    public Object index;
    public boolean missed;
    public final FlowableReplay$ReplaySubscriber<T> parent;
    public final AtomicLong totalRequested = new AtomicLong();

    public FlowableReplay$InnerSubscription(FlowableReplay$ReplaySubscriber<T> flowableReplay$ReplaySubscriber, c<? super T> cVar) {
        this.parent = flowableReplay$ReplaySubscriber;
        this.child = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        dispose();
    }

    @Override // f.a.t.b
    public void dispose() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.remove(this);
            this.parent.manageRequests();
        }
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == Long.MIN_VALUE;
    }

    public long produced(long j) {
        return f.a.x.i.b.f(this, j);
    }

    @Override // g.d.d
    public void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
            } while (!compareAndSet(j2, f.a.x.i.b.c(j2, j)));
            f.a.x.i.b.a(this.totalRequested, j);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
        }
    }
}
