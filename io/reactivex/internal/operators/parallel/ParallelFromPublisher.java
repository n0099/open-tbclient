package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    public final int parallelism;
    public final int prefetch;
    public final Publisher<? extends T> source;

    /* loaded from: classes7.dex */
    public static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        public static final long serialVersionUID = -4470634016609963609L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final long[] emissions;
        public Throwable error;
        public int index;
        public final int limit;
        public final int prefetch;
        public int produced;
        public SimpleQueue<T> queue;
        public final AtomicLongArray requests;
        public Subscription s;
        public int sourceMode;
        public final AtomicInteger subscriberCount = new AtomicInteger();
        public final Subscriber<? super T>[] subscribers;

        /* loaded from: classes7.dex */
        public final class RailSubscription implements Subscription {
            public final int j;
            public final int m;

            public RailSubscription(int i2, int i3) {
                this.j = i2;
                this.m = i3;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.j + this.m, 0L, 1L)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i2 = this.m;
                    parallelDispatcher.cancel(i2 + i2);
                }
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
                long j2;
                if (SubscriptionHelper.validate(j)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.requests;
                    do {
                        j2 = atomicLongArray.get(this.j);
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.j, j2, BackpressureHelper.addCap(j2, j)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.m) {
                        ParallelDispatcher.this.drain();
                    }
                }
            }
        }

        public ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i2) {
            this.subscribers = subscriberArr;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            int length = subscriberArr.length;
            int i3 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i3 + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(i3, length);
            this.emissions = new long[length];
        }

        public void cancel(int i2) {
            if (this.requests.decrementAndGet(i2) == 0) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        public void drainAsync() {
            Throwable th;
            SimpleQueue<T> simpleQueue = this.queue;
            Subscriber<? super T>[] subscriberArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i2 = this.index;
            int i3 = this.produced;
            int i4 = 1;
            while (true) {
                int i5 = 0;
                int i6 = 0;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        simpleQueue.clear();
                        int length2 = subscriberArr.length;
                        while (i5 < length2) {
                            subscriberArr[i5].onError(th);
                            i5++;
                        }
                        return;
                    }
                    boolean isEmpty = simpleQueue.isEmpty();
                    if (z && isEmpty) {
                        int length3 = subscriberArr.length;
                        while (i5 < length3) {
                            subscriberArr[i5].onComplete();
                            i5++;
                        }
                        return;
                    }
                    if (!isEmpty) {
                        long j = atomicLongArray.get(i2);
                        long j2 = jArr[i2];
                        if (j == j2 || atomicLongArray.get(length + i2) != 0) {
                            i6++;
                        } else {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll != null) {
                                    subscriberArr[i2].onNext(poll);
                                    jArr[i2] = j2 + 1;
                                    i3++;
                                    if (i3 == this.limit) {
                                        this.s.request(i3);
                                        i3 = 0;
                                    }
                                    i6 = 0;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.s.cancel();
                                int length4 = subscriberArr.length;
                                while (i5 < length4) {
                                    subscriberArr[i5].onError(th2);
                                    i5++;
                                }
                                return;
                            }
                        }
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                            continue;
                        }
                        if (i6 == length) {
                        }
                    }
                    int i7 = get();
                    if (i7 == i4) {
                        this.index = i2;
                        this.produced = i3;
                        i4 = addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    } else {
                        i4 = i7;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        public void drainSync() {
            SimpleQueue<T> simpleQueue = this.queue;
            Subscriber<? super T>[] subscriberArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i2 = this.index;
            int i3 = 1;
            while (true) {
                int i4 = 0;
                int i5 = 0;
                while (!this.cancelled) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = subscriberArr.length;
                        while (i4 < length2) {
                            subscriberArr[i4].onComplete();
                            i4++;
                        }
                        return;
                    }
                    long j = atomicLongArray.get(i2);
                    long j2 = jArr[i2];
                    if (j == j2 || atomicLongArray.get(length + i2) != 0) {
                        i5++;
                    } else {
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                int length3 = subscriberArr.length;
                                while (i4 < length3) {
                                    subscriberArr[i4].onComplete();
                                    i4++;
                                }
                                return;
                            }
                            subscriberArr[i2].onNext(poll);
                            jArr[i2] = j2 + 1;
                            i5 = 0;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.s.cancel();
                            int length4 = subscriberArr.length;
                            while (i4 < length4) {
                                subscriberArr[i4].onError(th);
                                i4++;
                            }
                            return;
                        }
                    }
                    i2++;
                    if (i2 == length) {
                        i2 = 0;
                        continue;
                    }
                    if (i5 == length) {
                        int i6 = get();
                        if (i6 == i3) {
                            this.index = i2;
                            i3 = addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        } else {
                            i3 = i6;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                this.s.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
                return;
            }
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                setupSubscribers();
                subscription.request(this.prefetch);
            }
        }

        public void setupSubscribers() {
            Subscriber<? super T>[] subscriberArr = this.subscribers;
            int length = subscriberArr.length;
            int i2 = 0;
            while (i2 < length && !this.cancelled) {
                int i3 = i2 + 1;
                this.subscriberCount.lazySet(i3);
                subscriberArr[i2].onSubscribe(new RailSubscription(i2, length));
                i2 = i3;
            }
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i2, int i3) {
        this.source = publisher;
        this.parallelism = i2;
        this.prefetch = i3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.parallelism;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            this.source.subscribe(new ParallelDispatcher(subscriberArr, this.prefetch));
        }
    }
}
