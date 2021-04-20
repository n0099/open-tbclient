package io.reactivex.internal.operators.flowable;

import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowablePublish$InnerSubscriber<T> extends AtomicLong implements d {
    public static final long serialVersionUID = -4453897557930727610L;
    public final c<? super T> child;
    public volatile FlowablePublish$PublishSubscriber<T> parent;

    public FlowablePublish$InnerSubscriber(c<? super T> cVar) {
        this.child = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        FlowablePublish$PublishSubscriber<T> flowablePublish$PublishSubscriber;
        if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (flowablePublish$PublishSubscriber = this.parent) == null) {
            return;
        }
        flowablePublish$PublishSubscriber.remove(this);
        flowablePublish$PublishSubscriber.dispatch();
    }

    public long produced(long j) {
        return b.f(this, j);
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.b(this, j);
            FlowablePublish$PublishSubscriber<T> flowablePublish$PublishSubscriber = this.parent;
            if (flowablePublish$PublishSubscriber != null) {
                flowablePublish$PublishSubscriber.dispatch();
            }
        }
    }
}
