package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
    public final long limit;

    /* loaded from: classes7.dex */
    public static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -5636543848937116287L;
        public final Subscriber<? super T> actual;
        public boolean done;
        public final long limit;
        public long remaining;
        public Subscription subscription;

        public TakeSubscriber(Subscriber<? super T> subscriber, long j) {
            this.actual = subscriber;
            this.limit = j;
            this.remaining = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                return;
            }
            this.done = true;
            this.subscription.cancel();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.remaining;
            long j2 = j - 1;
            this.remaining = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.actual.onNext(t);
                if (z) {
                    this.subscription.cancel();
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.subscription, subscription)) {
                this.subscription = subscription;
                if (this.limit == 0) {
                    subscription.cancel();
                    this.done = true;
                    EmptySubscription.complete(this.actual);
                    return;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (!get() && compareAndSet(false, true) && j >= this.limit) {
                    this.subscription.request(Long.MAX_VALUE);
                } else {
                    this.subscription.request(j);
                }
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j) {
        super(flowable);
        this.limit = j;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new TakeSubscriber(subscriber, this.limit));
    }
}
