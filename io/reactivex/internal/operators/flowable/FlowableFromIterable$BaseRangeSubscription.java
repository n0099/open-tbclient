package io.reactivex.internal.operators.flowable;

import f.b.x.b.a;
import f.b.x.i.b;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class FlowableFromIterable$BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
    public static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public Iterator<? extends T> it;
    public boolean once;

    public FlowableFromIterable$BaseRangeSubscription(Iterator<? extends T> it) {
        this.it = it;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, g.d.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.b.x.c.f
    public final void clear() {
        this.it = null;
    }

    public abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.b.x.c.f
    public final boolean isEmpty() {
        Iterator<? extends T> it = this.it;
        return it == null || !it.hasNext();
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.b.x.c.f
    public final T poll() {
        Iterator<? extends T> it = this.it;
        if (it == null) {
            return null;
        }
        if (!this.once) {
            this.once = true;
        } else if (!it.hasNext()) {
            return null;
        }
        T next = this.it.next();
        a.b(next, "Iterator.next() returned a null value");
        return next;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, g.d.d
    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && b.a(this, j) == 0) {
            if (j == Long.MAX_VALUE) {
                fastPath();
            } else {
                slowPath(j);
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.b.x.c.c
    public final int requestFusion(int i) {
        return i & 1;
    }

    public abstract void slowPath(long j);
}
