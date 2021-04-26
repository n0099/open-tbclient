package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    public final AtomicReference<Subscriber<? super T>> actual;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public boolean enableOperatorFusion;
    public Throwable error;
    public final AtomicReference<Runnable> onTerminate;
    public final AtomicBoolean once;
    public final SpscLinkedArrayQueue<T> queue;
    public final AtomicLong requested;
    public final BasicIntQueueSubscription<T> wip;

    /* loaded from: classes7.dex */
    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        public static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.cancelled) {
                return;
            }
            UnicastProcessor.this.cancelled = true;
            UnicastProcessor.this.doTerminate();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (unicastProcessor.enableOperatorFusion || unicastProcessor.wip.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.queue.clear();
            UnicastProcessor.this.actual.lazySet(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, j);
                UnicastProcessor.this.drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) != 0) {
                UnicastProcessor.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastProcessor(int i2) {
        this(i2, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize());
    }

    public boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.cancelled) {
            spscLinkedArrayQueue.clear();
            this.actual.lazySet(null);
            return true;
        } else if (z2) {
            if (z && this.error != null) {
                spscLinkedArrayQueue.clear();
                this.actual.lazySet(null);
                subscriber.onError(this.error);
                return true;
            } else if (z3) {
                Throwable th = this.error;
                this.actual.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void doTerminate() {
        Runnable andSet = this.onTerminate.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        int i2 = 1;
        Subscriber<? super T> subscriber = this.actual.get();
        while (subscriber == null) {
            i2 = this.wip.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            subscriber = this.actual.get();
        }
        if (this.enableOperatorFusion) {
            drainFused(subscriber);
        } else {
            drainRegular(subscriber);
        }
    }

    public void drainFused(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i2 = 1;
        boolean z = !this.delayError;
        while (!this.cancelled) {
            boolean z2 = this.done;
            if (z && z2 && this.error != null) {
                spscLinkedArrayQueue.clear();
                this.actual.lazySet(null);
                subscriber.onError(this.error);
                return;
            }
            subscriber.onNext(null);
            if (z2) {
                this.actual.lazySet(null);
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i2 = this.wip.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.actual.lazySet(null);
    }

    public void drainRegular(Subscriber<? super T> subscriber) {
        int i2;
        long j;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z = !this.delayError;
        int i3 = 1;
        while (true) {
            long j2 = this.requested.get();
            long j3 = 0;
            while (true) {
                i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i2 == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                j = j3;
                if (checkTerminated(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z3) {
                    break;
                }
                subscriber.onNext(poll);
                j3 = 1 + j;
            }
            if (i2 == 0 && checkTerminated(z, this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j);
            }
            i3 = this.wip.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.actual.get() != null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done || this.cancelled) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.cancelled) {
            this.error = th;
            this.done = true;
            doTerminate();
            drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done || this.cancelled) {
            return;
        }
        this.queue.offer(t);
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (!this.done && !this.cancelled) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.cancel();
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            subscriber.onSubscribe(this.wip);
            this.actual.set(subscriber);
            if (this.cancelled) {
                this.actual.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    public UnicastProcessor(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i2) {
        return new UnicastProcessor<>(i2);
    }

    public UnicastProcessor(int i2, Runnable runnable, boolean z) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.onTerminate = new AtomicReference<>(runnable);
        this.delayError = z;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(boolean z) {
        return new UnicastProcessor<>(Flowable.bufferSize(), null, z);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i2, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i2, runnable);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(int i2, Runnable runnable, boolean z) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i2, runnable, z);
    }
}
