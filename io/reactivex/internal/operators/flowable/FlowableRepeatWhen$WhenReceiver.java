package io.reactivex.internal.operators.flowable;

import f.a.g;
import g.d.b;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableRepeatWhen$WhenReceiver<T, U> extends AtomicInteger implements g<Object>, d {
    public static final long serialVersionUID = 2827772011130406689L;
    public final b<T> source;
    public FlowableRepeatWhen$WhenSourceSubscriber<T, U> subscriber;
    public final AtomicReference<d> subscription = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableRepeatWhen$WhenReceiver(b<T> bVar) {
        this.source = bVar;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.subscription);
    }

    @Override // g.d.c
    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.subscriber.cancel();
        this.subscriber.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        if (getAndIncrement() == 0) {
            while (!SubscriptionHelper.isCancelled(this.subscription.get())) {
                this.source.subscribe(this.subscriber);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.subscription, this.requested, dVar);
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.subscription, this.requested, j);
    }
}
