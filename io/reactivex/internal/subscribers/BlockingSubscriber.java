package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes17.dex */
public final class BlockingSubscriber<T> extends AtomicReference<d> implements j<T>, d {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // org.a.c
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // org.a.d
    public void request(long j) {
        get().request(j);
    }

    @Override // org.a.d
    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }
}
