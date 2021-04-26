package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    public final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    public final Publisher<? extends Open> bufferOpen;
    public final Callable<U> bufferSupplier;

    /* loaded from: classes7.dex */
    public static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -8466418554264089604L;
        public final Subscriber<? super C> actual;
        public final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
        public final Publisher<? extends Open> bufferOpen;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public volatile boolean done;
        public long emitted;
        public long index;
        public final SpscLinkedArrayQueue<C> queue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        public final CompositeDisposable subscribers = new CompositeDisposable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public Map<Long, C> buffers = new LinkedHashMap();
        public final AtomicThrowable errors = new AtomicThrowable();

        /* loaded from: classes7.dex */
        public static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            public static final long serialVersionUID = -8498650778633225126L;
            public final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            public BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.parent = bufferBoundarySubscriber;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.openComplete(this);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<C> callable) {
            this.actual = subscriber;
            this.bufferSupplier = callable;
            this.bufferOpen = publisher;
            this.bufferClose = function;
        }

        public void boundaryError(Disposable disposable, Throwable th) {
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.delete(disposable);
            onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        public void close(BufferCloseSubscriber<T, C> bufferCloseSubscriber, long j) {
            boolean z;
            this.subscribers.delete(bufferCloseSubscriber);
            if (this.subscribers.size() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                if (this.buffers == null) {
                    return;
                }
                this.queue.offer(this.buffers.remove(Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                drain();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
            if (r8 != 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
            if (r12.cancelled == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
            r3.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
            if (r12.done == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
            if (r12.errors.get() == null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
            r3.clear();
            r2.onError(r12.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
            if (r3.isEmpty() == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
            r12.emitted = r0;
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j = this.emitted;
            Subscriber<? super C> subscriber = this.actual;
            SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                while (true) {
                    int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i3 == 0) {
                        break;
                    } else if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (z && this.errors.get() != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(this.errors.terminate());
                            return;
                        }
                        C poll = spscLinkedArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            subscriber.onComplete();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext(poll);
                            j++;
                        }
                    }
                }
            } while (i2 != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscribers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                for (C c2 : map.values()) {
                    this.queue.offer(c2);
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                for (C c2 : map.values()) {
                    c2.add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.subscribers.add(bufferOpenSubscriber);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.Map<java.lang.Long, C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void open(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.bufferClose.apply(open), "The bufferClose returned a null Publisher");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == 0) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j);
                    this.subscribers.add(bufferCloseSubscriber);
                    publisher.subscribe(bufferCloseSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                SubscriptionHelper.cancel(this.upstream);
                onError(th);
            }
        }

        public void openComplete(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.subscribers.delete(bufferOpenSubscriber);
            if (this.subscribers.size() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.requested, j);
            drain();
        }
    }

    /* loaded from: classes7.dex */
    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        public static final long serialVersionUID = -8498650778633225126L;
        public final long index;
        public final BufferBoundarySubscriber<T, C, ?, ?> parent;

        public BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j) {
            this.parent = bufferBoundarySubscriber;
            this.index = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.close(this, this.index);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.boundaryError(this, th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<U> callable) {
        super(flowable);
        this.bufferOpen = publisher;
        this.bufferClose = function;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.bufferOpen, this.bufferClose, this.bufferSupplier);
        subscriber.onSubscribe(bufferBoundarySubscriber);
        this.source.subscribe((FlowableSubscriber) bufferBoundarySubscriber);
    }
}
