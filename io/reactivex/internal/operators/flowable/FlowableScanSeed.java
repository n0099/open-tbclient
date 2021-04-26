package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public final BiFunction<R, ? super T, R> accumulator;
    public final Callable<R> seedSupplier;

    /* loaded from: classes7.dex */
    public static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -1776795561228106469L;
        public final BiFunction<R, ? super T, R> accumulator;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public final SimplePlainQueue<R> queue;
        public final AtomicLong requested;
        public Subscription s;
        public R value;

        public ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i2) {
            this.actual = subscriber;
            this.accumulator = biFunction;
            this.value = r;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i2);
            this.queue = spscArrayQueue;
            spscArrayQueue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            int i2;
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.actual;
            SimplePlainQueue<R> simplePlainQueue = this.queue;
            int i3 = this.limit;
            int i4 = this.consumed;
            int i5 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.cancelled) {
                        simplePlainQueue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (z && (th = this.error) != null) {
                            simplePlainQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                        Object obj = (R) simplePlainQueue.poll();
                        boolean z2 = obj == null;
                        if (z && z2) {
                            subscriber.onComplete();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext(obj);
                            j2++;
                            i4++;
                            if (i4 == i3) {
                                this.s.request(i3);
                                i4 = 0;
                            }
                        }
                    }
                }
                if (i2 == 0 && this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th2);
                        return;
                    } else if (simplePlainQueue.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.produced(this.requested, j2);
                }
                this.consumed = i4;
                i5 = addAndGet(-i5);
            } while (i5 != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                R r = (R) ObjectHelper.requireNonNull(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = r;
                this.queue.offer(r);
                drain();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch - 1);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.accumulator = biFunction;
        this.seedSupplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.source.subscribe((FlowableSubscriber) new ScanSeedSubscriber(subscriber, this.accumulator, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null"), Flowable.bufferSize()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
