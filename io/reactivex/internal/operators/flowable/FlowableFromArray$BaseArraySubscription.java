package io.reactivex.internal.operators.flowable;

import f.a.x.b.a;
import f.a.x.i.b;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public abstract class FlowableFromArray$BaseArraySubscription<T> extends BasicQueueSubscription<T> {
    public static final long serialVersionUID = -2252972430506210021L;
    public final T[] array;
    public volatile boolean cancelled;
    public int index;

    public FlowableFromArray$BaseArraySubscription(T[] tArr) {
        this.array = tArr;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, g.d.d
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.a.x.c.f
    public final void clear() {
        this.index = this.array.length;
    }

    public abstract void fastPath();

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.a.x.c.f
    public final boolean isEmpty() {
        return this.index == this.array.length;
    }

    @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, f.a.x.c.f
    public final T poll() {
        int i = this.index;
        T[] tArr = this.array;
        if (i == tArr.length) {
            return null;
        }
        this.index = i + 1;
        T t = tArr[i];
        a.b(t, "array element is null");
        return t;
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
}
