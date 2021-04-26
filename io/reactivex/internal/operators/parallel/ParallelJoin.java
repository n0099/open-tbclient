package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class ParallelJoin<T> extends Flowable<T> {
    public final boolean delayErrors;
    public final int prefetch;
    public final ParallelFlowable<? extends T> source;

    /* loaded from: classes7.dex */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        public static final long serialVersionUID = 8410034718427740355L;
        public final int limit;
        public final JoinSubscriptionBase<T> parent;
        public final int prefetch;
        public long produced;
        public volatile SimplePlainQueue<T> queue;

        public JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i2) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        public SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
                this.queue = spscArrayQueue;
                return spscArrayQueue;
            }
            return simplePlainQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.prefetch);
        }

        public void request(long j) {
            long j2 = this.produced + j;
            if (j2 >= this.limit) {
                this.produced = 0L;
                get().request(j2);
                return;
            }
            this.produced = j2;
        }

        public void requestOne() {
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
                return;
            }
            this.produced = j;
        }
    }

    /* loaded from: classes7.dex */
    public static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        public static final long serialVersionUID = 6312374661811000451L;

        public JoinSubscription(Subscriber<? super T> subscriber, int i2, int i3) {
            super(subscriber, i2, i3);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
            if (r13 == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
            if (r15 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
            if (r15 == false) goto L3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            boolean z;
            Object obj;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.actual;
            int i2 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th = this.errors.get();
                    if (th != null) {
                        cleanup();
                        subscriber.onError(th);
                        return;
                    }
                    boolean z2 = this.done.get() == 0;
                    int i3 = 0;
                    boolean z3 = true;
                    while (true) {
                        if (i3 >= joinInnerSubscriberArr.length) {
                            break;
                        }
                        JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i3];
                        SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                        if (simplePlainQueue != null && (obj = (T) simplePlainQueue.poll()) != null) {
                            subscriber.onNext(obj);
                            joinInnerSubscriber.requestOne();
                            j2++;
                            if (j2 == j) {
                                break;
                            }
                            z3 = false;
                        }
                        i3++;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th2 = this.errors.get();
                    if (th2 != null) {
                        cleanup();
                        subscriber.onError(th2);
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i4].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i4++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i2 && (i5 = addAndGet(-i2)) == 0) {
                    return;
                }
                i2 = i5;
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.actual.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        public static final long serialVersionUID = 3100232009247827843L;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public final JoinInnerSubscriber<T>[] subscribers;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger done = new AtomicInteger();

        public JoinSubscriptionBase(Subscriber<? super T> subscriber, int i2, int i3) {
            this.actual = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                joinInnerSubscriberArr[i4] = new JoinInnerSubscriber<>(this, i3);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        public void cancelAll() {
            int i2 = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i2 >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i2].cancel();
                i2++;
            }
        }

        public void cleanup() {
            int i2 = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i2 >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i2].queue = null;
                i2++;
            }
        }

        public abstract void drain();

        public abstract void onComplete();

        public abstract void onError(Throwable th);

        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        public static final long serialVersionUID = -5737965195918321883L;

        public JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i2, int i3) {
            super(subscriber, i2, i3);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
            if (r13 == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
            if (r15 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
            if (r18.errors.get() == null) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
            r3.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
            if (r15 == false) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            boolean z;
            Object obj;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.actual;
            int i2 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z2 = this.done.get() == 0;
                    int i3 = 0;
                    boolean z3 = true;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i3];
                        SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                        if (simplePlainQueue != null && (obj = (T) simplePlainQueue.poll()) != null) {
                            subscriber.onNext(obj);
                            joinInnerSubscriber.requestOne();
                            j2++;
                            if (j2 == j) {
                                break;
                            }
                            z3 = false;
                        }
                        i3++;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i4].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i4++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        if (this.errors.get() != null) {
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i2 && (i5 = addAndGet(-i2)) == 0) {
                    return;
                }
                i2 = i5;
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i2, boolean z) {
        this.source = parallelFlowable;
        this.prefetch = i2;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscription;
        if (this.delayErrors) {
            joinSubscription = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscription = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscription);
        this.source.subscribe(joinSubscription.subscribers);
    }
}
