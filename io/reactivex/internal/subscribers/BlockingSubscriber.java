package io.reactivex.internal.subscribers;

import f.b.g;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class BlockingSubscriber<T> extends AtomicReference<d> implements g<T>, d {
    public static final Object TERMINATED = new Object();
    public static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // g.d.d
    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // g.d.c
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    @Override // g.d.d
    public void request(long j) {
        get().request(j);
    }
}
