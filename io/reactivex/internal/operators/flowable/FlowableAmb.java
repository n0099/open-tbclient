package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableAmb<T> extends Flowable<T> {
    public final Publisher<? extends T>[] sources;
    public final Iterable<? extends Publisher<? extends T>> sourcesIterable;

    /* loaded from: classes7.dex */
    public static final class AmbCoordinator<T> implements Subscription {
        public final Subscriber<? super T> actual;
        public final AmbInnerSubscriber<T>[] subscribers;
        public final AtomicInteger winner = new AtomicInteger();

        public AmbCoordinator(Subscriber<? super T> subscriber, int i2) {
            this.actual = subscriber;
            this.subscribers = new AmbInnerSubscriber[i2];
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.subscribers) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                int i2 = this.winner.get();
                if (i2 > 0) {
                    this.subscribers[i2 - 1].request(j);
                } else if (i2 == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.subscribers) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }

        public void subscribe(Publisher<? extends T>[] publisherArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
            int length = ambInnerSubscriberArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                ambInnerSubscriberArr[i2] = new AmbInnerSubscriber<>(this, i3, this.actual);
                i2 = i3;
            }
            this.winner.lazySet(0);
            this.actual.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.winner.get() == 0; i4++) {
                publisherArr[i4].subscribe(ambInnerSubscriberArr[i4]);
            }
        }

        public boolean win(int i2) {
            int i3 = 0;
            if (this.winner.get() == 0 && this.winner.compareAndSet(0, i2)) {
                AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
                int length = ambInnerSubscriberArr.length;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    if (i4 != i2) {
                        ambInnerSubscriberArr[i3].cancel();
                    }
                    i3 = i4;
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -1185974347409665484L;
        public final Subscriber<? super T> actual;
        public final int index;
        public final AtomicLong missedRequested = new AtomicLong();
        public final AmbCoordinator<T> parent;
        public boolean won;

        public AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i2, Subscriber<? super T> subscriber) {
            this.parent = ambCoordinator;
            this.index = i2;
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.actual.onComplete();
            } else {
                get().cancel();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                get().cancel();
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.actual.onNext(t);
            } else {
                get().cancel();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
        }
    }

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.sources;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher<? extends T> publisher : this.sourcesIterable) {
                    if (publisher == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (length == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    int i2 = length + 1;
                    publisherArr[length] = publisher;
                    length = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(subscriber);
        } else if (length == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            new AmbCoordinator(subscriber, length).subscribe(publisherArr);
        }
    }
}
