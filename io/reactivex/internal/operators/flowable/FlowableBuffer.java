package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    public final Callable<C> bufferSupplier;
    public final int size;
    public final int skip;

    /* loaded from: classes7.dex */
    public static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super C> actual;
        public C buffer;
        public final Callable<C> bufferSupplier;
        public boolean done;
        public int index;
        public Subscription s;
        public final int size;

        public PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i2, Callable<C> callable) {
            this.actual = subscriber;
            this.size = i2;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c2 = this.buffer;
            if (c2 != null && !c2.isEmpty()) {
                this.actual.onNext(c2);
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C c2 = this.buffer;
            if (c2 == null) {
                try {
                    c2 = (C) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c2;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c2.add(t);
            int i2 = this.index + 1;
            if (i2 == this.size) {
                this.index = 0;
                this.buffer = null;
                this.actual.onNext(c2);
                return;
            }
            this.index = i2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.s.request(BackpressureHelper.multiplyCap(j, this.size));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        public static final long serialVersionUID = -7370244972039324525L;
        public final Subscriber<? super C> actual;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public boolean done;
        public int index;
        public long produced;
        public Subscription s;
        public final int size;
        public final int skip;
        public final AtomicBoolean once = new AtomicBoolean();
        public final ArrayDeque<C> buffers = new ArrayDeque<>();

        public PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i2, int i3, Callable<C> callable) {
            this.actual = subscriber;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j = this.produced;
            if (j != 0) {
                BackpressureHelper.produced(this, j);
            }
            QueueDrainHelper.postComplete(this.actual, this.buffers, this, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.actual.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.ArrayDeque<C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    arrayDeque.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t);
                this.produced++;
                this.actual.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!SubscriptionHelper.validate(j) || QueueDrainHelper.postCompleteRequest(j, this.actual, this.buffers, this, this)) {
                return;
            }
            if (!this.once.get() && this.once.compareAndSet(false, true)) {
                this.s.request(BackpressureHelper.addCap(this.size, BackpressureHelper.multiplyCap(this.skip, j - 1)));
                return;
            }
            this.s.request(BackpressureHelper.multiplyCap(this.skip, j));
        }
    }

    /* loaded from: classes7.dex */
    public static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -5616169793639412593L;
        public final Subscriber<? super C> actual;
        public C buffer;
        public final Callable<C> bufferSupplier;
        public boolean done;
        public int index;
        public Subscription s;
        public final int size;
        public final int skip;

        public PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i2, int i3, Callable<C> callable) {
            this.actual = subscriber;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c2 = this.buffer;
            this.buffer = null;
            if (c2 != null) {
                this.actual.onNext(c2);
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C c2 = this.buffer;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    c2 = (C) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c2;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c2 != null) {
                c2.add(t);
                if (c2.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c2);
                }
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.s.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j, this.size), BackpressureHelper.multiplyCap(this.skip - this.size, j - 1)));
                    return;
                }
                this.s.request(BackpressureHelper.multiplyCap(this.skip, j));
            }
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i2, int i3, Callable<C> callable) {
        super(flowable);
        this.size = i2;
        this.skip = i3;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super C> subscriber) {
        int i2 = this.size;
        int i3 = this.skip;
        if (i2 == i3) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferExactSubscriber(subscriber, i2, this.bufferSupplier));
        } else if (i3 > i2) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferSkipSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        } else {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferOverlappingSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        }
    }
}
