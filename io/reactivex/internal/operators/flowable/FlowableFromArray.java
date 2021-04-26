package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    public final T[] array;

    /* loaded from: classes7.dex */
    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        public static final long serialVersionUID = 2587302975077663557L;
        public final ConditionalSubscriber<? super T> actual;

        public ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    conditionalSubscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                conditionalSubscriber.tryOnNext(t);
            }
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i2 = this.index;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i2 == length) {
                        if (i2 == length) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        }
                        j = get();
                        if (j2 == j) {
                            this.index = i2;
                            j = addAndGet(-j2);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        T t = tArr[i2];
                        if (t == null) {
                            conditionalSubscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        if (conditionalSubscriber.tryOnNext(t)) {
                            j2++;
                        }
                        i2++;
                    }
                }
            } while (j != 0);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        public static final long serialVersionUID = 2587302975077663557L;
        public final Subscriber<? super T> actual;

        public ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    subscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                subscriber.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            subscriber.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i2 = this.index;
            Subscriber<? super T> subscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i2 == length) {
                        if (i2 == length) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                        j = get();
                        if (j2 == j) {
                            this.index = i2;
                            j = addAndGet(-j2);
                        }
                    } else if (this.cancelled) {
                        return;
                    } else {
                        T t = tArr[i2];
                        if (t == null) {
                            subscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        subscriber.onNext(t);
                        j2++;
                        i2++;
                    }
                }
            } while (j != 0);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        public static final long serialVersionUID = -2252972430506210021L;
        public final T[] array;
        public volatile boolean cancelled;
        public int index;

        public BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            int i2 = this.index;
            T[] tArr = this.array;
            if (i2 == tArr.length) {
                return null;
            }
            this.index = i2 + 1;
            return (T) ObjectHelper.requireNonNull(tArr[i2], "array element is null");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i2) {
            return i2 & 1;
        }

        public abstract void slowPath(long j);
    }

    public FlowableFromArray(T[] tArr) {
        this.array = tArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.array));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.array));
        }
    }
}
