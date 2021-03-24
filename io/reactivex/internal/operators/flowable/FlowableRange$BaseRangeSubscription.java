package io.reactivex.internal.operators.flowable;

import f.a.x.i.b;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public abstract class FlowableRange$BaseRangeSubscription extends BasicQueueSubscription<Integer> {
    public static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final int end;
    public int index;

    public FlowableRange$BaseRangeSubscription(int i, int i2) {
        this.index = i;
        this.end = i2;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, g.d.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.a.x.c.f
    public final void clear() {
        this.index = this.end;
    }

    public abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.a.x.c.f
    public final boolean isEmpty() {
        return this.index == this.end;
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

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.a.x.c.c
    public final int requestFusion(int i) {
        return i & 1;
    }

    public abstract void slowPath(long j);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.a.x.c.f
    public final Integer poll() {
        int i = this.index;
        if (i == this.end) {
            return null;
        }
        this.index = i + 1;
        return Integer.valueOf(i);
    }
}
